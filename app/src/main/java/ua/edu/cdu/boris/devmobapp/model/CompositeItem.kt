package ua.edu.cdu.boris.devmobapp.model

import com.google.gson.annotations.SerializedName

data class CompositeItem(
    val name: String,
    @SerializedName("screen_size")
    val screenSize: Int,
    val type: Int,
    val title: String,
    val author: String,
    @SerializedName("page_number")
    val pageNumber: Int
){
    fun toAdapterInterface(): AdapterInterface = when (type) {
        AdapterInterface.PHONE_TYPE -> Telephone(name, screenSize)
        else -> Book(title, author, pageNumber)
    }
}
