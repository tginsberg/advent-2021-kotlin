/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 18 - Snailfish
 * Problem Description: http://adventofcode.com/2021/day/18
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day18/
 */
package com.ginsberg.advent2021

import kotlin.math.ceil
import kotlin.math.floor


class Day18(private val input: List<String>) {

    fun solvePart1(): Int =
        input.map { SnailfishNumber.of(it) }.reduce { a, b -> a + b }.magnitude()

    fun solvePart2(): Int =
        input.mapIndexed { index, left ->
            input.drop(index + 1).map { right ->
                listOf(
                    SnailfishNumber.of(left) to SnailfishNumber.of(right),
                    SnailfishNumber.of(right) to SnailfishNumber.of(left)
                )
            }.flatten()
        }.flatten()
            .maxOf { (it.first + it.second).magnitude() }


    data class PairNumberDepth(val depth: Int, val pair: PairNumber)

    sealed class SnailfishNumber {
        var parent: SnailfishNumber? = null
        abstract fun magnitude(): Int
        abstract fun split(): Boolean
        abstract fun regularsInOrder(): List<RegularNumber>
        abstract fun pairsInOrderWithDepth(depth: Int = 0): List<PairNumberDepth>

        operator fun plus(other: SnailfishNumber): SnailfishNumber =
            PairNumber(this, other).apply { reduce() }

        fun reduce() {
            do {
                val didSomething = explode() || split()
            } while(didSomething)
        }

        private fun root(): SnailfishNumber =
            if (parent == null) this else parent!!.root()

        private fun explode(): Boolean {
            val pairs = root().pairsInOrderWithDepth()
            val explodingPair = pairs.firstOrNull { it.depth == 4 }?.pair
            if (explodingPair != null) {
                val regulars = root().regularsInOrder()
                regulars.elementAtOrNull(regulars.indexOfFirst { it === explodingPair.left } - 1)
                    ?.addValue(explodingPair.left as RegularNumber)
                regulars.elementAtOrNull(regulars.indexOfFirst { it === explodingPair.right } + 1)
                    ?.addValue(explodingPair.right as RegularNumber)
                (explodingPair.parent as PairNumber).childHasExploded(explodingPair)
                return true
            }
            return false
        }

        companion object {
            fun of(input: String): SnailfishNumber {
                val stack = mutableListOf<SnailfishNumber>()
                input.forEach { char ->
                    when {
                        char.isDigit() -> stack.add(RegularNumber(char.digitToInt()))
                        char == ']' -> {
                            val right = stack.removeLast()
                            val left = stack.removeLast()
                            stack.add(PairNumber(left, right))
                        }
                    }
                }
                return stack.removeFirst()
            }
        }
    }

    data class RegularNumber(var value: Int) : SnailfishNumber() {
        override fun magnitude(): Int = value
        override fun split(): Boolean = false
        override fun regularsInOrder(): List<RegularNumber> = listOf(this)
        override fun pairsInOrderWithDepth(depth: Int): List<PairNumberDepth> = emptyList()

        fun addValue(amount: RegularNumber) {
            this.value += amount.value
        }

        fun splitToPair(splitParent: SnailfishNumber): PairNumber =
            PairNumber(
                RegularNumber(floor(value.toDouble() / 2.0).toInt()),
                RegularNumber(ceil(value.toDouble() / 2.0).toInt())
            ).apply { this.parent = splitParent }

        override fun toString(): String =
            value.toString()
    }

    data class PairNumber(var left: SnailfishNumber, var right: SnailfishNumber) : SnailfishNumber() {
        init {
            left.parent = this
            right.parent = this
        }

        override fun magnitude(): Int = (left.magnitude() * 3) + (right.magnitude() * 2)

        fun childHasExploded(child: PairNumber) {
            val replacement = RegularNumber(0).apply { parent = this@PairNumber.parent }
            when {
                left === child -> left = replacement
                else -> right = replacement
            }
        }

        override fun regularsInOrder(): List<RegularNumber> =
            this.left.regularsInOrder() + this.right.regularsInOrder()

        override fun pairsInOrderWithDepth(depth: Int): List<PairNumberDepth> =
            this.left.pairsInOrderWithDepth(depth + 1) +
                listOf(PairNumberDepth(depth, this)) +
                this.right.pairsInOrderWithDepth(depth + 1)

        override fun split(): Boolean {
            if (left is RegularNumber) {
                val actualLeft = left as RegularNumber
                if (actualLeft.value >= 10) {
                    left = actualLeft.splitToPair(this)
                    return true
                }
            }
            val didSplit = left.split()
            if (didSplit) return true
            if (right is RegularNumber) {
                val actualRight = right as RegularNumber
                if (actualRight.value >= 10) {
                    right = actualRight.splitToPair(this)
                    return true
                }
            }
            return right.split()
        }

        override fun toString(): String =
            "[$left,$right]"
    }
}
