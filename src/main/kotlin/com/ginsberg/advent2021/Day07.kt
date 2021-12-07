/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 7 - The Treachery of Whales
 * Problem Description: http://adventofcode.com/2021/day/7
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day7/
 */
package com.ginsberg.advent2021

import kotlin.math.absoluteValue

class Day07(input: String) {

    private val crabs: Map<Int, Int> = input.split(",").map { it.toInt() }.groupingBy { it }.eachCount()

    fun solvePart1(): Int =
        solve { it }

    fun solvePart2(): Int =
        solve { distance ->
            (distance * (distance + 1)) / 2
        }

    private fun solve(fuelCost: (Int) -> Int): Int =
        crabs.keys.asRange().minOf { target ->
            crabs.map { (crab, crabCount) ->
                fuelCost((target - crab).absoluteValue) * crabCount
            }.sum()
        }

    private fun Set<Int>.asRange(): IntRange =
        this.minOf { it }..this.maxOf { it }
}
