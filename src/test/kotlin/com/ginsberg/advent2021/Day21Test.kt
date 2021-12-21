/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 21")
class Day21Test {

    private val input: List<String> = """
        Player 1 starting position: 4
        Player 2 starting position: 8
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day21(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(739_785)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day21(resourceAsListOfString("day21.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(913_560)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day21(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(444_356_092_776_315)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day21(resourceAsListOfString("day21.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(110_271_560_863_819)
        }
    }
}