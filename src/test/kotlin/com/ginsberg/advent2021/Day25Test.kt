/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 25")
class Day25Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day25(resourceAsListOfString("day25_sample.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(58)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day25(resourceAsListOfString("day25.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(380)
        }
    }

}