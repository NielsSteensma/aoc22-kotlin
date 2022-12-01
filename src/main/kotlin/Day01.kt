fun main() {
    val input = readInput("Day01")
    println("Day 01 Part 1 ${calculateDay01Part1(input)}")
    println("Day 01 Part 2 ${calculateDay01Part2(input)}")
}

fun calculateDay01Part1(input: List<String>): Int {
    return calculateTotalCaloriesByElve(input)
        .maxOf { it } // Grab elve who took most calories with him on the trip.
}

fun calculateDay01Part2(input: List<String>): Int {
    return calculateTotalCaloriesByElve(input)
        .sortedDescending() // Sort in descending order.
        .take(3) // Take 3 elves carrying most calories
        .sum() // Get sum of the 3 elves carrying most calories.
}

private fun calculateTotalCaloriesByElve(input: List<String>): List<Int> {
    return input
        .splitWhen { it.isBlank() } // Elve separator
        .map { it.map { caloriesPerDay -> caloriesPerDay.toInt() } } // Elve calorie per day from String to Int
        .map { it.sum() } // Calculate total calories carried per elve.
}
