class IndeksNilaiMatkul {
    fun hitungIndeks(nilai: Int): String {
        return when (nilai) {
            in 85..100 -> "A"
            in 70..84 -> "B"
            in 60..69 -> "C"
            in 0..59 -> "D"
            else -> "Nilai di luar jangkauan"
        }
    }
}

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Nilai harus diisi")
        return
    }

    val nilai = args[0].toIntOrNull()

    if (nilai == null) {
        println("Nilai harus berupa angka.")
        return
    }

    val indeksNilaiMatkul = IndeksNilaiMatkul()
    val indeks = indeksNilaiMatkul.hitungIndeks(nilai)
    println("Input: $nilai")
    println("Output: $indeks")
}