class DirMenu(private val dirs: MutableMap<Int, Dir>) {
    private val addDirLambda: () -> Int = addDir()
    val lambdaMenu = mutableListOf(addDirLambda)
    val namedMenu = mutableListOf("Создать папку", "Выход")
    val key = "dir"

    private fun addDir(): () -> Int = {
        println("Введите имя папки")
        val dirName: String? = readlnOrNull()
        if (dirValidate(dirName)) {
            dirs[namedMenu.count() - 1] = Dir(dirName!!, mutableMapOf())
            namedMenu.add(namedMenu.count() - 1, dirName)
            lambdaMenu.add(getDir(lambdaMenu.count()))
            println("Папка успешно создана")
            -1
        } else {
            println("Папка с таким именем уже существует или введено некорректное имя")
            -1
        }
    }

    private fun getDir(i: Int): () -> Int = { i }

    private fun dirValidate(request: String?): Boolean {
        return if (!request.isNullOrBlank()) dirs.filterValues { it.name == request }.isEmpty() else false
    }
}