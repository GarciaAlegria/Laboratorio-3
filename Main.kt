//Abner Iván García Alegria- 21285
// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------
fun main() {
    val result = processList(listOf(30, "Hola", false, null))
    println(result)
}
fun processList(inputList: List<Any?>?): List<ItemData>? {
    val result = inputList?.let {
        var datas = ArrayList<ItemData>()
        it.forEachIndexed{ index, list -> when (list){
                is String -> {datas.add(ItemData(index,list,"string","L${list.length}"))}
                is Int -> {datas.add(ItemData(index,list,"int", listOf(10,5,2).firstOrNull { (list % it) == 0}?.let{"It is multiple of $it"}))}
                is Boolean -> {datas.add(ItemData(index,list,"boolean",if(list){"True"} else{"False"}))} else-> "Unknown"
                }
            }
        return datas
    }
    return result
}
