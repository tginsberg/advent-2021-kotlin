/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 16")
class Day16Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example 1`() {
            // Act
            val answer = Day16("8A004A801A8002F478").solvePart1()

            // Assert
            assertThat(answer).isEqualTo(16)
        }

        @Test
        fun `Matches example 2`() {
            // Act
            val answer = Day16("620080001611562C8802118E34").solvePart1()

            // Assert
            assertThat(answer).isEqualTo(12)
        }

        @Test
        fun `Matches example 3`() {
            // Act
            val answer = Day16("C0015000016115A2E0802F182340").solvePart1()

            // Assert
            assertThat(answer).isEqualTo(23)
        }

        @Test
        fun `Matches example 4`() {
            // Act
            val answer = Day16("A0016C880162017C3686B18A3D4780").solvePart1()

            // Assert
            assertThat(answer).isEqualTo(31)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day16(resourceAsString("day16.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(897)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example 1`() {
            // Act
            val answer = Day16("9C0141080250320F1802104A08").solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day16(resourceAsString("day16.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(9_485_076_995_911L)
        }
    }
}