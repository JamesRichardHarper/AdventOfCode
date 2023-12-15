fun main(args: Array<String>) {
    val input = getInput("input.txt")
    val formattedInput = input.map {
        it.toCharArray()
    }
    var adventMethods = AdventMethods()
    val coOrds = adventMethods.getSymbolCoordinates(formattedInput)
    coOrds.forEach {
        println(it)
    }

}

/*
Function to retrieve the text input
 */
fun getInput(fileName: String): List<String>
        = object {}.javaClass.getResourceAsStream(fileName)?.bufferedReader()?.readLines() ?: listOf("No File Found")