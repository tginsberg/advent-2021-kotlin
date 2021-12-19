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

data class Point3d(val x: Int, val y: Int, val z: Int) {

    infix fun distanceTo(other: Point3d): Int =
        (this.x - other.x).absoluteValue + (this.y - other.y).absoluteValue + (this.z - other.z).absoluteValue

    operator fun plus(other: Point3d): Point3d =
        Point3d(x + other.x, y + other.y, z + other.z)

    operator fun minus(other: Point3d): Point3d =
        Point3d(x - other.x, y - other.y, z - other.z)

    fun face(facing: Int): Point3d =
        when (facing) {
            0 -> this
            1 -> Point3d(x, -y, -z)
            2 -> Point3d(x, -z, y)
            3 -> Point3d(-y, -z, x)
            4 -> Point3d(y, -z, -x)
            5 -> Point3d(-x, -z, -y)
            else -> error("Invalid facing")
        }

    fun rotate(rotating: Int): Point3d =
        when (rotating) {
            0 -> this
            1 -> Point3d(-y, x, z)
            2 -> Point3d(-x, -y, z)
            3 -> Point3d(y, -x, z)
            else -> error("Invalid rotation")
        }

    companion object {
        fun of(rawInput: String): Point3d =
            rawInput.split(",").let { part ->
                Point3d(part[0].toInt(), part[1].toInt(), part[2].toInt())
            }
    }

}
