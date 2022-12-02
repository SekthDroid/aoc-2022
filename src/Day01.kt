fun main() {
    fun parseCarriers(input: List<String>): List<List<Int>> {
        var current = mutableListOf<Int>()
        var carriers = emptyList<List<Int>>()

        for (each in input) {
            if (each.isBlank()) {
                carriers = carriers.plusElement(current)
                current = mutableListOf()
            } else {
                current.add(each.toInt())
            }
        }
        return carriers
    }

    fun part1(input: List<String>): Int {
        return parseCarriers(input).maxOf { it.sum() }
    }

    fun part2(input: List<String>): Int {
        return parseCarriers(input).map { it.sum() }.sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
