package ua.edu.cdu.boris.devmobapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "telephones")
data class Telephone(
    val name: String,
    @ColumnInfo(name = "screen_size")val screenSize: Int,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "phone_id")
    val phoneId: Int = 0
) : AdapterInterface {


    override fun getType(): Int {
        return AdapterInterface.PHONE_TYPE
    }
}
