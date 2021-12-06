/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 6")
class Day06Test {

    // Arrange
    private val input = "3,4,3,1,2"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day06(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(5_934L)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day06(resourceAsString("day06.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(383_160L)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day06(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(26_984_457_539L)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day06(resourceAsString("day06.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1_721_148_811_504L)
        }
    }
}