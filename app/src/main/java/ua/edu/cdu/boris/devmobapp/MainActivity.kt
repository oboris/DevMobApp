package ua.edu.cdu.boris.devmobapp

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ua.edu.cdu.boris.devmobapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private val simpleViewModel by viewModels<SimpleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        simpleViewModel.str.observe(this) {
            binding.tv1.text = it.toString()
        }

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = ItemsAdapter(this)

//        (binding.rv.adapter as ItemsAdapter).updateItemList(simpleViewModel.items.value!!)

        binding.btn1.setOnClickListener(this)
        binding.btnClear.setOnClickListener {simpleViewModel.clearDB()}
        binding.btnAdd.setOnClickListener(this)
        binding.btnSync.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn1 -> simpleViewModel.modifier()
            R.id.btnAdd -> simpleViewModel.addAllItems()
            R.id.btnSync -> simpleViewModel.loadItems()
        }
    }
}