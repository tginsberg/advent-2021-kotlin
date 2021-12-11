/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 11")
class Day11Test {

    // Arrange
    private val input = """
        5483143223
        2745854711
        5264556173
        6141336146
        6357385478
        4167524645
        2176841721
        6882881134
        4846848554
        5283751526
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day11(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(1_656)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day11(resourceAsListOfString("day11.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(1_725)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day11(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(195)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day11(resourceAsListOfString("day11.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(308)
        }
    }
}