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
        assertEquals(listOf(2,3,5), result)
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
                listOf(0,5),
                listOf(1,1)
            ), result
        )
    }
}