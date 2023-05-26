class OpenNoteMenu(private val note:Note):Menu() {
    private val showTextLambda: () -> ArrayList<Int> = showText()
    private val exitLambda: () -> ArrayList<Int> = exit()
    private val lambdaMenu= mutableListOf(showTextLambda,exitLambda)
    val namedMenu = mutableListOf("Просмотреть заметку","Выход")
    private fun showText(): () -> ArrayList<Int> = {
        println(note.text)
        arrayListOf(0)
    }
    private fun exit(): () -> ArrayList<Int> = { arrayListOf(0) }

}