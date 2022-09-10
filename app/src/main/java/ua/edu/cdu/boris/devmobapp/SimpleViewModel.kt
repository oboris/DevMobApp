package ua.edu.cdu.boris.devmobapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ua.edu.cdu.boris.devmobapp.model.AdapterInterface
import ua.edu.cdu.boris.devmobapp.model.Book
import ua.edu.cdu.boris.devmobapp.model.Telephone

class SimpleViewModel : ViewModel() {
    private var _str = MutableLiveData("")

    val str: LiveData<String> = _str

    private var _items = ArrayList<AdapterInterface>()

    val items: MutableLiveData<ArrayList<AdapterInterface>> = MutableLiveData()

    init {
        _items.add(Book("Book1", "Author1", 100))
        _items.add(Book("Book2", "Author2", 150))
        _items.add(Telephone("Phone2", 2050))
        _items.add(Book("Book3", "Author3", 250))
        _items.add(Telephone("Phone5", 1500))

        items.value = _items
    }

    fun modifier() {
         _str.value += "eee"

        _items.add(Book("Book5", "Author5", 350))
        _items.add(Telephone("Phone15", 3500))

        items.value = _items
    }
}