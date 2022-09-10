package ua.edu.cdu.boris.devmobapp.model

data class Telephone(
    val name: String,
    val screenSize: Int
) : AdapterInterface {

    override fun getType(): Int {
        return AdapterInterface.PHONE_TYPE
    }
}
