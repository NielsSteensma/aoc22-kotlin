fun main() {
    val input = readInput("Day04")
    println("Day 04 Part 1 ${calculateDay04Part1(input)}")
    println("Day 04 Part 2 ${calculateDay04Part2(input)}")
}

fun calculateDay04Part1(input: List<String>): Int {
    return input.map(::getElvePairSections).count(::fullyOverlappingSections)
}

fun calculateDay04Part2(input: List<String>): Int {
    return input.map(::getElvePairSections).count(::overlappingSections)
}

private fun getElvePairSections(value: String): Pair<IntRange, IntRange> {
    // Split by dash. Given the input, first element in array is start of range and second is end of range.
    fun getRangeOfSection(section: String) = section.split("-").let {
        IntRange(it[0].toInt(), it[1].toInt())
    }

    val elvePair = value.split(",")
    return Pair(getRangeOfSection(elvePair[0]), getRangeOfSection(elvePair[1]))
}

private fun fullyOverlappingSections(assigmentPair: Pair<IntRange, IntRange>): Boolean {
    val firstElveSections = assigmentPair.first
    val secondElveSections = assigmentPair.second

    return secondElveSections.first >= firstElveSections.first && secondElveSections.last <= firstElveSections.last ||
            firstElveSections.first >= secondElveSections.first && firstElveSections.last <= secondElveSections.last
}

private fun overlappingSections(assigmentPair: Pair<IntRange, IntRange>): Boolean {
    val firstElveSections = assigmentPair.first
    val secondElveSections = assigmentPair.second
    var overlaps = false

    for (section in firstElveSections) {
        if (secondElveSections.contains(section)) {
            overlaps = true
            break
        }
    }
    return overlaps
}