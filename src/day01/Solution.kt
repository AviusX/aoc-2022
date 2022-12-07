package day01
import readInputString

fun part1(input: List<String>): Long {
    val elves = getListOfElvesCalories(input)
    return elves.max()
}

fun part2(input: List<String>): Long {
    val elves = getListOfElvesCalories(input)
    return elves.sortedDescending().take(3).sum()
}

fun getListOfElvesCalories(input: List<String>): MutableList<Long> {
    val elves: MutableList<Long> = mutableListOf(0)

    for (line in input) {
        if (line.isEmpty()) {
            elves.add(0)
            continue
        }
        elves[elves.lastIndex] += line.toLong()
    }

    return elves
}

fun main() {
    val input = readInputString("day01/input")
    val testInput = readInputString("day01/test")

    println("Part 1 answer: ${part1(input)}")
    println("Part 2 answer: ${part2(input)}")

    // Tests for part 1 and 2
    check(part1(testInput) == 24000L)
    check(part2(testInput) == 45000L)
}