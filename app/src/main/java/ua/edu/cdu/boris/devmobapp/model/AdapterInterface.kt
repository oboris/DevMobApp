package ua.edu.cdu.boris.devmobapp.model

interface AdapterInterface {
    fun getType(): Int

    companion object {
        const val BOOK_TYPE: Int = 1
        const val PHONE_TYPE: Int = 2
    }
}