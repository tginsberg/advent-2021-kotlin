/*
 * Copyright 2021 by Todd Ginsberg
 */
package com.ginsberg.advent2021

fun <T> List<T>.midpoint(): T =
    this[lastIndex / 2]