package subtask1

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val noResultExists = "Такого дня не существует"
        var result = ""
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy").withLocale(Locale("ru"))

        if (day.toInt() in 1..31 && month.toInt() in 1..12 && year.toInt() >= 0) {

            var dateForParameter = when (day.length) {
                1 -> "0$day"
                else -> day
            }

            dateForParameter += when (month.length) {
                1 -> "-0$month-$year"
                else -> "-$month-$year"
            }

            val date = LocalDate.parse(dateForParameter, formatter)

            if (!date.isLeapYear && day.toInt() == 29 && month.toInt() == 2) {
                return noResultExists
            }

            result += date.dayOfMonth.toString()

            result += when(date.month.toString()) {
                "JANUARY" -> " января,"
                "FEBRUARY" -> " февряля,"
                "MARCH" -> " марта,"
                "APRIL" -> " апреля,"
                "MAY" -> " мая,"
                "JUNE" -> " июня,"
                "JULY" -> " июля,"
                "AUGUST" -> " августа,"
                "SEPTEMBER" -> " сентября,"
                "OCTOBER" -> " октября,"
                "NOVEMBER" -> " ноября,"
                else -> " декабря,"
            }

            result += when(date.dayOfWeek.toString()) {
                "MONDAY" -> " понедельник"
                "TUESDAY" -> " вторник"
                "WEDNESDAY" -> " среда"
                "THURSDAY" -> " четверг"
                "FRIDAY" -> " пятница"
                "SATURDAY" -> " суббота"
                else -> " воскресенье"
            }
        } else {
            return noResultExists
        }

        return result
    }
}
