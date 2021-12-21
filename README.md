## Advent of Code 2021 Solutions in Kotlin

[![license](https://img.shields.io/github/license/tginsberg/advent-2021-kotlin)]()

This repo is my personal attempt at solving the [Advent of Code 2021](http://adventofcode.com/2021) set of problems with the Kotlin programming language.

I am trying to solve these on the day they are posted with clear, idiomatic solutions. That means in some cases I will sacrifice performance for a more clear solution. While I will endeavour to have these done day-of I can't promise it because work and life can get in the way. Plus, some of these problems can get quite involved, so solving it clearly and writing up an explanation might take me longer than a day. We'll see how it goes! :)

Past years, also in Kotlin:
 * 2017 - [GitHub](https://github.com/tginsberg/advent-2017-kotlin/) and [Blog Posts](https://todd.ginsberg.com/post/advent-of-code/2017/)
 * 2018 - [GitHub](https://github.com/tginsberg/advent-2018-kotlin/) and [Blog Posts](https://todd.ginsberg.com/post/advent-of-code/2018/)
 * 2019 - [GitHub](https://github.com/tginsberg/advent-2019-kotlin/) and [Blog Posts](https://todd.ginsberg.com/post/advent-of-code/2019/)
 * 2020 - [GitHub](https://github.com/tginsberg/advent-2020-kotlin/) and [Blog Posts](https://todd.ginsberg.com/post/advent-of-code/2020/)

#### Daily Solution Index for 2021
| Day | Title                   | Links                                                                                                                                                                                                                                              |
|-----|:------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1   | Sonar Sweep             | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day1/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day01.kt) [\[AoC\]](http://adventofcode.com/2021/day/1)   |
| 2   | Dive!                   | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day2/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day02.kt) [\[AoC\]](http://adventofcode.com/2021/day/2)   |
| 3   | Binary Diagnostic       | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day3/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day03.kt) [\[AoC\]](http://adventofcode.com/2021/day/3)   |
| 4   | Giant Squid             | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day4/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day04.kt) [\[AoC\]](http://adventofcode.com/2021/day/4)   |
| 5   | Hydrothermal Venture    | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day5/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day05.kt) [\[AoC\]](http://adventofcode.com/2021/day/5)   |
| 6   | Lanternfish             | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day6/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day06.kt) [\[AoC\]](http://adventofcode.com/2021/day/6)   |
| 7   | The Treachery of Whales | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day7/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day07.kt) [\[AoC\]](http://adventofcode.com/2021/day/7)   |
| 8   | Seven Segment Search    | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day8/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day08.kt) [\[AoC\]](http://adventofcode.com/2021/day/8)   |
| 9   | Smoke Basin             | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day9/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day09.kt) [\[AoC\]](http://adventofcode.com/2021/day/9)   |
| 10  | Syntax Scoring          | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day10/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day10.kt) [\[AoC\]](http://adventofcode.com/2021/day/10) |
| 11  | Dumbo Octopus           | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day11/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day11.kt) [\[AoC\]](http://adventofcode.com/2021/day/11) |
| 12  | Passage Pathing         | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day12/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day12.kt) [\[AoC\]](http://adventofcode.com/2021/day/12) |
| 13  | Transparent Origami     | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day13/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day13.kt) [\[AoC\]](http://adventofcode.com/2021/day/13) |
| 14  | Extended Polymerization | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day14/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day14.kt) [\[AoC\]](http://adventofcode.com/2021/day/14) |
| 15  | Chiton                  | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day15/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day15.kt) [\[AoC\]](http://adventofcode.com/2021/day/15) |
| 16  | Packet Decoder          | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day16/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day16.kt) [\[AoC\]](http://adventofcode.com/2021/day/16) |
| 17  | Trick Shot              | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day17/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day17.kt) [\[AoC\]](http://adventofcode.com/2021/day/17) |
| 18  | Snailfish               | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day18/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day18.kt) [\[AoC\]](http://adventofcode.com/2021/day/18) |
| 19  | Beacon Scanner          | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day19/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day19.kt) [\[AoC\]](http://adventofcode.com/2021/day/19) |
| 20  | Trench Map              | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day20/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day20.kt) [\[AoC\]](http://adventofcode.com/2021/day/20) |
| 21  | INSERT                  | [\[Blog Post\]](https://todd.ginsberg.com/post/advent-of-code/2021/day21/) [\[Code\]](https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day21.kt) [\[AoC\]](http://adventofcode.com/2021/day/21) |

Copyright &copy; 2021 by Todd Ginsberg.
