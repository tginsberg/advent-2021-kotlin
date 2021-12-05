/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day05Test {

    // Arrange
    private val input = """
        0,9 -> 5,9
        8,0 -> 0,8
        9,4 -> 3,4
        2,2 -> 2,1
        7,0 -> 7,4
        6,4 -> 2,0
        0,9 -> 2,9
        3,4 -> 1,4
        0,0 -> 8,8
        5,5 -> 8,2
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day05(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(5)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day05(resourceAsListOfString("day05.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(6_225)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day05(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(12)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day05(resourceAsListOfString("day05.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(22_116)
        }
    }
}