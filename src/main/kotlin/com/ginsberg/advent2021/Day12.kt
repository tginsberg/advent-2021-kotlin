/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 12 - Passage Pathing
 * Problem Description: http://adventofcode.com/2021/day/12
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day12/
 */
package com.ginsberg.advent2021

class Day12(input: List<String>) {

    private val caves: Map<String, List<String>> = parseInput(input)

    fun solvePart1(): Int =
        traverse(::part1VisitRule).size

    fun solvePart2(): Int =
        traverse(::part2VisitRule).size

    private fun traverse(
        allowedToVisit: (String, List<String>) -> Boolean,
        path: List<String> = listOf("start")
    ): List<List<String>> =
        if (path.last() == "end") listOf(path)
        else caves.getValue(path.last())
            .filter { allowedToVisit(it, path) }
            .flatMap {
                traverse(allowedToVisit, path + it)
            }

    private fun part1VisitRule(name: String, path: List<String>): Boolean =
        name.isUpperCase() || name !in path

    private fun part2VisitRule(name: String, path: List<String>): Boolean =
        when {
            name.isUpperCase() -> true
            name == "start" -> false
            name !in path -> true
            else -> path
                .filterNot { it.isUpperCase() }
                .groupBy { it }
                .none { it.value.size == 2 }
        }

    private fun String.isUpperCase(): Boolean =
        all { it.isUpperCase() }

    private fun parseInput(input: List<String>): Map<String, List<String>> =
        input
            .map { it.split("-") }
            .flatMap {
                listOf(
                    it.first() to it.last(),
                    it.last() to it.first()
                )
            }
            .groupBy({ it.first }, { it.second })
}
