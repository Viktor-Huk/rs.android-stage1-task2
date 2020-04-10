package subtask4

class Pangram {
    private val vowelsLower = arrayListOf('a', 'e', 'i', 'o', 'u', 'y')
    private val vowelsUpper = arrayListOf('A', 'E', 'I', 'O', 'U', 'Y')

    fun getResult(inputString: String): String {
        var result = ""

        when (isPangram(inputString)) {
            true -> {
                result = deleteAllSpaces(inputString)
                var array = result.split(" ")
                array = array.sortedBy { it.count { it in vowelsLower } }
                array = array.map { (it.count { it in vowelsLower }).toString() + it }
                result = array.joinToString(" ")
                result = replaceVowelsFromLowerToUpper(result)
            }
            false -> {
                result = deleteAllSpaces(inputString)

                if (result.isEmpty()) return result

                var array = result.split(" ")
                array = array.sortedBy { it.count { (it in 'a'..'z' || it in 'A'..'Z') && (it !in vowelsLower && it !in vowelsUpper) } }
                array = array.map { (it.count { (it in 'a'..'z' || it in 'A'..'Z') && (it !in vowelsLower && it !in vowelsUpper) }).toString() + it }
                result = array.joinToString(" ")
                result = replaceConsonantsFromLowerToUpper(result)
            }
        }
        return result
    }

    private fun replaceVowelsFromLowerToUpper(inputString: String): String {
        var result = ""

        for (i in inputString.indices) {
            result += if (inputString[i].isLowerCase() && inputString[i] in vowelsLower) {
                inputString[i].toUpperCase()
            } else {
                inputString[i]
            }
        }
        return result
    }

    private fun replaceConsonantsFromLowerToUpper(inputString: String): String {
        var result = ""

        for (i in inputString.indices) {
            result += if (inputString[i].isLowerCase() && inputString[i] in 'a'..'z' && inputString[i] !in vowelsLower) {
                inputString[i].toUpperCase()
            } else {
                inputString[i]
            }
        }
        return result
    }

    private fun isPangram(string: String) = string.map { it.toLowerCase() }.filter { it in 'a'..'z' }.toSet().size == 26

    private fun deleteAllSpaces(inputString: String): String {
        var string = inputString

        while (string.contains("\n")) {
            val res = string.replace("\n", " ")
            string = res
        }

        while (string.contains("  ")) {
            val res = string.replace("  ", " ")
            string = res
        }

        return string.trim()
    }
}
