/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 3 - Binary Diagnostic
 * Problem Description: http://adventofcode.com/2021/day/3
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day3/
 */
package com.ginsberg.advent2021

class Day03(private val input: List<String>) {

    fun solvePart1(): Int {
        val gamma = input.first().indices.map { column ->
            if (input.count { it[column] == '1' } > input.size / 2) '1' else '0'
        }.joinToString("")
        val epsilon = gamma.map { if (it == '1') '0' else '1' }.joinToString("")
        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun solvePart2(): Int =
        input.bitwiseFilter(true).toInt(2) * input.bitwiseFilter(false).toInt(2)

    private fun List<String>.bitwiseFilter(keepMostCommon: Boolean): String =
        first().indices.fold(this) { inputs, column ->
            if (inputs.size == 1) inputs else {
                val split = inputs.partition { it[column] == '1' }
                if (keepMostCommon) split.longest() else split.shortest()
            }
        }.first()

    private fun <T> Pair<List<T>, List<T>>.longest(): List<T> =
        if (first.size >= second.size) first else second

    private fun <T> Pair<List<T>, List<T>>.shortest(): List<T> =
        if (first.size < second.size) first else second
}
