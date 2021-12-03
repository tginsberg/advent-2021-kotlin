/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 3 - Binary Diagnostic
 * Problem Description: http://adventofcode.com/2021/day/3
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day3/
 */
package com.ginsberg.advent2021

import kotlin.math.pow

class Day03(private val input: List<String>) {

    private val inputWidth = input.first().length

    fun solvePart1(): Int {
        val gamma = (0 until inputWidth).sumOf { column ->
            val columnValue = (inputWidth - column - 1).binaryColumnValue()
            if (input.count { it[column] == '1' } > input.size / 2) columnValue else 0
        }
        return gamma * (inputWidth.maxBinaryValue() - gamma)
    }

    fun solvePart2(): Int =
        input.bitwiseFilter(true).toInt(2) * input.bitwiseFilter(false).toInt(2)

    private fun List<String>.bitwiseFilter(keepMostCommon: Boolean): String =
        (0 until inputWidth).fold(this) { inputs, column ->
            if (inputs.size == 1) inputs else {
                val split = inputs.partition { it[column] == '1' }
                if (keepMostCommon) split.longest() else split.shortest()
            }
        }.first()

    private fun Int.maxBinaryValue(): Int =
        binaryColumnValue() - 1

    private fun Int.binaryColumnValue(): Int =
        2.0.pow(this.toDouble()).toInt()

    private fun <T> Pair<List<T>, List<T>>.longest(): List<T> =
        if (first.size >= second.size) first else second

    private fun <T> Pair<List<T>, List<T>>.shortest(): List<T> =
        if (first.size < second.size) first else second
}
