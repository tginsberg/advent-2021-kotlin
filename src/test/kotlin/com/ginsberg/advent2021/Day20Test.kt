/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 20")
class Day20Test {

    private val input: List<String> = resourceAsListOfString("day20_sample.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day20(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(35)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day20(resourceAsListOfString("day20.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(5_622)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day20(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(3_351)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day20(resourceAsListOfString("day20.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(20_395)
        }
    }
}