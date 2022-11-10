package ua.edu.cdu.boris.devmobapp.holder

import ua.edu.cdu.boris.devmobapp.SimpleViewModel
import ua.edu.cdu.boris.devmobapp.model.AdapterInterface

interface BindHolderInterface {
    fun bind(item: AdapterInterface, simpleViewModel: SimpleViewModel)
}