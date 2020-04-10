package subtask3

class Abbreviation {


    fun abbreviationFromA(a: String, b: String): String {

        if (a.toLowerCase().contains(b.toLowerCase())) {
            return "YES"
        }

        var first = 0
        var d = ""

        for (i in b.indices) {
            for (j in first until a.length) {

                if (b[i].toLowerCase() == a[j].toLowerCase()) {
                    d += b[i]
                    first += j + 1
                }
            }
        }

        if (d.toLowerCase() == b.toLowerCase()) {
            return "YES"
        }

        return "NO"
    }
}
