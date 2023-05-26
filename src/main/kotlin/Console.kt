class Console {
    fun getMenu(list: MutableList<String>) {
        return list.forEachIndexed { index, element -> println("$index. $element") }
    }
    fun doAction(point:String?,lambdaMenu: MutableList<()->ArrayList<Int>>):ArrayList<Int>{
        return if(validate(point,lambdaMenu)){
            lambdaMenu[point!!.toInt()].invoke()
        }else{
            println("Такого пунтка не существует")
            arrayListOf(0)
        }
    }
    private fun validate(request:String?,lambdaMenu: MutableList<()->ArrayList<Int>>):Boolean{
        val req=request?.toIntOrNull()
        if(req!=null){
            if(req in lambdaMenu.indices){
                return true
            }
            return false
        }
        return false
    }
}