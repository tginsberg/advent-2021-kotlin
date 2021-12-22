/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 22 - Reactor Reboot
 * Problem Description: http://adventofcode.com/2021/day/22
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day22/
 */
package com.ginsberg.advent2021


class Day22(input: List<String>) {

    private val cubes: List<Cuboid> = input.map { Cuboid.of(it) }
    private val part1Cube = Cuboid(true, -50..50, -50..50, -50..50)

    fun solvePart1(): Long =
        solve(cubes.filter { it.intersects(part1Cube) })

    fun solvePart2(): Long =
        solve()

    private fun solve(cubesToUse: List<Cuboid> = cubes): Long {
        val volumes = mutableListOf<Cuboid>()

        cubesToUse.forEach { cube ->
            volumes.addAll(volumes.mapNotNull { it.intersect(cube) })
            if (cube.on) volumes.add(cube)
        }

        return volumes.sumOf { it.volume() }
    }

    private class Cuboid(val on: Boolean, val x: IntRange, val y: IntRange, val z: IntRange) {
        fun volume(): Long =
            (x.size().toLong() * y.size().toLong() * z.size().toLong()) * if (on) 1 else -1

        fun intersect(other: Cuboid): Cuboid? =
            if (!intersects(other)) null
            else Cuboid(!on, x intersect other.x, y intersect other.y, z intersect other.z)

        fun intersects(other: Cuboid): Boolean =
            x.intersects(other.x) && y.intersects(other.y) && z.intersects(other.z)

        companion object {
            private val pattern =
                """^(on|off) x=(-?\d+)\.\.(-?\d+),y=(-?\d+)\.\.(-?\d+),z=(-?\d+)\.\.(-?\d+)$""".toRegex()

            fun of(input: String): Cuboid {
                val (s, x1, x2, y1, y2, z1, z2) = pattern.matchEntire(input)?.destructured
                    ?: error("Cannot parse input: $input")
                return Cuboid(
                    s == "on",
                    x1.toInt()..x2.toInt(),
                    y1.toInt()..y2.toInt(),
                    z1.toInt()..z2.toInt(),
                )
            }
        }
    }
}

