import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day02Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `correctly calculates a win`() {
            val input = listOf("A Y")
            assertEquals(8, calculateDay02Part1(input))
        }

        @Test
        fun `correctly calculates a loss`() {
            val input = listOf("B X")
            assertEquals(1, calculateDay02Part1(input))
        }

        @Test
        fun `correctly calculates a draw`() {
            val input = listOf("C Z")
            assertEquals(6, calculateDay02Part1(input))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `correctly calculates an expected draw`() {
            val input = listOf("A Y")
            assertEquals(4, calculateDay02Part2(input))
        }

        @Test
        fun `correctly calculates an expected loss`() {
            val input = listOf("B X")
            assertEquals(1, calculateDay02Part2(input))
        }

        @Test
        fun `correctly calculates an expected win`() {
            val input = listOf("C Z")
            assertEquals(7, calculateDay02Part2(input))
        }
    }
}