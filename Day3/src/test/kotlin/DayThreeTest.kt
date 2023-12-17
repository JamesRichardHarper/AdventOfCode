import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayThreeTest {
    private val adventMethods = AdventMethods()
    @Test
    /*
    Test case for if the given char is a digit or a period
     */
    fun testIfSymbol() {
        val result = adventMethods.isSymbol('*')
        assertEquals(true,result)
    }
    @Test
    /*
    Test case for finding the index of symbols in a given array
     */
    fun getSymbolIndexs(){
        val result = adventMethods.getSymbolIndexs(charArrayOf('.','.','*','.','/'))
        assertEquals(listOf(2,4),result)
    }
    @Test
    /*
    Test case for finding multiple character digits on a given x-axis
     */
    fun getDigitIndexs(){
        val result = adventMethods.getDigitIndexs(charArrayOf('.','/','4','5','.','7'))
        assertEquals(
            mapOf(
                2 to 4,
                3 to 5,
                5 to 7
            ), result)
    }
    @Test
    /*
    Test case for finding the coordinates of a symbol in a given double array
     */
    fun getSymbolCoordinate(){
        val result = adventMethods.getSymbolCoordinates(
            listOf(
                charArrayOf('.','.','*','.','/'),
                charArrayOf('.','/','4','5','.','7')
            )
        )
        assertEquals(
            listOf(
                listOf(0,2),
                listOf(0,4),
                listOf(1,1)
            ), result
        )
    }

    @Test
    /*
    Given a grid system
    When the coordinates of a digit are found
    Then the coordinates and the number will be collected
     */
    fun getDigitCoordinate(){
        val result = adventMethods.getDigitCoordinates(
            listOf(
                charArrayOf('.','.','*','.','/'),
                charArrayOf('.','/','4','5','.','7')
            )
        )
        assertEquals(
            mapOf(
                listOf(1,2) to 4,
                listOf(1,3) to 5,
                listOf(1,5) to 7
            ), result
        )
    }

    @Test
    /*
    Given a digit coordinate and a list of symbol coordinate
    When a digit is found to be adjacent to a symbol
    Then a bool of true will be returned
     */
    fun getAdjacent() {
        val result = adventMethods.isAdjacent(
            listOf(4,2) to 5,
            listOf(
                listOf(0,5),
                listOf(5,3),
                listOf(10,10)
            )
        )
        assertEquals(true,result)
    }

    @Test
    /*
    Given a list of symbol coordinates and a list of digit coordinates
    When a symbol is found to be adjacent to a digit
    Then a list of those digits will be returned
     */
    fun getLookup() {
        val result = adventMethods.getMatches(
            listOf(
                listOf(0,5),
                listOf(5,3),
                listOf(10,10)
            ),
            mapOf(
                listOf(1,2) to 4,
                listOf(1,3) to 5,
                listOf(1,5) to 7,
                listOf(9,9) to 8,
                listOf(8,9) to 1,
                listOf(7,9) to 2
            )
        )
        assertEquals(
            mapOf(
                listOf(1,5) to 7,
                listOf(9,9) to 8
            )
            ,result
        )
    }

    @Test
    /*
    OLD
    Given a digit coordinate, and a digit coordinate list
    When a coordinate is matched
    Then the entire number will be returned
    ----
    Given a digit coordinate, and a digit coordinate list
    When a coordinate is matched
    Then the coordinates of that number will be returned
     */
    fun getConcatinated() {
        val result = adventMethods.getNumberCoordinates(
            listOf(9,9) to 8,
            mapOf(
                listOf(1,2) to 4,
                listOf(1,3) to 5,
                listOf(1,5) to 7,
                listOf(7,9) to 2,
                listOf(8,9) to 1,
                listOf(9,9) to 8
            )
        )
        assertEquals(
            mapOf(
                listOf(7,9) to 2,
                listOf(8,9) to 1,
                listOf(9,9) to 8
            )
            ,result
        )
    }

    @Test
    /*
    Given a map of coordinates to digits that were found adjacent to symbols,
        and a secondary map containing all coordinates to digits
    When a digit in the confirmed list is found in the total list
    Then it will be concatenated with any numbers in a row next to it, and returned as a list
     */
    fun getFinishedNumberCoordinates() {
        val result = adventMethods.getNumberList(
            mapOf(
                listOf(1,5) to 7,
                listOf(8,9) to 1,
                listOf(9,9) to 8
            ),
            mapOf(
                listOf(1,2) to 4,
                listOf(1,3) to 5,
                listOf(1,5) to 7,
                listOf(7,9) to 2,
                listOf(8,9) to 1,
                listOf(9,9) to 8
            )

        )
        assertEquals(
            listOf(
                mapOf(
                    listOf(1,5) to 7
                ),
                mapOf(
                    listOf(7,9) to 2,
                    listOf(8,9) to 1,
                    listOf(9,9) to 8
                )
            ), result
        )
    }

    @Test
    /*
    Given a distinct list of maps containing the coordinates of a whole number
    When each full number is converted into an Int
    Then the full given number of the list shall be returned
     */
    fun getTotalNumber() {
        val result = adventMethods.getNumberFromDistinct(
            listOf(
                mapOf(
                    listOf(1,5) to 7
                ),
                mapOf(
                    listOf(7,9) to 2,
                    listOf(8,9) to 1,
                    listOf(9,9) to 8
                )
            )
        )
        assertEquals(
            listOf(
                7, 218
            ), result
        )
    }
}