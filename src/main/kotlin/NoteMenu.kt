class NoteMenu(private val dir: Dir) {
    private val addDirLambda: () -> Int = addNote()
    val lambdaMenu = mutableListOf(addDirLambda)
    val namedMenu = mutableListOf("Создать заметку", "Выход")
    val key = "note"

    fun update() {
        namedMenu.removeLast()
        for ((key, value) in dir.notes) {
            namedMenu.add(value.name)
            lambdaMenu.add(getNote(key))
        }
        namedMenu.add("Выход")
    }

    private fun addNote(): () -> Int = {
        println("Введите имя заметки")
        val noteName = readlnOrNull()
        if (noteValidate(noteName)) {
            namedMenu.add(namedMenu.count() - 1, noteName!!)
            println("Введите текст заметки")
            dir.notes[namedMenu.count() - 2] = Note(noteName, readlnOrNull())
            lambdaMenu.add(getNote(namedMenu.count() - 2))
            println("Заметка успешно создана")
            -1
        } else {
            println("Заметка с таким именем уже существует или введено некорректное имя")
            -1
        }
    }

    private fun getNote(i: Int): () -> Int = { i }

    private fun noteValidate(request: String?): Boolean {
        return if (!request.isNullOrBlank()) dir.notes.filterValues { it.name == request }.isEmpty() else false
    }
}