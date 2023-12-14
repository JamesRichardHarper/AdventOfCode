fun main(args: Array<String>) {
    val inputText = getInput("input.txt")

    val blueRange = 14
    var blueTotal = 0

    val redRange = 12
    var redTotal = 0

    val greenRange = 13
    var greenTotal = 0

    var totalPossible = 0

    inputText.forEach { game ->
        println(game)
        println(totalPossible)

        val roundsTotal = getPickup(game)

        roundsTotal.forEach{round ->
            val redCount = getCubeNumbers("red", round)
            val blueCount = getCubeNumbers("blue", round)
            val greenCount = getCubeNumbers("green", round)

            if (
                redCount.all { it <= redRange } &&
                blueCount.all { it <= blueRange } &&
                greenCount.all { it <= greenRange }
            ){
                totalPossible += 1
            }

            println("$redCount, + $blueCount, + $greenCount")
        }
    }

}

/*
Function to retrieve the text input
 */
fun getInput(fileName: String): List<String>
    = object {}.javaClass.getResourceAsStream(fileName)?.bufferedReader()?.readLines() ?: listOf("No File Found")

/*
Function to return a List of every cube that was pulled of a given colour
 */
fun getCubeNumbers(colour: String, round: String): List<Int>
    = """(\d+)(?= $colour)""".toRegex().findAll(round).toList().map {
        if (it.value.first().toString() == "") {
            0
        } else {
            it.value.first().digitToInt()
        }
    }

/*
Function to return a List of every cube that was pulled of a given colour
 */
fun getCubeNumbersClone(colour: String, round: String): List<Int>
        = """(\d+)(?= $colour)""".toRegex().findAll(round).toList().map {
    if (it.value.first().toString().isEmpty()) {
        0
    } else {
        it.value.first().code
    }
}

/*
Function to look at the initial string and return a list of rounds
 */
fun getPickup(game: String): List<String>
    = game.substringAfter(':').split(';')

/*
function to return the amount of cubes of a given colour in a round
 */
fun getColour(colour: String, round: String): Int{
    return colour.split("""\d+(?=$colour)""".toRegex()).first().toInt()
}

/*
Function to look at the round given and return a map of which colours were found and how many
 */
fun getColourTotal(round: String, colour: String): Int{
    return TODO()
}
