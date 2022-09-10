package ua.edu.cdu.boris.devmobapp.model

data class Book(val title: String, val author: String, val pageNumber: Int): AdapterInterface {
    override fun getType(): Int {
        return AdapterInterface.bookType
    }
}