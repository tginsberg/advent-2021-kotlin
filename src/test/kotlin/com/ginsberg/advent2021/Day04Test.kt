/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 4")
class Day04Test {

    // Arrange
    private val input = resourceAsListOfString("day04_sample.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day04(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(4_512)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day04(resourceAsListOfString("day04.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(51_776)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day04(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1_924)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day04(resourceAsListOfString("day04.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(16_830)
        }
    }
}