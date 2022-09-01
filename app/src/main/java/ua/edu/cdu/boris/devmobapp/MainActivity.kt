package ua.edu.cdu.boris.devmobapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ua.edu.cdu.boris.devmobapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var simpleViewModel: SimpleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener(this)
        simpleViewModel = ViewModelProvider(this)[SimpleViewModel::class.java]
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

    override fun onResume() {
        super.onResume()
        binding.tv1.text = simpleViewModel.str
    }

    override fun onClick(v: View?) {
        simpleViewModel.modifier()
        binding.tv1.text = simpleViewModel.str
    }
}