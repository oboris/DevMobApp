package ua.edu.cdu.boris.devmobapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ua.edu.cdu.boris.devmobapp.model.Book


@Dao
interface BookDao {
    @Query("SELECT * FROM books")
    suspend fun getAll(): List<Book>

    @Query("SELECT * FROM books WHERE book_id IN (:bookIds)")
    suspend fun loadAllByIds(bookIds: IntArray): List<Book>

    @Insert
    suspend fun insert(book: Book)

    @Delete
    suspend fun delete(book: Book)

    @Query("DELETE FROM books")
    suspend fun deleteAll()

    @Update
    suspend fun update(book: Book)
}

