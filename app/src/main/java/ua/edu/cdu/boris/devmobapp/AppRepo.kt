package ua.edu.cdu.boris.devmobapp

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ua.edu.cdu.boris.devmobapp.dao.BookDao
import ua.edu.cdu.boris.devmobapp.dao.TelephoneDao
import ua.edu.cdu.boris.devmobapp.model.AdapterInterface
import ua.edu.cdu.boris.devmobapp.model.Book
import ua.edu.cdu.boris.devmobapp.model.Telephone

@OptIn(DelicateCoroutinesApi::class)
class AppRepo(private val bookDao: BookDao, private val telephoneDao: TelephoneDao) {
    fun insertAll(items: List<AdapterInterface>) {
        GlobalScope.launch {
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

        }
    }

    fun getAll(): ArrayList<AdapterInterface> {
        val items: ArrayList<AdapterInterface> = ArrayList()
        GlobalScope.launch {
            items.addAll(bookDao.getAll())
        }
        GlobalScope.launch {
            items.addAll(telephoneDao.getAll())
        }
        return items
    }
}