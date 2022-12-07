package day02

import readInputString

fun part1(input: List<String>): Long {
    val winMap = mapOf("X" to "C", "Y" to "A", "Z" to "B") // what wins against what
    val drawMap = mapOf("X" to "A", "Y" to "B", "Z" to "C") // what draws against what
    val pointsMap = mapOf("X" to 1, "Y" to 2, "Z" to 3) // how many points each has
    var pointsEarned = 0L

    for (line in input) {
        val (opponentMove, myMove) = line.split(" ")
        pointsEarned += pointsMap[myMove]!!

        pointsEarned += when (opponentMove) {
            winMap[myMove] -> 6
            drawMap[myMove] -> 3
            else -> 0
        }
    }

    return pointsEarned
}

fun part2(input: List<String>): Long {
    val reverseWinMap = mapOf("A" to "PAPER", "B" to "SCISSORS", "C" to "ROCK") // what to pull to win
    val reverseDrawMap = mapOf("A" to "ROCK", "B" to "PAPER", "C" to "SCISSORS") // what draws against what
    val reverseLoseMap = mapOf("A" to "SCISSORS", "B" to "ROCK", "C" to "PAPER") // what to pull to lose
    val pointsMap = mapOf("ROCK" to 1, "PAPER" to 2, "SCISSORS" to 3)
    var pointsEarned = 0L

    for (line in input) {
        val (opponentMove, decisionFactor) = line.split(" ")
        pointsEarned += when {
            (decisionFactor == "X") -> {
                val toPull = reverseLoseMap[opponentMove]
                pointsMap[toPull]!!
            }

            (decisionFactor == "Y") -> {
                val toPull = reverseDrawMap[opponentMove]
                pointsMap[toPull]!! + 3
            }

            else -> {
                val toPull = reverseWinMap[opponentMove]
                pointsMap[toPull]!! + 6
            }
        }
    }

    return pointsEarned
}

fun main() {
    val input = readInputString("day02/input")
    val testInput = readInputString("day02/test")

    println("Part 1 answer: ${part1(input)}")
    println("Part 2 answer: ${part2(input)}")

    // Tests for part 1 and 2
    check(part1(testInput) == 15L)
    check(part2(testInput) == 12L)
}
