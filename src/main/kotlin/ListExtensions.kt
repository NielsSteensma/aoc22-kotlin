/**
 * Splits a list of string by the given predicate.
 *
 * Example:  ("A", "A", "splitme", "B", "B") with a matching predicate of "splitme" would return
 * (("A","A"), ("B", "B")).
 */
internal inline fun List<String>.splitWhen(predicate: (String) -> Boolean): List<List<String>> {
    val list = mutableListOf<MutableList<String>>()
    var createNewList = false
    forEach { string ->
        if (predicate(string)) {
            createNewList = true
        } else {
            if (createNewList || list.isEmpty()) {
                list.add(mutableListOf(string))
                createNewList = false
            } else {
                list.last().add(string)
            }
        }
    }
    return list
}