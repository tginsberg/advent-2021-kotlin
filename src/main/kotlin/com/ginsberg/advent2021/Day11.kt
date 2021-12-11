/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 11 - Dumbo Octopus
 * Problem Description: http://adventofcode.com/2021/day/11
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day11/
 */
package com.ginsberg.advent2021


typealias OctopusCave = Map<Point2d, Int>

class Day11(input: List<String>) {

    private val startingCave: OctopusCave = parseInput(input)

    fun solvePart1(): Int =
        startingCave.steps().take(100).sum()

    fun solvePart2(): Int =
        startingCave.steps().indexOfFirst { it == startingCave.size } + 1

    private fun OctopusCave.steps(): Sequence<Int> = sequence {
        val cave = this@steps.toMutableMap()

        while (true) {

            cave.forEach { (point, energy) -> cave[point] = energy + 1 }
            val flashersThisStep = mutableSetOf<Point2d>()

            do {
                val flashersThisRound = cave.filter { it.value > 9 && it.key !in flashersThisStep }.keys
                flashersThisStep.addAll(flashersThisRound)

                val neighborsOfFlashers = flashersThisRound
                    .flatMap { it.allNeighbors() }
                    .filter { it in cave && it !in flashersThisStep }

                neighborsOfFlashers.forEach { cave[it] = cave.getValue(it) + 1 }
            } while (flashersThisRound.isNotEmpty())

            flashersThisStep.forEach { cave[it] = 0 }

            yield(flashersThisStep.size)
        }
    }

    private fun parseInput(input: List<String>): OctopusCave =
        input.flatMapIndexed { y, row ->
            row.mapIndexed { x, energy -> Point2d(x, y) to energy.digitToInt() }
        }.toMap()
}
