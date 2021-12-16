/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

/**
 * Advent of Code 2021, Day 16 - Packet Decoder
 * Problem Description: http://adventofcode.com/2021/day/16
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2021/day16/
 */
package com.ginsberg.advent2021


class Day16(input: String) {

    private val binaryInput: Iterator<Char> = hexToBinary(input).iterator()

    fun solvePart1(): Int =
        BITSPacket.of(binaryInput).allVersions().sum()

    fun solvePart2(): Long =
        BITSPacket.of(binaryInput).value

    private fun hexToBinary(input: String): List<Char> =
        input.map { it.digitToInt(16).toString(2).padStart(4, '0') }.flatMap { it.toList() }

    private sealed class BITSPacket(val version: Int) {
        abstract val value: Long

        companion object {
            fun of(input: Iterator<Char>): BITSPacket {
                val version = input.nextInt(3)
                return when (val packetType = input.nextInt(3)) {
                    4 -> BITSLiteral.of(version, input)
                    else -> BITSOperator.of(version, packetType, input)
                }
            }
        }

        abstract fun allVersions(): List<Int>
    }

    private class BITSLiteral(version: Int, override val value: Long) : BITSPacket(version) {
        override fun allVersions(): List<Int> = listOf(version)

        companion object {
            fun of(version: Int, input: Iterator<Char>): BITSLiteral =
                BITSLiteral(version, parseLiteralValue(input))

            private fun parseLiteralValue(input: Iterator<Char>): Long =
                input.nextUntilFirst(5) { it.startsWith('0') }.map { it.drop(1) }.joinToString("").toLong(2)
        }
    }

    private class BITSOperator(version: Int, type: Int, val subPackets: List<BITSPacket>) : BITSPacket(version) {
        override fun allVersions(): List<Int> =
            listOf(version) + subPackets.flatMap { it.allVersions() }

        override val value: Long = when (type) {
            0 -> subPackets.sumOf { it.value }
            1 -> subPackets.fold(1) { acc, next -> acc * next.value }
            2 -> subPackets.minOf { it.value }
            3 -> subPackets.maxOf { it.value }
            5 -> if (subPackets.first().value > subPackets.last().value) 1 else 0
            6 -> if (subPackets.first().value < subPackets.last().value) 1 else 0
            7 -> if (subPackets.first().value == subPackets.last().value) 1 else 0
            else -> error("Invalid Operator type")
        }

        companion object {
            fun of(version: Int, type: Int, input: Iterator<Char>): BITSOperator {
                return when (input.nextInt(1)) { // Length Type
                    0 -> {
                        val subPacketLength = input.nextInt(15)
                        val subPacketIterator = input.next(subPacketLength).iterator()
                        val subPackets = subPacketIterator.executeUntilEmpty { of(it) }
                        BITSOperator(version, type, subPackets)
                    }
                    1 -> {
                        val numberOfPackets = input.nextInt(11)
                        val subPackets = (1..numberOfPackets).map { of(input) }
                        BITSOperator(version, type, subPackets)
                    }
                    else -> error("Invalid Operator length type")
                }
            }
        }
    }
}
