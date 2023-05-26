class NoteMenu(private val dir:Dir):Menu() {
    private val addDirLambda: () -> ArrayList<Int> = addNote()
    private val exitLambda: () -> ArrayList<Int> = exit()
    val lambdaMenu= mutableListOf(addDirLambda,exitLambda)
    val namedMenu = mutableListOf("Создать заметку","Выход")
    private fun addNote(): () -> ArrayList<Int> = {
        println("Введите имя заметки")
        val noteName=readlnOrNull()
        if(noteValidate(noteName)){
            println("Введите текст заметки")
            val noteText=readlnOrNull()
            dir.notes[lambdaMenu.count()-1] = Note(noteName!!,noteText)
            val getDirLambda: () -> ArrayList<Int> = getNote(lambdaMenu.count()-1)
            lambdaMenu.add(lambdaMenu.count()-1,getDirLambda)
            println("Заметка успешно создана")
            arrayListOf(0)
        }else{
            println("Заметка с таким именем уже существует или введено некорректное имя")
            arrayListOf(0)
        }
    }
    private fun getNote(i: Int): () -> ArrayList<Int> = { arrayListOf(0,1,i) }
    private fun exit(): () -> ArrayList<Int> = { arrayListOf(1) }

    private fun noteValidate(request:String?):Boolean{
        if(request!=null){
            val filterName=dir.notes.filterValues{it.name==request}
            if(filterName.isEmpty()){
                return true
            }
            return false
        }
        return false
    }
}