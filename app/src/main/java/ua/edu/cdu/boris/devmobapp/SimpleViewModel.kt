package ua.edu.cdu.boris.devmobapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ua.edu.cdu.boris.devmobapp.model.AdapterInterface
import ua.edu.cdu.boris.devmobapp.model.Book
import ua.edu.cdu.boris.devmobapp.model.Telephone

class SimpleViewModel(app: Application) : AndroidViewModel(app) {
    private var _str = MutableLiveData("")

    val str: LiveData<String> = _str

    private var _items = ArrayList<AdapterInterface>()

    val items: MutableLiveData<ArrayList<AdapterInterface>> = MutableLiveData()

    private val db = (app as App)

    init {
        getItems()
    }

    private fun getItems() {
        _items.clear()
        viewModelScope.launch {
            _items = db.repo.getAll()
            items.value = _items
        }

    }

    fun modifier() {
        _str.value += "eee"

        viewModelScope.launch {
            val book = Book("Book" + _items.size, "Author" + _items.size, 350)
            db.repo.insertOne(book)

            val phone = Telephone("Phone" + _items.size, 3500)
            db.repo.insertOne(phone)

            getItems()
        }
    }

    fun addAllItems() {
        val tmpItems = ArrayList<AdapterInterface>()
        tmpItems.add(Book("Book1", "Author1", 100))
        tmpItems.add(Book("Book2", "Author2", 150))
        tmpItems.add(Telephone("Phone2", 2050))
        tmpItems.add(Book("Book3", "Author3", 250))
        tmpItems.add(Telephone("Phone5", 1500))

        viewModelScope.launch {
            db.repo.insertAll(tmpItems)
            getItems()
        }
    }

    fun clearDB() {
        viewModelScope.launch {
            db.repo.deleteAllItems()
            getItems()
        }
    }

    fun deleteItem(item : AdapterInterface) {
        viewModelScope.launch {
            db.repo.deleteOne(item)
            getItems()
        }
    }

    fun updateItem(item : AdapterInterface) {
        viewModelScope.launch {
            db.repo.updateOne(item)
            getItems()
        }
    }
}