/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day02Test {

    // Arrange
    private val input = """
        forward 5
        down 5
        forward 8
        up 3
        down 8
        forward 2
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day02(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(150)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day02(resourceAsListOfString("day02.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(1_813_801)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day02(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(900)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day02(resourceAsListOfString("day02.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1_960_569_556)
        }
    }
}