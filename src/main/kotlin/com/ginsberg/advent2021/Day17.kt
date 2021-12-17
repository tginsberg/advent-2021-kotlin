/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 17 - Trick Shot
 * Problem Description: http://adventofcode.com/2021/day/17
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day17/
 */
package com.ginsberg.advent2021

import kotlin.math.absoluteValue


class Day17(input: String) {
    private val targetArea: TargetArea = parseInput(input)

    fun solvePart1(): Int =
        (0..targetArea.x.last).maxOf { x ->
            (targetArea.y.first..targetArea.y.first.absoluteValue).maxOf { y ->
                val track = probePositions((Point2d(x, y))).takeWhile { !targetArea.hasOvershot(it) }
                if (track.any { it in targetArea }) track.maxOf { it.y } else 0
            }
        }

    fun solvePart2(): Int =
        (0..targetArea.x.last).sumOf { x ->
            (targetArea.y.first..targetArea.y.first.absoluteValue).count { y ->
                probePositions(Point2d(x, y)).first { targetArea.hasOvershot(it) || it in targetArea } in targetArea
            }
        }

    private fun probePositions(velocity: Point2d): Sequence<Point2d> = sequence {
        var position = Point2d(0, 0)
        var actualVelocity = velocity
        while (true) {
            position = Point2d(
                position.x + actualVelocity.x,
                position.y + actualVelocity.y
            )
            actualVelocity = Point2d(
                actualVelocity.x + if (actualVelocity.x > 0) -1 else if (actualVelocity.x < 0) 1 else 0,
                actualVelocity.y - 1
            )
            yield(position)
        }
    }

    private class TargetArea(val x: IntRange, val y: IntRange) {

        operator fun contains(point: Point2d): Boolean =
            point.x in x && point.y in y

        infix fun hasOvershot(point: Point2d): Boolean =
            point.x > x.last || point.y < y.first
    }

    private fun parseInput(input: String): TargetArea =
        TargetArea(
            input.substringAfter("=").substringBefore(".").toInt()..
                input.substringAfter("..").substringBefore(",").toInt(),
            input.substringAfterLast("=").substringBefore(".").toInt()..
                input.substringAfterLast(".").toInt()
        )
}
