package ua.edu.cdu.boris.devmobapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import ua.edu.cdu.boris.devmobapp.databinding.BookItemBinding
import ua.edu.cdu.boris.devmobapp.databinding.PhoneItemBinding
import ua.edu.cdu.boris.devmobapp.holder.BookItemViewHolder
import ua.edu.cdu.boris.devmobapp.holder.ItemHolder
import ua.edu.cdu.boris.devmobapp.holder.PhoneItemViewHolder
import ua.edu.cdu.boris.devmobapp.model.AdapterInterface

class BooksAdapter(context: Context) : RecyclerView.Adapter<ItemHolder>() {

    private var items: ArrayList<AdapterInterface> = ArrayList()

    private var simpleViewModel: SimpleViewModel

    init {
        simpleViewModel =
            ViewModelProvider(context as ViewModelStoreOwner)[SimpleViewModel::class.java]

        simpleViewModel.items.observe(context as LifecycleOwner) {
            updateUserList(it)
        }
    }

    fun updateUserList(newItems: ArrayList<AdapterInterface>) {
//        items.clear()
//        items.addAll(newItems)
        items = newItems

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val viewBinding: ViewBinding
        return when (viewType) {
            AdapterInterface.BOOK_TYPE -> {
                viewBinding =
                    BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BookItemViewHolder(viewBinding)
            }
            AdapterInterface.PHONE_TYPE -> {
                viewBinding =
                    PhoneItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PhoneItemViewHolder(viewBinding)
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
//        when (items[position].getType()) {
//            AdapterInterface.BOOK_TYPE ->
//                (holder as BookItemViewHolder).bind(items[position] as Book)
//            AdapterInterface.PHONE_TYPE ->
//                (holder as PhoneItemViewHolder).bind(items[position] as Telephone)
//        }
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].getType()
    }
}
