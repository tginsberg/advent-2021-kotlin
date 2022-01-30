/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 10 - Syntax Scoring
 * Problem Description: http://adventofcode.com/2021/day/10
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day10/
 */
package com.ginsberg.advent2021

class Day10(private val input: List<String>) {

    fun solvePart1(): Int =
        input
            .map { parseRow(it) }
            .filterIsInstance<Corrupted>()
            .sumOf { it.score() }

    fun solvePart2(): Long =
        input
            .map { parseRow(it) }
            .filterIsInstance<Incomplete>()
            .map { it.score() }
            .sorted()
            .midpoint()

    private fun parseRow(row: String): ParseResult {
        val stack = ArrayDeque<Char>()

        row.forEach { symbol ->
            when {
                symbol in openToClose -> stack.addLast(symbol)
                openToClose[stack.removeLast()] != symbol -> return Corrupted(symbol)
            }
        }

        return if (stack.isEmpty()) Success else Incomplete(stack.reversed())
    }

    private sealed interface ParseResult
    private object Success : ParseResult
    private class Corrupted(val actual: Char) : ParseResult {
        fun score(): Int =
            scoresPart1.getValue(actual)
    }
    private class Incomplete(val pending: List<Char>) : ParseResult {
        fun score(): Long =
            pending
                .map { openToClose.getValue(it) }
                .fold(0L) { carry, symbol ->
                    (carry * 5) + scoresPart2.getValue(symbol)
                }
    }

    companion object {
        private val scoresPart1 = mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)
        private val scoresPart2 = mapOf(')' to 1, ']' to 2, '}' to 3, '>' to 4)
        private val openToClose = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>')
    }
}
