package ua.edu.cdu.boris.devmobapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
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
            Log.i("ttt", "22222222")
        }

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = BooksAdapter(this)
        (binding.rv.adapter as BooksAdapter).updateUserList(simpleViewModel.items.value!!)

        binding.btn1.setOnClickListener(this)

        /*
        val recyclerView: RecyclerView = binding.userList
        val adapter = UserAdapter(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        viewModel.users.observe(this) {
            it?.let {
                adapter.submitList(it)
            }
        }
         */

//        simpleViewModel.books.observe(this, Observer {
//            (binding.rv.adapter as BooksAdapter).updateUserList(simpleViewModel.books.value!!)
//            Log.i("ttt", "1111111")
//        })

       // (binding.rv.adapter as BooksAdapter).updateUserList(simpleViewModel.books.value!!)

        //simpleViewModel = ViewModelProvider(this)[SimpleViewModel::class.java]
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString("str1", binding.tv1.text.toString())
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        binding.tv1.text = savedInstanceState.getString("str1","111").toString()
//    }

//    override fun onResume() {
//        super.onResume()
//        binding.tv1.text = simpleViewModel.str
//    }

    override fun onClick(v: View?) {
        simpleViewModel.modifier()
        (binding.rv.adapter as BooksAdapter).updateUserList(simpleViewModel.items.value!!)
//        binding.tv1.text = simpleViewModel.str
    }
}