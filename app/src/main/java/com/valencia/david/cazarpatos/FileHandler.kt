package com.valencia.david.cazarpatos

/* Lab05 */
interface FileHandler {
    fun SaveInformation(datosAGrabar:Pair<String,String>)
    fun ReadInformation():Pair<String,String>
}
