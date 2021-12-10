/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 10")
class Day10Test {

    // Arrange
    private val input = """
        [({(<(())[]>[[{[]{<()<>>
        [(()[<>])]({[<{<<[]>>(
        {([(<{}[<>[]}>{[]{[(<()>
        (((({<>}<{<{<>}{[]{[]{}
        [[<[([]))<([[{}[[()]]]
        [{[{({}]{}}([{[{{{}}([]
        {<[[]]>}<{[{[{[]{()[[[]
        [<(<(<(<{}))><([]([]()
        <{([([[(<>()){}]>(<<{{
        <{([{{}}[<[[[<>{}]]]>[]]
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day10(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(26397)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day10(resourceAsListOfString("day10.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(268_845)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day10(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(288_957)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day10(resourceAsListOfString("day10.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(403_8824_534)
        }
    }
}