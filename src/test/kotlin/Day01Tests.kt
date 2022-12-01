import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `correctly calculates the sum of calories of elf with most calories`() {
            val input = listOf("100", "100", "", "300", "400")
            assertEquals(700, calculateDay01Part1(input))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `correctly calculates the sum of calories of three elves with most calories`() {
            val input = listOf("100", "100", "", "200", "200", "", "300", "300", "", "400", "400")
            assertEquals(1800, calculateDay01Part2(input))
        }
    }
}