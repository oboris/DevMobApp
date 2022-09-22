package ua.edu.cdu.boris.devmobapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ua.edu.cdu.boris.devmobapp.model.Telephone

@Dao
interface TelephoneDao {
    @Query("SELECT * FROM telephones")
    suspend fun getAll(): List<Telephone>

    @Query("SELECT * FROM telephones WHERE phone_id IN (:phoneIds)")
    fun loadAllByIds(phoneIds: IntArray): List<Telephone>

    @Query("SELECT * FROM telephones WHERE screen_size = :screenSize")
    fun findByName(screenSize: Int): List<Telephone>

    @Insert
    suspend fun insert(phone: Telephone)

    @Delete
    suspend fun delete(phone: Telephone)
}