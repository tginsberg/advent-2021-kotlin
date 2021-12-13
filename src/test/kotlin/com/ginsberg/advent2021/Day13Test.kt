/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 13")
class Day13Test {

    // Arrange
    private val input = resourceAsListOfString("day13_sample.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day13(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(17)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day13(resourceAsListOfString("day13.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(689)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Prints example`() {
            Day13(input).solvePart2()
        }

        @Test
        fun `Prints answer`() {
            Day13(resourceAsListOfString("day13.txt")).solvePart2()
        }
    }
}