package day03

import readInputString

val itemPriorities = generatePriorityMap()

fun part1(input: List<String>): Long {
    var totalPriority = 0L

    for (line in input) {
        val firstHalf = line.substring(0, line.length / 2).toSet()
        val secondHalf = line.substring(line.length / 2).toSet()
        val commonItem = firstHalf.intersect(secondHalf).first().toString()
        totalPriority += itemPriorities[commonItem]!!
    }

    return totalPriority
}

fun part2(input: List<String>): Long {
    val groups = input.chunked(3)
    val commonItemsForGroups: MutableList<String> = mutableListOf() // common items for each 3 elf group

    for (group in groups) {
        val commonInFirstAndSecond = group[0].toSet().intersect(group[1].toSet())
        val commonInSecondAndThird = group[1].toSet().intersect(group[2].toSet())
        val commonItem = commonInFirstAndSecond.intersect(commonInSecondAndThird).first().toString()
        commonItemsForGroups.add(commonItem)
    }

    return commonItemsForGroups.sumOf { itemPriorities[it]!! }.toLong()
}

fun generatePriorityMap(): Map<String, Int> {
    val priorities: MutableMap<String, Int> = mutableMapOf()
    var currentPriority = 1
    for (character in 'a'..'z') {
        priorities[character.toString()] = currentPriority
        priorities[character.toString().uppercase()] = currentPriority + 26
        currentPriority++
    }
    return priorities
}

fun main() {
    val input = readInputString("day03/input")
    val testInput = readInputString("day03/test")

    println("Part 1 answer: ${part1(input)}")
    println("Part 2 answer: ${part2(input)}")

    // Tests for part 1 and 2
    check(part1(testInput) == 157L)
    check(part2(testInput) == 70L)
}