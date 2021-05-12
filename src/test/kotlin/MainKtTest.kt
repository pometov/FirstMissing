import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @Test
    fun segregate() {
        val arr = longArrayOf(0, 10, 2, -10, -20, 1)

        val negativeElementsCount:Int = segregate(arr, arr.size)


        assertEquals(3, negativeElementsCount)
        assertArrayEquals(longArrayOf(0, -10, -20, 10, 2, 1), arr)
    }

    @Test
    fun positiveArray() {
        val arr = longArrayOf(0, 2, -20, -30, -40, 25, 26, 30)

        val positiveArr = positiveArray(arr)

        assertArrayEquals(longArrayOf( 2, 25, 26, 30), positiveArr)
    }

    @Test
    fun findMissingPositive() {
        val arr = longArrayOf(2, 20, 30, 40, 25, 26, 31)
        val size = arr.size

        val missingPositive = findMissingPositive(arr, size)

        assertEquals(1, missingPositive)
    }

    @Test
    fun arrayLengthOverflow(){
        val arr = LongArray(301) { i -> i.toLong() }
        val exp: Exception = assertThrows(IllegalArgumentException::class.java)
        {
            positiveArray(arr)
        }

        assertEquals("Array > 300", exp.message)
    }

    @Test
    fun arrayIsEmpty(){
        val arr = LongArray(0)
        val exp: Exception = assertThrows(IllegalArgumentException::class.java)
        {
            positiveArray(arr)
        }

        assertEquals("Array < 1", exp.message)
    }

    @Test
    fun intRange(){
        val arr = longArrayOf(5147483647, 20, 30, 40, 25, 26, 31)
        val size = arr.size
        val exp: Exception = assertThrows(IllegalArgumentException::class.java)
        {
            segregate(arr, size)
        }

        assertEquals("Out of Integer range!", exp.message)
    }
}