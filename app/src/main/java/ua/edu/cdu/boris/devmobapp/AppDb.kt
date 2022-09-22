package ua.edu.cdu.boris.devmobapp

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ua.edu.cdu.boris.devmobapp.dao.BookDao
import ua.edu.cdu.boris.devmobapp.dao.TelephoneDao
import ua.edu.cdu.boris.devmobapp.model.Book
import ua.edu.cdu.boris.devmobapp.model.Telephone

@Database(
    entities = [Book::class, Telephone::class],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun telephoneDao(): TelephoneDao

    companion object{
        fun getDb(applicationContext: Context): AppDb {
            return Room.databaseBuilder(
                applicationContext,
                AppDb::class.java, "app-db"
            ).build()
        }
    }
}
