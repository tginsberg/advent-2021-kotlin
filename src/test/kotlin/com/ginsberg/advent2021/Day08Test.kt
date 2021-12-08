/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 8")
class Day08Test {

    // Arrange
    private val input = resourceAsListOfString("day08_sample.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day08(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(26)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(493)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day08(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(61_229)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1_010_460)
        }
    }
}