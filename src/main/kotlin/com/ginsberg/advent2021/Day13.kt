/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 13 - Transparent Origami
 * Problem Description: http://adventofcode.com/2021/day/13
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day13/
 */
package com.ginsberg.advent2021

class Day13(input: List<String>) {

    private val paper: Set<Point2d> = parsePoints(input)
    private val instructions: List<Point2d> = parseInstructions(input)

    fun solvePart1(): Int =
        paper.crease(instructions.first()).size

    fun solvePart2(): Unit =
        instructions.fold(paper) { paper, instruction -> paper.crease(instruction) }.printout()

    private fun Set<Point2d>.printout() {
        (0..this.maxOf { it.y }).forEach { y ->
            (0..this.maxOf { it.x }).forEach { x ->
                print(if (Point2d(x, y) in this) "#" else " ")
            }
            println()
        }
    }

    private fun Set<Point2d>.crease(instruction: Point2d): Set<Point2d> =
        if (instruction.x != 0) this.map { it.copy(x = it.x.creaseAt(instruction.x)) }.toSet()
        else this.map { it.copy(y = it.y.creaseAt(instruction.y)) }.toSet()

    private fun Int.creaseAt(crease: Int): Int =
        if (this < crease) this else (crease * 2) - this

    private fun parsePoints(input: List<String>): Set<Point2d> =
        input.takeWhile { it.isNotEmpty() }
            .map { it.split(",") }
            .map { Point2d(it.first().toInt(), it.last().toInt()) }
            .toSet()

    private fun parseInstructions(input: List<String>): List<Point2d> =
        input.takeLastWhile { it.isNotEmpty() }
            .map { it.split("=") }
            .map {
                if (it.first().endsWith("y")) {
                    Point2d(0, it.last().toInt())
                } else {
                    Point2d(it.last().toInt(), 0)
                }
            }
}