package day03
import readInputString

fun part1(input: List<String>): Long {
    return 0
}

fun part2(input: List<String>): Long {
    return 0
}

fun main() {
    val input = readInputString("day03/input")
    val testInput = readInputString("day03/test")

    println("Part 1 answer: ${part1(input)}")
    println("Part 2 answer: ${part2(input)}")

    // Tests for part 1 and 2
    check(part1(testInput) == 24000L)
    check(part2(testInput) == 45000L)
}