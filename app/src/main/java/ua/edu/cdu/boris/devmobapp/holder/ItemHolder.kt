package ua.edu.cdu.boris.devmobapp.holder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ItemHolder(viewBinding: ViewBinding) :
    RecyclerView.ViewHolder(viewBinding.root), BindHolderInterface