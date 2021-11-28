/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

package com.ginsberg.advent2021

import java.io.File
import java.net.URI

internal object Resources {
    fun resourceAsString(fileName: String, delimiter: String = ""): String =
        resourceAsListOfString(fileName).reduce { a, b -> "$a$delimiter$b" }

    fun resourceAsText(fileName: String): String =
        File(fileName.toURI()).readText()

    fun resourceAsListOfString(fileName: String): List<String> =
            File(fileName.toURI()).readLines()

    fun resourceAsListOfInt(fileName: String): List<Int> =
        resourceAsListOfString(fileName).map { it.toInt() }

    fun resourceAsListOfLong(fileName: String): List<Long> =
        resourceAsListOfString(fileName).map { it.toLong() }

    private fun String.toURI(): URI =
            Resources.javaClass.classLoader.getResource(this)?.toURI() ?: throw IllegalArgumentException("Cannot find Resource: $this")
}

