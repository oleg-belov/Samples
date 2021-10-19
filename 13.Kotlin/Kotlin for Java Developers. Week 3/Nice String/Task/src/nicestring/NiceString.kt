package nicestring

fun String.isNice(): Boolean {
    val predicates = listOf(
        ::isNotContainPredefinedStrings,
        ::isContainAtLeastThreeVowels,
        ::isContainDoubleLetterFollowingOneAnother)

    return predicates.count{ run(it) } >= 2
}

private fun String.isNotContainPredefinedStrings(): Boolean =
    setOf("bu", "ba", "be").none { this.contains(it) }

private fun String.isContainAtLeastThreeVowels(): Boolean =
    count { it in "aeiou" } >= 3

private fun String.isContainDoubleLetterFollowingOneAnother(): Boolean =
    this.zipWithNext().any { (left, right) -> left == right }