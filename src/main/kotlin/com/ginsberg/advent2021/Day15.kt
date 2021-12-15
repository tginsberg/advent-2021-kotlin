/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 15 - Chiton
 * Problem Description: http://adventofcode.com/2021/day/15
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day15/
 */
package com.ginsberg.advent2021

import java.util.PriorityQueue

typealias ChitonCave = Array<IntArray>

class Day15(input: List<String>) {

    private val cave: ChitonCave = parseInput(input)

    fun solvePart1(): Int =
        cave.traverse()

    fun solvePart2(): Int =
        cave.traverse(
            Point2d((cave.first().size * 5) - 1, (cave.size * 5) - 1)
        )

    private fun ChitonCave.traverse(
        destination: Point2d = Point2d(first().lastIndex, lastIndex)
    ): Int {

        val toBeEvaluated = PriorityQueue<Traversal>().apply { add(Traversal(Point2d(0, 0), 0)) }
        val visited = mutableSetOf<Point2d>()

        while (toBeEvaluated.isNotEmpty()) {
            val thisPlace = toBeEvaluated.poll()
            if (thisPlace.point == destination) {
                return thisPlace.totalRisk
            }
            if (thisPlace.point !in visited) {
                visited.add(thisPlace.point)
                thisPlace.point
                    .neighbors()
                    .filter { it.x in (0..destination.x) && it.y in (0..destination.y) }
                    .forEach { toBeEvaluated.offer(Traversal(it, thisPlace.totalRisk + this[it])) }
            }
        }
        error("No path to destination (which is really weird, right?)")
    }

    private operator fun ChitonCave.get(point: Point2d): Int {
        val dx = point.x / this.first().size
        val dy = point.y / this.size
        val originalRisk = this[point.y % this.size][point.x % this.first().size]
        val newRisk = (originalRisk + dx + dy)
        return newRisk.takeIf { it < 10 } ?: (newRisk - 9)
    }

    private fun parseInput(input: List<String>): ChitonCave =
        input.map { row ->
            row.map { risk ->
                risk.digitToInt()
            }.toIntArray()
        }.toTypedArray()

    private class Traversal(val point: Point2d, val totalRisk: Int) : Comparable<Traversal> {
        override fun compareTo(other: Traversal): Int =
            this.totalRisk - other.totalRisk
    }
}