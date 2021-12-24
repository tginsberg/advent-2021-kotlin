/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 24")
class Day24Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day24(resourceAsListOfString("day24.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(99893999291967L)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day24(resourceAsListOfString("day24.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(34171911181211L)
        }
    }
}