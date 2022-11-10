package ua.edu.cdu.boris.devmobapp.holder

import ua.edu.cdu.boris.devmobapp.SimpleViewModel
import ua.edu.cdu.boris.devmobapp.databinding.PhoneItemBinding
import ua.edu.cdu.boris.devmobapp.model.AdapterInterface
import ua.edu.cdu.boris.devmobapp.model.Telephone

class PhoneItemViewHolder(private val viewBinding: PhoneItemBinding) : ItemHolder(viewBinding){

    override fun bind(item: AdapterInterface, simpleViewModel: SimpleViewModel) {
        val phone = item as Telephone
        viewBinding.tvName.text = phone.name
        viewBinding.tvSize.text = phone.screenSize.toString()

        viewBinding.itemButtons.btnDelete.setOnClickListener{simpleViewModel.deleteItem(phone)}

        viewBinding.itemButtons.btnUpdate.setOnClickListener{
            val newPhone = Telephone(name = phone.name + "new", screenSize = phone.screenSize, phoneId = phone.phoneId)
            simpleViewModel.updateItem(newPhone)}
    }
}