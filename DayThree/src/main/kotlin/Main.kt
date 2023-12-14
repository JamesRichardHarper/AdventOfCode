fun main(args: Array<String>) {
    val input = getInput("input.txt")



}

/*
Function to retrieve the text input
 */
fun getInput(fileName: String): List<String>
        = object {}.javaClass.getResourceAsStream(fileName)?.bufferedReader()?.readLines() ?: listOf("No File Found")