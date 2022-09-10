package ua.edu.cdu.boris.devmobapp.holder

import ua.edu.cdu.boris.devmobapp.databinding.BookItemBinding
import ua.edu.cdu.boris.devmobapp.model.AdapterInterface
import ua.edu.cdu.boris.devmobapp.model.Book

class BookItemViewHolder(private val viewBinding: BookItemBinding) : ItemHolder(viewBinding),
    BindHolderInterface {

    override fun bind(item: AdapterInterface) {
        val book = item as Book
        viewBinding.tvTitle.text = book.title
        viewBinding.tvAuthor.text = book.author
        viewBinding.tvPages.text = book.pageNumber.toString()
    }
}