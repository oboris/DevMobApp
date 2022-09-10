package ua.edu.cdu.boris.devmobapp

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ua.edu.cdu.boris.devmobapp.model.AdapterInterface
import ua.edu.cdu.boris.devmobapp.model.Book
import ua.edu.cdu.boris.devmobapp.model.Telephone

class SimpleViewModel : ViewModel() {
    private var _str = MutableLiveData("")

    val str: LiveData<String> = _str

    private var _items = MutableLiveData<ArrayList<AdapterInterface>?>(ArrayList())

    val items: LiveData<ArrayList<AdapterInterface>?> = _items

    init {
        _items.value?.add(Book("Book1", "Author1", 100))
        _items.value?.add(Book("Book2", "Author2", 150))
        _items.value?.add(Telephone("Phone2", 2050))
        _items.value?.add(Book("Book3", "Author3", 250))
        _items.value?.add(Telephone("Phone5", 1500))
    }

    fun modifier() {
         _str.value += "eee"

        _items.value?.add(Book("Book5", "Author5", 350))

//        books.value?.addAll(_books.value!!)
    }
}