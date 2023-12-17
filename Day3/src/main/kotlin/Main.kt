fun main(args: Array<String>) {
    val input = getInput("input.txt")
    val formattedInput = input.map {
        it.toCharArray()
    }
    var adventMethods = AdventMethods()
    val symbols = adventMethods.getSymbolCoordinates(formattedInput)
    val digits = adventMethods.getDigitCoordinates(formattedInput)
    val matches = adventMethods.getMatches(symbols,digits)
    val adjacentNumberList = adventMethods.getNumberList(matches,digits)
    val finalNumber = adventMethods.getNumberFromDistinct(adjacentNumberList).sum()
//    symbols.forEach {
//        println(it)
//    }
//    digits.forEach {
//        println(it)
//    }
//    matches.forEach {
//        println(it)
//    }
    adjacentNumberList.forEach {
        println(it)
    }
    println(finalNumber)
}

/*
Function to retrieve the text input
 */
fun getInput(fileName: String): List<String>
        = object {}.javaClass.getResourceAsStream(fileName)?.bufferedReader()?.readLines() ?: listOf("No File Found")