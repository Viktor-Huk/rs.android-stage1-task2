package subtask5

import java.time.LocalDate
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        val result = blockA.filter { it::class == blockB }

        when (blockB) {
            String::class -> {
                return result.joinToString("")
            }

            Int::class -> {
                return result.sumBy { it as Int }
            }

            LocalDate::class -> {
                val dates: List<LocalDate> = result as List<LocalDate>
                val res = dates.maxBy { it.atStartOfDay() }
                return "${res?.dayOfMonth}.${res?.monthValue}.${res?.year}"
            }
        }
        return ""
    }
}
