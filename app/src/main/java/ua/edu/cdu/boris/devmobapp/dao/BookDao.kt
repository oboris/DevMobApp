package ua.edu.cdu.boris.devmobapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ua.edu.cdu.boris.devmobapp.model.Book


@Dao
interface BookDao {
    @Query("SELECT * FROM books")
    suspend fun getAll(): List<Book>

    @Query("SELECT * FROM books WHERE book_id IN (:bookIds)")
    fun loadAllByIds(bookIds: IntArray): List<Book>

    @Query("SELECT * FROM books WHERE author LIKE :author LIMIT 1")
    fun findByName(author: String): Book

    @Insert
    suspend fun insert(book: Book)

    @Delete
    fun delete(book: Book)
}

