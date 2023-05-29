class OpenNoteMenu(private val note: Note) {
    private val showTextLambda: () -> Int = showText()
    val lambdaMenu = mutableListOf(showTextLambda)
    val namedMenu = mutableListOf("Просмотреть заметку", "Выход")
    val key = "text"
    private fun showText(): () -> Int = {
        println("Текст заметки:\n" + note.text)
        -1
    }
}