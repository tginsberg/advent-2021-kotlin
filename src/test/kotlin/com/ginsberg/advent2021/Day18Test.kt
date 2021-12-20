/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import com.ginsberg.advent2021.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 18")
class Day18Test {

    private val input: List<String> = """
        [[[0,[5,8]],[[1,7],[9,6]]],[[4,[1,2]],[[1,4],2]]]
        [[[5,[2,8]],4],[5,[[9,9],0]]]
        [6,[[[6,2],[5,6]],[[7,6],[4,7]]]]
        [[[6,[0,7]],[0,9]],[4,[9,[9,0]]]]
        [[[7,[6,4]],[3,[1,3]]],[[[5,5],1],9]]
        [[6,[[7,3],[3,2]]],[[[3,8],[5,7]],4]]
        [[[[5,4],[7,7]],8],[[8,3],8]]
        [[9,3],[[9,9],[6,[4,9]]]]
        [[2,[[7,7],7]],[[5,8],[[9,3],[0,2]]]]
        [[[[5,2],5],[8,[3,7]]],[[5,[7,5]],[4,4]]]
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day18(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(4_140)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day18(resourceAsListOfString("day18.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(4_207)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day18(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(3_993)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day18(resourceAsListOfString("day18.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(4_635)
        }
    }
}