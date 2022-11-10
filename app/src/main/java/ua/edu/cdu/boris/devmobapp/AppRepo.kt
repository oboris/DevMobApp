package ua.edu.cdu.boris.devmobapp

import ua.edu.cdu.boris.devmobapp.dao.BookDao
import ua.edu.cdu.boris.devmobapp.dao.TelephoneDao
import ua.edu.cdu.boris.devmobapp.model.AdapterInterface
import ua.edu.cdu.boris.devmobapp.model.Book
import ua.edu.cdu.boris.devmobapp.model.Telephone

class AppRepo(private val bookDao: BookDao, private val telephoneDao: TelephoneDao) {
    suspend fun insertAll(items: List<AdapterInterface>) {
        //GlobalScope.launch {
        items.forEach {
            when (it.getType()) {
                AdapterInterface.BOOK_TYPE -> {
                    bookDao.insert(it as Book)
                }
                AdapterInterface.PHONE_TYPE -> {
                    telephoneDao.insert(it as Telephone)
                }
            }
        }

//        }
    }

    suspend fun insertOne(item: AdapterInterface) {
//        GlobalScope.launch {
        when (item.getType()) {
            AdapterInterface.BOOK_TYPE -> {
                bookDao.insert(item as Book)
            }
            AdapterInterface.PHONE_TYPE -> {
                telephoneDao.insert(item as Telephone)
            }
        }
//        }
    }

    suspend fun deleteOne(item: AdapterInterface) {
//        GlobalScope.launch {
        when (item.getType()) {
            AdapterInterface.BOOK_TYPE -> {
                bookDao.delete(item as Book)
            }
            AdapterInterface.PHONE_TYPE -> {
                telephoneDao.delete(item as Telephone)
            }
        }
//        }
    }

    suspend fun deleteAllItems() {
//        GlobalScope.launch {
        bookDao.deleteAll()
        telephoneDao.deleteAll()
//        }
    }

    suspend fun updateOne(item: AdapterInterface) {
//        GlobalScope.launch {
            when (item.getType()) {
                AdapterInterface.BOOK_TYPE -> {
                    bookDao.update(item as Book)
                }
                AdapterInterface.PHONE_TYPE -> {
                    telephoneDao.update(item as Telephone)
                }
            }
//        }
    }

    suspend fun getAll(): ArrayList<AdapterInterface> {
        val items: ArrayList<AdapterInterface> = ArrayList()
//        GlobalScope.launch {
            items.addAll(bookDao.getAll())
            items.addAll(telephoneDao.getAll())
//        }
//    GlobalScope.launch {
//        items.addAll(telephoneDao.getAll())
//    }
        return items
    }
}