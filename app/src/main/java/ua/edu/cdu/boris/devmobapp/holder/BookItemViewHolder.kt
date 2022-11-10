package ua.edu.cdu.boris.devmobapp.holder

import ua.edu.cdu.boris.devmobapp.SimpleViewModel
import ua.edu.cdu.boris.devmobapp.databinding.BookItemBinding
import ua.edu.cdu.boris.devmobapp.model.AdapterInterface
import ua.edu.cdu.boris.devmobapp.model.Book

class BookItemViewHolder(private val viewBinding: BookItemBinding) : ItemHolder(viewBinding) {

    override fun bind(item: AdapterInterface, simpleViewModel: SimpleViewModel) {
        val book = item as Book
        viewBinding.tvTitle.text = book.title
        viewBinding.tvAuthor.text = book.author
        viewBinding.tvPages.text = book.pageNumber.toString()

        viewBinding.itemButtons.btnDelete.setOnClickListener{simpleViewModel.deleteItem(book)}

        viewBinding.itemButtons.btnUpdate.setOnClickListener{
            val newBook = Book(title = book.title + "new", pageNumber = book.pageNumber, author = book.author, bookId = book.bookId)
            simpleViewModel.updateItem(newBook)
        }
    }
}