fun main(args: Array<String>) {

    val blueRange = 14
    val redRange = 12
    val greenRange = 13
    var totalPossible = 0
    var gameNumber = 1
    getInput("input.txt").forEach { game ->
        println(game)

        val gameList = getGamesList(game)
        var pickupsPossible = 0
        gameList.forEach{pickup ->
            println(pickup)
            var blueAmount = 0
            var redAmount = 0
            var greenAmount = 0
            pickup.split(',').forEach {colourDrop ->
                blueAmount = ifColour(colourDrop,"blue", blueAmount)
                redAmount = ifColour(colourDrop,"red", redAmount)
                greenAmount = ifColour(colourDrop,"green", greenAmount)
            }
            pickupsPossible = if (
                blueAmount <= blueRange &&
                redAmount <= redRange &&
                greenAmount <= greenRange
            ){
                println("Blue Amount: $blueAmount")
                println("Red Amount: $redAmount")
                println("Green Amount: $greenAmount")
                pickupsPossible+1
            } else {
                pickupsPossible
            }
        }
        totalPossible = if (
            pickupsPossible == gameList.size
        ){
            totalPossible+1
        } else {
            totalPossible
        }
        println("Game:$gameNumber - Possible Games: $totalPossible")
        gameNumber += 1
        println("--------------------------------------------------------")
    }

    println("Final: $totalPossible")
}

/*
Function to retrieve the text input
 */
fun getInput(fileName: String): List<String>
        = object {}.javaClass.getResourceAsStream(fileName)?.bufferedReader()?.readLines() ?: listOf("No File Found")

/*
Function to look at the initial string and return a list of rounds
 */
fun getGamesList(game: String): List<String>
        = game.substringAfter(':').split(';')

/*
Function to find the given colour amount, if any
 */
fun getColourAmount(pickup: String, colour: String): Int{
    return if (pickup.lowercase().contains(colour)){
        val colourIndex = pickup.indexOf(colour)
        return pickup.substring(0,colourIndex).trim().toInt()
    }
    else{
        0
    }
}

/*
Function to look at the colourDrop and see if it contains the colour given
 */
fun ifColour(colourDrop: String,colour: String, origionalNumber: Int): Int
    = if(colourDrop.lowercase().contains(colour)){
        if (getColourAmount(colourDrop, colour) > origionalNumber){
            getColourAmount(colourDrop, colour)
        }else{
            origionalNumber
        }
    } else{
        origionalNumber
    }
