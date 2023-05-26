class DirMenu():Menu() {
    val dirs= mutableMapOf<Int,Dir>()
    private val addDirLambda: () -> ArrayList<Int> = addDir()
    private val exitLambda: () -> ArrayList<Int> = exit()
    val lambdaMenu = mutableListOf(addDirLambda,exitLambda)
    val namedMenu = mutableListOf("Создать папку","Выход")

    private fun addDir(): () -> ArrayList<Int> = {
        println("Введите имя папки")
        val dirName:String?=readlnOrNull()
        if(dirValidate(dirName)){
            dirs[lambdaMenu.count()-1] = Dir(dirName!!, mutableMapOf())
            namedMenu.add(lambdaMenu.count()-1,dirName)
            val getDirLambda: () -> ArrayList<Int> = getDir(lambdaMenu.count()-1)
            lambdaMenu.add(lambdaMenu.count()-1,getDirLambda)
            println("Папка успешно создана")
            arrayListOf(0)
        }else{
            println("Папка с таким именем уже существует или введено некорректное имя")
            arrayListOf(0)
        }
    }
    private fun getDir(i: Int): () -> ArrayList<Int> = { arrayListOf(0,0,i) }
    private fun exit(): () -> ArrayList<Int> = { arrayListOf(1) }

    private fun dirValidate(request:String?):Boolean{
        if(request!=null){
            val filterName=dirs.filterValues{it.name==request}
            if(filterName.isEmpty()){
                return true
            }
            return false
        }
        return false
    }
}