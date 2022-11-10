package ua.edu.cdu.boris.devmobapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    val title: String,
    val author: String,

    @ColumnInfo(name = "page_number")
    val pageNumber: Int,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id")
    val bookId: Int = 0
) : AdapterInterface {

    override fun getType(): Int {
        return AdapterInterface.BOOK_TYPE
    }
}