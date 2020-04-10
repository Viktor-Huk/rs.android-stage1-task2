package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        var result = ""

        if (hour.toInt() in 0..12 && minute.toInt() in 0..60) {

            when {
                minute == "00" -> return getNumber(hour) + " o' clock"
                minute == "15" -> return "quarter past ${getNumber(hour)}"
                minute == "45" -> return "quarter to ${getNumber((hour.toInt() + 1).toString())}"
                minute == "30" -> return "half past ${getNumber(hour)}"
                minute.toInt() in 31..59 -> {

                    return when (val tmp = (60 - minute.toInt())) {
                        1 -> "one minute to ${getNumber((hour.toInt() + 1).toString())}"
                        in 2..19 -> "${getNumber(tmp.toString())} minutes to ${getNumber((hour.toInt() + 1).toString())}"
                        else -> "${getNumber(((tmp.toString()[0]).toString().toInt() * 10).toString())} ${getNumber((tmp.toString()[1]).toString())} minutes to ${getNumber((hour.toInt() + 1).toString())}"
                    }
                }
                (minute.toInt() in 1..29) -> {

                    return when (minute.toInt()) {
                        1 -> "one minute past ${getNumber(hour)}"
                        else -> "${getNumber(minute)} minutes past ${getNumber(hour)}"
                    }
                }
                else -> ""
            }

        } else {
            return ""
        }
        return result
    }

    private fun getNumber(number: String) = when (number.toInt()) {
        1 -> "one"
        2 -> "two"
        3 -> "three"
        4 -> "four"
        5 -> "five"
        6 -> "six"
        7 -> "seven"
        8 -> "eight"
        9 -> "nine"
        10 -> "ten"
        11 -> "eleven"
        12 -> "twelve"
        13 -> "thirteen"
        14 -> "fourteen"
        15 -> "fifteen"
        16 -> "sixteen"
        17 -> "seventeen"
        18 -> "eighteen"
        19 -> "nineteen"
        20 -> "twenty"
        30 -> "half"
        40 -> "forty"
        50 -> "fifty"
        else -> "sixty"
    }
}
