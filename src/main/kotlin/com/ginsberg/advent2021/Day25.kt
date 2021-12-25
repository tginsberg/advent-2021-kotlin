/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 25 - Sea Cucumber
 * Problem Description: http://adventofcode.com/2021/day/25
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day25/
 */
package com.ginsberg.advent2021


class Day25(input: List<String>) {

    private val initialState: Map<Point2d, Char> = parseInput(input)
    private val gridMax: Point2d = Point2d(input.first().lastIndex, input.lastIndex)

    fun solvePart1(): Int =
        generateSequence(initialState) { it.next() }
            .zipWithNext()
            .indexOfFirst { it.first == it.second } + 1

    private fun Map<Point2d, Char>.next(): Map<Point2d, Char> {
        val nextMap = this.toMutableMap()
        filterValues { it == '>' }
            .keys
            .map { it to it.east() }
            .filter { it.second !in this }
            .forEach { (prev, east) ->
                nextMap.remove(prev)
                nextMap[east] = '>'
            }
        nextMap.filterValues { it == 'v' }
            .keys
            .map { it to it.south() }
            .filter { it.second !in nextMap }
            .forEach { (prev, south) ->
                nextMap.remove(prev)
                nextMap[south] = 'v'
            }
        return nextMap
    }

    private fun Point2d.east(): Point2d =
        if (x == gridMax.x) Point2d(0, y) else Point2d(x + 1, y)

    private fun Point2d.south(): Point2d =
        if (y == gridMax.y) Point2d(x, 0) else Point2d(x, y + 1)

    private fun parseInput(input: List<String>): Map<Point2d, Char> =
        buildMap {
            input.forEachIndexed { y, row ->
                row.forEachIndexed { x, c ->
                    if (c != '.') put(Point2d(x, y), c)
                }
            }
        }
}
