package org.example

data class Student(
    val nume: String,
    val prenume: String,
    val grupa: String,
    val note: List<Int>
) {
    fun media(): Double = note.average()

    fun numarRestante(): Int = note.count { it < 5 }

    fun esteIntegralist(): Boolean = numarRestante() == 0

    override fun toString(): String {
        return "$nume $prenume, grupa: $grupa, " +
                "note: $note, media: ${"%.2f".format(media())}, " +
                "restante: ${numarRestante()}"
    }
}

fun main() {

    val dateStudenti = listOf(
        Triple("Popescu", "Ana", "A1"),
        Triple("Ionescu", "Mihai", "A2"),
        Triple("Georgescu", "Maria", "A1"),
        Triple("Dumitru", "Andrei", "A2"),
        Triple("Marin", "Elena", "A1")
    )


    val studenti = dateStudenti.map { (nume, prenume, grupa) ->
        Student(
            nume,
            prenume,
            grupa,
            List(5) { (4..10).random() }
        )
    }

    println("LISTA INITIALA:")
    studenti.forEach { println(it) }


    val alfabetici = studenti.sortedWith(
        compareBy<Student> { it.grupa }
            .thenBy { it.nume }
            .thenBy { it.prenume }
    )

    println("\n ordine alfabetica pe grp")
    alfabetici.forEach { println(it) }


    val integralisti = studenti
        .filter { it.esteIntegralist() }
        .sortedByDescending { it.media() }

    println("\nintegralisti medii descr")
    integralisti.forEach { println(it) }


    val restantieri = studenti
        .filter { !it.esteIntegralist() }
        .sortedBy { it.numarRestante() }

    println("\n restantieri medii cresc")
    restantieri.forEach { println(it) }
}