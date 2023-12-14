fun main(args: Array<String>) {
    val total = readInput("inputList.txt").sumOf { getNum(it) }
    println(total)
}

/*
Function to get the number embedded within the string given
 */
fun getNum(line: String): Int{
    /*
    Embedded Function to check if the given character can be parsed
    */
    fun isNumberChar(character: Char): Boolean {
        return character.toString().toDoubleOrNull() != null
    }

    val lineMapped = hasNumberString(line)

    val firstNumber = Pair(
        line.indexOfFirst { isNumberChar(it) },
        line.first{isNumberChar(it)}.toString()
    )

    val lastNumber = Pair(
        line.indexOfLast { isNumberChar(it) },
        line.last{isNumberChar(it)}.toString()
    )

    lineMapped[line.indexOfFirst { isNumberChar(it) }] = line.first{isNumberChar(it)}.toString()
    lineMapped[line.indexOfLast { isNumberChar(it) }] = line.last{isNumberChar(it)}.toString()

    val sortedMap = lineMapped.toSortedMap()
    println(sortedMap)
    val totalSize = sortedMap.size -1
    val finalNumber = sortedMap.firstKey() + sortedMap.lastKey()
    println(finalNumber)

    return (firstNumber.second + lastNumber.second).toInt()
//    return (sortedMap[0] + sortedMap[sortedMap.size-1]).toInt()
}

/*
Function to load in a file of the given name.
If nothing is found, will return a single element list of "No File" using Elvis operator
 */
fun readInput(fileName: String): List<String>
    = object {}.javaClass.getResourceAsStream(fileName)?.bufferedReader()?.readLines() ?: listOf("No File")

/*
Function to load in the given string and find anything that matches the Number ENUM
Returns the number, and the character start
 */
fun hasNumberString(line: String): MutableMap<Int,String>{
    var totalNumbers = mutableMapOf<Int, String>()
    for (numberEnum in Numbers.entries){
        val numberFormatted = numberEnum.toString().lowercase()
        if(line.contains(numberFormatted)){
            totalNumbers[line.indexOf(numberFormatted)] = numberEnum.numbers
        }
    }
    return totalNumbers
}