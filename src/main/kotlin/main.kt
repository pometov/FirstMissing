import kotlin.math.abs

fun main(args: Array<String>) {
    val arr = longArrayOf(2, 3, 1)
    val positiveArr: LongArray = positiveArray(arr)
    val missing: Int = findMissingPositive(positiveArr, positiveArr.size)
    println("The smallest positive missing number is $missing")
}

fun positiveArray(arr: LongArray): LongArray {
    val size: Int = arr.size
    if (size<1) throw IllegalArgumentException("Array < 1")
    if (size>300)  throw IllegalArgumentException("Array > 300")
    val shift: Int = segregate(arr, size)
    val arr2 = LongArray(size - shift)
    var j: Int = 0
    for (i in shift until size) {
        arr2[j] = arr[i]
        j++
    }
    return arr2


}

fun findMissingPositive(arr: LongArray, size: Int): Int{
    var i = 0
        while (i < size) {
            val x = abs(arr[i]).toInt()
            if (x - 1 < size && arr[x - 1] > 0) arr[x - 1] = -arr[x - 1]
            i++
        }
        i = 0
        while (i < size) {
            if (arr[i] > 0) return i + 1
            i++
        }
    return size + 1
}

fun segregate(arr: LongArray, size: Int): Int {
    var j = 0
    var i = 0
    while (i < size) {
        if (arr[i] > Int.MAX_VALUE || arr[i] < Int.MIN_VALUE) throw IllegalArgumentException("Out of Integer range!")
        if (arr[i] <= 0) {
            val temp: Long = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            j++
        }
        i++
    }
    return j
}