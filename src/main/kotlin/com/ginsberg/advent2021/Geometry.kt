/*
 * Copyright 2021 by Todd Ginsberg
 */
package com.ginsberg.advent2021

import kotlin.math.absoluteValue
import kotlin.math.sign

data class Point2d(val x: Int, val y: Int) {

    infix fun sharesAxisWith(that: Point2d): Boolean =
        x == that.x || y == that.y

    infix fun lineTo(that: Point2d): List<Point2d> {
        val xDelta = (that.x - x).sign
        val yDelta = (that.y - y).sign
        val steps = maxOf((x - that.x).absoluteValue, (y - that.y).absoluteValue)
        return (1..steps).scan(this) { last, _ -> Point2d(last.x + xDelta, last.y + yDelta) }
    }

    fun neighbors(): List<Point2d> =
        listOf(
            Point2d(x, y + 1),
            Point2d(x, y - 1),
            Point2d(x + 1, y),
            Point2d(x - 1, y)
        )

    fun allNeighbors(): List<Point2d> =
        neighbors() + listOf(
            Point2d(x - 1, y - 1),
            Point2d(x - 1, y + 1),
            Point2d(x + 1, y - 1),
            Point2d(x + 1, y + 1)
        )
}

