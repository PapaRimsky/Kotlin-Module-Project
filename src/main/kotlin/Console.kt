class Console {
    fun getMenu(list: MutableList<String>) {
        return list.forEachIndexed { index, element -> println("$index. $element") }
    }

    fun doAction(point: String?, lambdaMenu: MutableList<() -> Int>): Int {
        return lambdaMenu[point!!.toInt()].invoke()
    }

    fun validate(request: String?, namedMenu: MutableList<String>): Boolean {
        return if (!request.isNullOrBlank()) request.toInt() in namedMenu.indices else false
    }

}