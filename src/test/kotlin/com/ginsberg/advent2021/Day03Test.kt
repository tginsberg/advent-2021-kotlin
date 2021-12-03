/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 3")
class Day03Test {

    // Arrange
    private val input = """
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day03(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(198)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day03(resourceAsListOfString("day03.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(4_160_394)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day03(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(230)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day03(resourceAsListOfString("day03.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(4_125_600)
        }
    }
}