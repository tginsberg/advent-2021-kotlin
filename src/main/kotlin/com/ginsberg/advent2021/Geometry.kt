/*
 * Copyright 2021 by Todd Ginsberg
 */
package com.ginsberg.advent2021

import kotlin.math.absoluteValue

data class Point2d(val x: Int, val y: Int) {

    infix fun sharesAxisWith(that: Point2d): Boolean =
        x == that.x || y == that.y

    infix fun lineTo(that: Point2d): List<Point2d> {
        val xDelta = lineWalkStep(x, that.x)
        val yDelta = lineWalkStep(y, that.y)
        val steps = maxOf((x - that.x).absoluteValue, (y - that.y).absoluteValue)
        return (1..steps).scan(this) { last, _ -> Point2d(last.x + xDelta, last.y + yDelta) }
    }

    private fun lineWalkStep(a: Int, b: Int): Int =
        when {
            a > b -> -1
            a < b -> 1
            else -> 0
        }
}

