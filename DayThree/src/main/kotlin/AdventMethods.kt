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

    fun getDigitIndexs(row: CharArray): List<Int> {
        var index = 0
        var digitCoOrds = mutableListOf<Int>()
        row.forEach { character ->
            if (character.isDigit()) {
                digitCoOrds.add(index)
            }
            index += 1
        }
        return digitCoOrds
    }

    fun getSymbolCoordinates(grid: List<CharArray>): List<List<Int>> {
        var xCoordinate = 0
        var gridCoordinates = mutableListOf<mutableListOf<Int>()>()
        grid.forEach { row ->
            getSymbolIndexs(row)
            gridCoordinates.
            xCoordinate+=1
        }
    }
}
