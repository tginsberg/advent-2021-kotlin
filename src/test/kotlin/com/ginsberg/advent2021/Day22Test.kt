/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 22")
class Day22Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day22(resourceAsListOfString("day22_sample1.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(590_784)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day22(resourceAsListOfString("day22.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(647_076)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day22(resourceAsListOfString("day22_sample2.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(2_758_514_936_282_235L)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day22(resourceAsListOfString("day22.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1_233_304_599_156_793L)
        }
    }
}