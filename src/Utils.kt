import java.io.File

fun readInputString(file: String) = File("src", file).readLines()

fun readInputLong(file: String) = File("src", file).readLines().map { it.toLong() }