package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        val listFibonacci = createFibonacciNumbers(n)

        for (id in listFibonacci.indices) {
            return if (listFibonacci[id] * listFibonacci[id + 1] == n) {
                intArrayOf(listFibonacci[id], listFibonacci[id + 1], 1)
            } else if (listFibonacci[id] * listFibonacci[id + 1] < n) {
                continue
            } else {
                intArrayOf(listFibonacci[id], listFibonacci[id + 1], 0)
            }
        }
        return intArrayOf()
    }

    fun createFibonacciNumbers(value: Int): List<Int> {
        val listFibonacci = mutableListOf(0, 1)
        var i = -1

        do {
            i++
            listFibonacci.add(listFibonacci[i] + listFibonacci[i + 1])
        } while (value > listFibonacci[i] * listFibonacci[i + 1])

        return listFibonacci
    }
}
