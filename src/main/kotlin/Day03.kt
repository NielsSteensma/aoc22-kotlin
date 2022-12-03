val alphabet = ('a'..'z').toMutableList()

fun main() {
    val input = readInput("Day03")
    println("Day 03 Part 1 ${calculateDay03Part1(input)}")
    println("Day 03 Part 2 ${calculateDay03Part2(input)}")
}

fun calculateDay03Part1(input: List<String>): Int {
    val priority = input.map(::getCompartments).map(::commonItem).map(::priority)
    return priority.sum()
}

fun calculateDay03Part2(input: List<String>): Int {
    val priority = input.chunked(3).map(::commonGroupItem).map(::priority)
    return priority.sum()
}

private fun getCompartments(itemsInRucksack: String): Pair<String, String> {
    val halfIndex = itemsInRucksack.count() / 2
    val leftCompartment = itemsInRucksack.substring(0, halfIndex)
    val rightCompartment = itemsInRucksack.substring(halfIndex, itemsInRucksack.count())
    return Pair(leftCompartment, rightCompartment)
}

private fun commonItem(compartments: Pair<String, String>): Char {
    val (leftCompartment, rightCompartment) = compartments

    var recurringChar: Char? = null
    leftCompartment.forEach {
        if (rightCompartment.contains(it)) {
            recurringChar = it
        }
    }

    return recurringChar!!
}

private fun commonGroupItem(rucksacks: List<String>): Char {
    var recurringGroupItem: Char? = null

    rucksacks.first().forEach { groupItem ->
        val otherRucksacks = rucksacks.subList(1, rucksacks.size)
        var foundGroupItem = true
        otherRucksacks.forEach {
            foundGroupItem = it.contains(groupItem) && foundGroupItem != false
        }

        if (foundGroupItem) {
            recurringGroupItem = groupItem
        }
    }

    return recurringGroupItem!!
}

private fun priority(char: Char): Int {
    var priority = if (char.isUpperCase()) 26 else 0
    priority += alphabet.indexOf(char.lowercase()[0]) + 1
    return priority
}