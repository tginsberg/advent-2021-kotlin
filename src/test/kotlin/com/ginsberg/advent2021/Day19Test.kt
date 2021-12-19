/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 19")
class Day19Test {

    private val input: String = resourceAsString("day19_sample.txt", "\n")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day19(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(79)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day19(resourceAsString("day19.txt", "\n")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(408)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day19(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(3_621)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day19(resourceAsString("day19.txt", "\n")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(13_348)
        }
    }
}