/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 1 - Sonar Sweep
 * Problem Description: http://adventofcode.com/2021/day/1
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day1/
 */
package com.ginsberg.advent2021

class Day01(private val input: List<Int>) {

    fun solvePart1(): Int =
        input
            .zipWithNext()
            .count { it.first < it.second }

    fun solvePart2(): Int =
        input
            .windowed(3, 1) { it.sum() }
            .zipWithNext()
            .count { it.first < it.second }
}