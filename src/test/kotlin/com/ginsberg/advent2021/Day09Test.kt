/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 9")
class Day09Test {

    // Arrange
    private val input = """
        2199943210
        3987894921
        9856789892
        8767896789
        9899965678
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day09(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(15)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day09(resourceAsListOfString("day09.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(508)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day09(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1_134)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day09(resourceAsListOfString("day09.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1_564_640)
        }
    }
}