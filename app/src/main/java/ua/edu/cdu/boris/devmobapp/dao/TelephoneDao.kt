package ua.edu.cdu.boris.devmobapp.dao

import androidx.room.*
import ua.edu.cdu.boris.devmobapp.model.Telephone

@Dao
interface TelephoneDao {
    @Query("SELECT * FROM telephones")
    suspend fun getAll(): List<Telephone>

    @Insert
    suspend fun insert(phone: Telephone)

    @Delete
    suspend fun delete(phone: Telephone)

    @Query("DELETE FROM telephones")
    suspend fun deleteAll()

    @Update
    suspend fun update(phone: Telephone)
}