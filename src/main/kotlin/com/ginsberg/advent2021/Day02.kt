/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 2 - Dive!
 * Problem Description: http://adventofcode.com/2021/day/2
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day2/
 */
package com.ginsberg.advent2021

class Day02(input: List<String>) {

    private val commands = input.map { Command.of(it) }

    fun solvePart1(): Int =
        commands.fold(Submarine()) { submarine, command -> submarine.movePart1(command) }.answer()

    fun solvePart2(): Int =
        commands.fold(Submarine()) { submarine, command -> submarine.movePart2(command) }.answer()

    private data class Submarine(val depth: Int = 0, val position: Int = 0, val aim: Int = 0) {
        fun answer() = depth * position

        fun movePart1(command: Command): Submarine =
            when (command.name) {
                "forward" -> copy(position = position + command.amount)
                "down" -> copy(depth = depth + command.amount)
                "up" -> copy(depth = depth - command.amount)
                else -> error("Invalid command")
            }

        fun movePart2(command: Command) =
            when (command.name) {
                "forward" -> copy(
                    position = position + command.amount,
                    depth = depth + (aim * command.amount)
                )
                "down" -> copy(aim = aim + command.amount)
                "up" -> copy(aim = aim - command.amount)
                else -> error("Invalid command")
            }
    }

    private class Command(val name: String, val amount: Int) {
        companion object {
            fun of(input: String) = input.split(" ").let { Command(it.first(), it.last().toInt()) }
        }
    }
}