/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 21 - Dirac Dice
 * Problem Description: http://adventofcode.com/2021/day/21
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day21/
 */
package com.ginsberg.advent2021


class Day21(input: List<String>) {

    private val player1Start: Int = input.first().substringAfterLast(" ").toInt()
    private val player2Start: Int = input.last().substringAfterLast(" ").toInt()
    private val initialGameState = GameState(PlayerState(player1Start), PlayerState(player2Start))

    private val quantumDieFrequency: Map<Int, Long> = mapOf(3 to 1, 4 to 3, 5 to 6, 6 to 7, 7 to 6, 8 to 3, 9 to 1)
    private val stateMemory: MutableMap<GameState, WinCounts> = mutableMapOf()

    fun solvePart1(): Int {
        var game = initialGameState
        val die = DeterministicDie()
        while (!game.isWinner()) {
            game = game.next(die.roll())
        }
        return game.minScore() * die.rolls
    }

    fun solvePart2(): Long =
        playQuantum().max()

    private fun playQuantum(state: GameState = initialGameState): WinCounts =
        when {
            state.isWinner(21) ->
                if (state.player1.score > state.player2.score) WinCounts(1, 0) else WinCounts(0, 1)
            state in stateMemory ->
                stateMemory.getValue(state)
            else ->
                quantumDieFrequency.map { (die, frequency) ->
                    playQuantum(state.next(die)) * frequency
                }.reduce { a, b -> a + b }.also { stateMemory[state] = it }
        }

    private class DeterministicDie(var value: Int = 0, var rolls: Int = 0) {
        fun roll(): Int {
            rolls += 3
            value += 3
            return 3 * value - 3
        }
    }

    private class WinCounts(val player1: Long, val player2: Long) {
        operator fun plus(other: WinCounts): WinCounts =
            WinCounts(player1 + other.player1, player2 + other.player2)

        operator fun times(other: Long): WinCounts =
            WinCounts(player1 * other, player2 * other)

        fun max(): Long =
            maxOf(player1, player2)
    }

    private data class GameState(val player1: PlayerState, val player2: PlayerState, val player1Turn: Boolean = true) {
        fun next(die: Int): GameState =
            GameState(
                if (player1Turn) player1.next(die) else player1,
                if (!player1Turn) player2.next(die) else player2,
                player1Turn = !player1Turn
            )

        fun isWinner(scoreNeeded: Int = 1000): Boolean =
            player1.score >= scoreNeeded || player2.score >= scoreNeeded

        fun minScore(): Int =
            minOf(player1.score, player2.score)
    }

    private data class PlayerState(val place: Int, val score: Int = 0) {
        fun next(die: Int): PlayerState {
            val nextPlace = (place + die - 1) % 10 + 1

            return PlayerState(
                place = nextPlace,
                score = score + nextPlace
            )
        }
    }

}
