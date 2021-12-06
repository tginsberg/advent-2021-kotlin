/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 5 - Hydrothermal Venture
 * Problem Description: http://adventofcode.com/2021/day/5
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day5/
 */
package com.ginsberg.advent2021

class Day05(input: List<String>) {

    private val instructions = input.map { parseRow(it) }

    fun solvePart1(): Int =
        solve { it.first sharesAxisWith it.second }

    fun solvePart2(): Int =
        solve { true }

    private fun solve(lineFilter: (Pair<Point2d, Point2d>) -> Boolean) =
        instructions
            .filter { lineFilter(it) }
            .flatMap { it.first lineTo it.second }
            .groupingBy { it }
            .eachCount()
            .count { it.value > 1 }

    private fun parseRow(input: String): Pair<Point2d, Point2d> =
        Pair(
            input.substringBefore(" ").split(",").map { it.toInt() }.let { Point2d(it.first(), it.last()) },
            input.substringAfterLast(" ").split(",").map { it.toInt() }.let { Point2d(it.first(), it.last()) }
        )
}
