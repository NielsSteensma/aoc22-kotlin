import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day04Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `correctly calculates how many assignment pairs with fully contain another`() {
            val input = listOf("2-4,6-8", "2-3,4-5", "5-7,7-9", "2-8,3-7", "6-6,4-6", "2-6,4-8")
            assertEquals(2, calculateDay04Part1(input))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `correctly calculates how many assignment pairs overlap each other`() {
            val input = listOf("2-4,6-8", "2-3,4-5", "5-7,7-9", "2-8,3-7", "6-6,4-6", "2-6,4-8")
            assertEquals(4, calculateDay04Part2(input))
        }
    }
}
