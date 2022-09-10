package ua.edu.cdu.boris.devmobapp.model

interface AdapterInterface {
    fun getType(): Int

    companion object {
        const val bookType = 1
        const val phoneType = 2
    }
}