import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `correctly calculates the priority`() {
            val input = listOf("JmTTrTmjRTJqSQQSFqQw")
            assertEquals(36, calculateDay03Part1(input))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `correctly calculates the priority`() {
            val input = listOf("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw")
            assertEquals(52, calculateDay03Part2(input))
        }
    }
}