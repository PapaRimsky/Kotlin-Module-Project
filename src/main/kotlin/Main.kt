fun main(args: Array<String>) {
    val console = Console()
    val dirMenu = DirMenu()
    start(console,dirMenu.namedMenu,dirMenu.lambdaMenu,dirMenu)
}
fun start(
    console:Console,
    namedMenu:MutableList<String>,
    lambdaMenu:MutableList<()->ArrayList<Int>>,
    dirMenu:DirMenu
) {
    do{
        console.getMenu(namedMenu)
        val result:ArrayList<Int> = console.doAction(readlnOrNull(),lambdaMenu)
        if(result.count()==3){
            when(result[1]){
                0->{
                    val noteMenu=NoteMenu(dirMenu.dirs[result[2]]!!)
                    start(console,noteMenu.namedMenu,noteMenu.lambdaMenu,dirMenu)
                }
                1->{

                }
            }
        }

    }while(result[0]!=1)
}
/*
fun cycle(menu: Menu){
    do{
        println(menu.getMenu())
        val result=menu.doRequest(readlnOrNull())
        println(result)
        if(result.toIntOrNull()!=null){
            if(menu is DirMenu){
                val dir=menu.getDirById(result.toInt())
                cycle(NoteMenu(dir))
            }else if(menu is NoteMenu){
                val note=menu.getNoteById(result.toInt())
                cycle(OpenNoteMenu(note))
            }
        }
    }while(result!="Выход")
}
 */

/*
fun cycle(menu:DirMenu){
    do{
        println(menu.getMenu())
        val result=menu.doRequest(readlnOrNull())
        println(result)
        if(result.toIntOrNull()!=null){
            if(menu is DirMenu){
                val listNotes=menu.getNotesInDir(result.toInt())
                cycle(NoteMenu(listNotes))
            }else if(menu is NoteMenu){
                val note=menu.getNoteById(result.toInt())
                cycle(OpenNoteMenu())
            }
        }
    }while(result!="Выход")
}
 */