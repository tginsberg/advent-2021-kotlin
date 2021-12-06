/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 6 - Lanternfish
 * Problem Description: http://adventofcode.com/2021/day/6
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day6/
 */
package com.ginsberg.advent2021

class Day06(input: String) {

    private val fishiesPerDay: LongArray = parseInput(input)

    fun solvePart1(): Long =
        simulateDays(80)

    fun solvePart2(): Long =
        simulateDays(256)

    private fun simulateDays(days: Int): Long {
        repeat(days) {
            fishiesPerDay.rotateLeftInPlace()
            fishiesPerDay[6] += fishiesPerDay[8]
        }
        return fishiesPerDay.sum()
    }

    private fun LongArray.rotateLeftInPlace() {
        val leftMost = first()
        this.copyInto(this, startIndex = 1)
        this[this.lastIndex] = leftMost
    }

    private fun parseInput(input: String): LongArray =
        LongArray(9).apply {
            input.split(",").map { it.toInt() }.forEach { this[it] += 1L }
        }
}
