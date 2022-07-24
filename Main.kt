    // No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String,
    var info: String
)
// -----------------------
fun main() {
    val result = processList(listOf(30, "Hola", null, true))
    println(result)
}
fun processList(inputList: List<Any?>?): List<ItemData>? {
    var lista = ArrayList<ItemData>()
    if(inputList == null){
        return null
    }
    //aqui es para ver si la lista tiene espacios vacios
    if(inputList.isEmpty()){
        return lista
    }

    for((index, valor) in inputList.withIndex()){
        if(valor != null){
            val espacio = ItemData(
                originalPos = index,
                originalValue = valor,
                type = visualizartipo(valor),
                info = visualizarinfo(valor)
            )
            lista.add(espacio)
        }
    }
    return lista
}
//aqui es para declarar de que tipo es
fun visualizartipo(valor: Any): String{
    return when (valor){
        is String -> "string"
        is Int -> "int"
        is Boolean -> "booleano"
        else -> "unknown"
    }
}
//aqui es para agregar la l al imprimir y que vea de que multiplo es el entero
fun visualizarinfo(valor: Any): String{
    return when (valor){
        is String -> {
            "L" + valor.length
        }

        is Int -> {
            if(valor % 10 == 0){//es multipo de 10
                "M10"
            }
            else if(valor % 5 == 0){//es multiplo de 5
                "M5"
            }
            else if(valor % 2 == 0){//es multiplo de 2
                "M2"
            }
            else{
                "-"
            }
        }
        is Boolean -> ({
            fun conditionalAssignment(boolean: Boolean){
                var result:String = if (boolean) { "Verdadero" } else{ "Falso" } } }).toString() else -> "unknown" }
}