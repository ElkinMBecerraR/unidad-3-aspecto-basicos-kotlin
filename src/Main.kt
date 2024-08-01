fun main() {
    val quiz = Quiz().apply { ImprimirQuiz() }
    quiz.PintarBarraProgreso()

}

data class Pregunta<T>(
    var pregunta: String,
    var respuesta: T,
    var dificultad: dmDificultad
) {
}

enum class dmDificultad {
    FACIL, MEDIO, DURO
}

interface BarraProgreso {
    var progresoTexto: String
    fun PintarBarraProgreso()
}

class Quiz : BarraProgreso {

    var pregunta = Pregunta<Int>("pregunta numero uno", 12, dmDificultad.FACIL)
    var pregunta2 = Pregunta<Boolean>("pregunta dos", true, dmDificultad.MEDIO)
    var pregunta3 = Pregunta<String>("pregunta tres", "Hello World!", dmDificultad.DURO)

    companion object ProgresoEstudiante {
        var total: Int = 10
        var respondida: Int = 3

    }

    override var progresoTexto: String = ""
        get() = "${Quiz.total} de  ${Quiz.respondida}"

    override fun PintarBarraProgreso() {
        repeat(Quiz.respondida) { print("▓") }
        repeat(Quiz.total - Quiz.respondida) { print("▒") }
        println()
        println(progresoTexto)
    }

    fun ImprimirQuiz() {
        pregunta.let {
            println(it.pregunta)
            println(it.respuesta)
            println(it.dificultad)
        }

        pregunta2.let {
            println(it.pregunta)
            println(it.respuesta)
            println(it.dificultad)
        }

        pregunta3.let {
            println(it.pregunta)
            println(it.respuesta)
            println(it.dificultad)
        }


    }
}