/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 17")
class Day17Test {

    private val input: String = "target area: x=20..30, y=-10..-5"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day17(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(45)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day17(resourceAsString("day17.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(35_511)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day17(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(112)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day17(resourceAsString("day17.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(3_282)
        }
    }
}