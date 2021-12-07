/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 7")
class Day07Test {

    // Arrange
    private val input = "16,1,2,0,4,2,7,1,2,14"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day07(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(37)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day07(resourceAsString("day07.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(340_056)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day07(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(168)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day07(resourceAsString("day07.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(96_592_275)
        }
    }
}