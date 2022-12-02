fun main() {
    val input = readInput("Day02")
    println("Day 02 Part 1 ${calculateDay02Part1(input)}")
    println("Day 02 Part 2 ${calculateDay02Part2(input)}")
}

fun calculateDay02Part1(input: List<String>): Int {
    return input.sumOf {
        val opponentPlayerChars = extractChars(it)
        calculateRockPaperScissorOutput(opponentPlayerChars)
    }
}

fun calculateDay02Part2(input: List<String>): Int {
    return input.sumOf {
        val (opponent, gameResult) = extractChars(it)
        val opponentsPick = Pick.forChar(opponent)
        val playersPick = GameResult.forChar(gameResult).getPlayersPick(opponentsPick)
        val opponentPlayerChars = Pair(opponent, playersPick.playerChar)
        calculateRockPaperScissorOutput(opponentPlayerChars)
    }
}

private fun extractChars(string: String): Pair<Char, Char> {
    val splitString = string.split(" ")
    val opponent = splitString[0].first()
    val player = splitString[1].first()
    return Pair(opponent, player)
}

private fun calculateRockPaperScissorOutput(opponentPlayerChars: Pair<Char, Char>): Int {
    val (opponentChar, playerChar) = opponentPlayerChars
    val opponentPick = Pick.forChar(opponentChar)
    val playerPick = Pick.forChar(playerChar)
    val score = calculateWinDrawOrLoseScore(playerPick, opponentPick)
    return score + playerPick.score
}

fun calculateWinDrawOrLoseScore(player: Pick, opponent: Pick): Int {
    if (player == opponent) {
        return 3
    }
    return if (player.beats == opponent) 6 else 0
}

enum class Pick {
    ROCK,
    PAPER,
    SCISSOR;

    val beats: Pick
        get() = when (this) {
            ROCK -> SCISSOR
            PAPER -> ROCK
            SCISSOR -> PAPER
        }

    val loses: Pick
        get() = when (this) {
            SCISSOR -> ROCK
            ROCK -> PAPER
            PAPER -> SCISSOR
        }

    val score: Int
        get() = when (this) {
            ROCK -> 1
            PAPER -> 2
            SCISSOR -> 3
        }

    val playerChar: Char
        get() = when (this) {
            ROCK -> 'X'
            PAPER -> 'Y'
            SCISSOR -> 'Z'
        }

    companion object {
        fun forChar(char: Char) =
            when (char) {
                'A', 'X' -> ROCK
                'B', 'Y' -> PAPER
                'C', 'Z' -> SCISSOR
                else -> throw IllegalArgumentException("Char not in PlayerGuide")
            }
    }
}

enum class GameResult {
    WIN,
    LOSE,
    DRAW;

    fun getPlayersPick(opponent: Pick) =
        when (this) {
            DRAW -> opponent
            WIN -> opponent.loses
            LOSE -> opponent.beats
        }

    companion object {
        fun forChar(char: Char) =
            when (char) {
                'Z' -> WIN
                'X' -> LOSE
                'Y' -> DRAW
                else -> throw IllegalArgumentException("Char not in PlayerGuide")
            }
    }
}