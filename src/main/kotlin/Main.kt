fun main() {
    val dirs = mutableMapOf<Int, Dir>()
    val console = Console()
    val dirMenu = DirMenu(dirs)
    start(dirs, console, dirMenu.namedMenu, dirMenu.lambdaMenu, dirMenu.key, null)
}

fun start(
    dirs: MutableMap<Int, Dir>,
    console: Console,
    namedMenu: MutableList<String>,
    lambdaMenu: MutableList<() -> Int>,
    key: String,
    parentId: Int?
) {
    do {
        console.getMenu(namedMenu)
        println("Введите номер пункта меню")
        val choice = readlnOrNull()
        if (console.validate(choice, namedMenu)) {
            if (choice!!.toInt() != namedMenu.count() - 1) {
                val result = console.doAction(choice, lambdaMenu)
                if (result != -1) {
                    if (key == "dir") {
                        val noteMenu = NoteMenu(dirs[result]!!)
                        noteMenu.update()
                        start(dirs, console, noteMenu.namedMenu, noteMenu.lambdaMenu, noteMenu.key, result)
                    } else if (key == "note") {
                        val openNoteMenu = OpenNoteMenu(dirs[parentId!!.toInt()]!!.notes[result]!!)
                        start(dirs, console, openNoteMenu.namedMenu, openNoteMenu.lambdaMenu, openNoteMenu.key, result)
                    }
                }
            } else {
                break
            }
        } else {
            println("Такого пункта нет")
        }
    } while (true)
}