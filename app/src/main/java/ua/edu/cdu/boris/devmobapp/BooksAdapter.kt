package ua.edu.cdu.boris.devmobapp

import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import ua.edu.cdu.boris.devmobapp.databinding.BookItemBinding
import ua.edu.cdu.boris.devmobapp.databinding.PhoneItemBinding
import ua.edu.cdu.boris.devmobapp.model.AdapterInterface
import ua.edu.cdu.boris.devmobapp.model.Book
import ua.edu.cdu.boris.devmobapp.model.Telephone

class BooksAdapter(
    context: Context,
//    private val books : LiveData<ArrayList<Book>>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<AdapterInterface> = ArrayList()

    private var simpleViewModel: SimpleViewModel

    init {
        simpleViewModel =
            ViewModelProvider(context as ViewModelStoreOwner)[SimpleViewModel::class.java]

//        simpleViewModel.books.observe(context as LifecycleOwner, Observer {
//            updateUserList(it!!)
//            Log.i("ttt", "33333")
//        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType){
            AdapterInterface.bookType -> {
                val viewBinding =
                    BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return BookItemViewHolder(viewBinding)
            }
            AdapterInterface.phoneType -> {
                val viewBinding =
                    PhoneItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return PhoneItemViewHolder(viewBinding)
            }
        }
        val viewBinding =
            BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookItemViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (items[position].getType()){
            AdapterInterface.bookType -> (holder as BookItemViewHolder).bind(items[position] as Book)
            AdapterInterface.phoneType -> (holder as PhoneItemViewHolder).bind(items[position] as Telephone)
        }

//        (holder as BookItemViewHolder).tvTitle.text = books[position].title
//        (holder as BookItemViewHolder).tvAuthor.text = books[position].author
//        (holder as BookItemViewHolder).tvPages.text = books[position].pageNumber.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].getType()
    }

    fun updateUserList(books: ArrayList<AdapterInterface>) {
        this.items.clear()
        this.items.addAll(books)
        notifyDataSetChanged()
    }

    class BookItemViewHolder(private val viewBinding: BookItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
//        private val tvTitle : TextView = view.findViewById(R.id.tvTitle)
//        private val tvAuthor : TextView = view.findViewById(R.id.tvAuthor)
//        private val tvPages : TextView = view.findViewById(R.id.tvPages)

        fun bind(book: Book) {
            viewBinding.tvTitle.text = book.title
            viewBinding.tvAuthor.text = book.author
            viewBinding.tvPages.text = book.pageNumber.toString()
        }
    }

    class PhoneItemViewHolder(private val viewBinding: PhoneItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(phone: Telephone) {
            viewBinding.tvName.text = phone.name
            viewBinding.tvSize.text = phone.screenSize.toString()
        }
    }
}
