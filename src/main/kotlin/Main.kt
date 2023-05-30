fun main(args: Array<String>) {
    val ages1: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7)
    val ages2: List<Int> = listOf(23, 54, 1, 4, 6, 344)
    val ages3: List<Int> = listOf(123, 254, 33, 44, 565, 46, 76)
    val ages4: List<Int> = listOf(221, 32, 36, 4, 56, 668, 997)

    val ages5: List<Int> = listOf(-1, -2, -3, -4, -5, -6, -7)
    val ages6: List<Int> = listOf(-23, -54, -1, -4, -6, -344)
    val ages7: List<Int> = listOf(-123, -254, -33, -44, 565, -46, -76)
    val ages8: List<Int> = listOf(-221, 32, -36, -4, 56, 668, -997)

    println(twoOldestAges(ages1))
    println(twoOldestAges(ages2))
    println(twoOldestAges(ages3))
    println(twoOldestAges(ages4))

    println(twoOldestAges(ages5))
    println(twoOldestAges(ages6))
    println(twoOldestAges(ages7))
    println(twoOldestAges(ages8))

    println("-----------------")

    println(maxTurbulenceSize(intArrayOf(9, 4, 2, 10, 7, 8, 8, 1, 9)))
    println(maxTurbulenceSize(intArrayOf(9, 4, 2, 10, 7, 8, 7, 10, 9)))
    println(maxTurbulenceSize(intArrayOf(4, 8, 12, 16)))
    println(maxTurbulenceSize(intArrayOf(0)))
    println(maxTurbulenceSize(intArrayOf()))
}

fun twoOldestAges(ages: List<Int>): List<Int> {
    var maxAge = Int.MIN_VALUE
    var secondMaxAge = Int.MIN_VALUE

    for (age in ages) {
        if (age > maxAge) {
            secondMaxAge = maxAge
            maxAge = age
        } else if (age > secondMaxAge) {
            secondMaxAge = age
        }
    }

    return listOf(secondMaxAge, maxAge)
}

fun maxTurbulenceSize(arr: IntArray): Int {
    if (arr.size <= 1) return arr.size

    var resultCurrent = 1
    var result = 0
    var isTur = true
    var isTurCurrent: Boolean

    for (i in 0 until arr.size - 1) {
        isTurCurrent = if (arr[i] == arr[i + 1]) isTur else (arr[i] < arr[i + 1])

        if (isTurCurrent == isTur) {
            result = maxOf(result, resultCurrent)
            resultCurrent = 2
        } else {
            resultCurrent++
        }

        isTur = isTurCurrent
    }

    result = maxOf(result, resultCurrent)
    return result
}





