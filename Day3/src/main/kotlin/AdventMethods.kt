class AdventMethods {
    fun isSymbol(character: Char): Boolean {
        val disAllowedCharacters = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.')
        return !disAllowedCharacters.contains(character)
    }

    fun getSymbolIndexs(row: CharArray): List<Int> {
        var index = 0
        var symbolCoOrds = mutableListOf<Int>()
        row.forEach { character ->
            if (isSymbol(character)) {
                symbolCoOrds.add(index)
            }
            index += 1
        }
        return symbolCoOrds
    }

    fun getDigitIndexs(row: CharArray): Map<Int,Int> {
//        var index = 0
//        var digitCoOrds = mutableMapOf<Int,Int>()
//        row.forEach { character ->
//            if (character.isDigit()) {
//                digitCoOrds[index] = character.digitToInt()
//            }
//            index += 1
//        }
        return row.mapIndexed{ index, character ->
            if (character.isDigit()){
                index to character.digitToInt()
            }else{
                index to 10
            }
        }.filter {pair ->
            pair.second != 10
        }.toMap()
    }

    fun getSymbolCoordinates(grid: List<CharArray>): List<List<Int>> {
        var xCoordinate = 0
        var gridCoordinates = mutableListOf(emptyList<Int>())
        grid.forEach { row ->
            getSymbolIndexs(row).forEach { yCoordinate ->
                gridCoordinates.add(listOf(xCoordinate,yCoordinate))
            }
            xCoordinate+=1
        }
        return gridCoordinates.drop(1)
    }

    fun getDigitCoordinates(grid: List<CharArray>): Map<List<Int>,Int> {
//        var xCoordinate = 0
//        var gridCoordinates = mutableListOf(emptyList<Int>())
//        grid.forEach { row ->
//            getDigitIndexs(row).forEach { yCoordinate ->
//                gridCoordinates.add(listOf(xCoordinate,yCoordinate))
//            }
//            xCoordinate+=1
//        }
//        return gridCoordinates.drop(1)
        return grid.mapIndexed{index, row ->
            getDigitIndexs(row).map { digit ->
                listOf(index,digit.key) to digit.value
            }
        }.flatten().toMap()
    }

    fun isAdjacent(digitCoOrds: Pair<List<Int>, Int>, listOfSymbolCoOrds: List<List<Int>>): Boolean {
        val xCoOrd = digitCoOrds.first[0]
        val yCoOrd = digitCoOrds.first[1]
        val potentialCoOrds = listOf(
            listOf(xCoOrd-1,yCoOrd-1),
            listOf(xCoOrd,yCoOrd-1),
            listOf(xCoOrd+1,yCoOrd-1),
            listOf(xCoOrd-1,yCoOrd),
            listOf(xCoOrd+1,yCoOrd),
            listOf(xCoOrd-1,yCoOrd+1),
            listOf(xCoOrd,yCoOrd+1),
            listOf(xCoOrd+1,yCoOrd+1)
        )
        return !listOfSymbolCoOrds.find { symbolCoOrd ->
            potentialCoOrds.contains(symbolCoOrd)
        }.isNullOrEmpty()
    }

    fun getMatches(symbolCoordinates: List<List<Int>>,
                   digitCoordinates: Map<List<Int>, Int>): Map<List<Int>, Int> {
        return digitCoordinates.filter { digits ->
            isAdjacent(digits.toPair(),symbolCoordinates)
        }
    }

    fun getNumberList(confirmedDigits: Map<List<Int>, Int>, totalMap: Map<List<Int>, Int>): List<Int> {

        return listOf(7, 218)
    }

    fun getNumber(confirmedDigit: Pair<List<Int>, Int>, totalMap: Map<List<Int>, Int>): Int {
        val xCoOrd = confirmedDigit.first[0]
        val inLineForward = { index: Int, comparator: Int ->  index+1 == comparator}

        totalMap.filter { digits ->
            digits.key[1] == confirmedDigit.first[1]
        }.filter { sameXDigits ->
            inLineForward()

        }
        return 218
    }
}
