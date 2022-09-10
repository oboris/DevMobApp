package ua.edu.cdu.boris.devmobapp.holder

import ua.edu.cdu.boris.devmobapp.databinding.PhoneItemBinding
import ua.edu.cdu.boris.devmobapp.model.AdapterInterface
import ua.edu.cdu.boris.devmobapp.model.Telephone

class PhoneItemViewHolder(private val viewBinding: PhoneItemBinding) : ItemHolder(viewBinding),
    BindHolderInterface {

    override fun bind(item: AdapterInterface) {
        val phone = item as Telephone
        viewBinding.tvName.text = phone.name
        viewBinding.tvSize.text = phone.screenSize.toString()
    }
}