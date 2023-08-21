package com.example.multiapirxmvvmapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.multiapirxmvvmapp.R
import com.example.multiapirxmvvmapp.data.network.RetrofitService
import com.example.multiapirxmvvmapp.data.repository.MainRepository
import com.example.multiapirxmvvmapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    val mainListAdapter= UserListAdapter()
    private val retrofitService= RetrofitService.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService)))
            .get(MainViewModel::class.java)

        binding.recyclerViewUsers.adapter = mainListAdapter
        binding.buttonShowUsers.setOnClickListener {
            mainViewModel.getAllUsersList()
            binding.recyclerViewUsers.visibility = View.VISIBLE
            binding.buttonShowUsers.visibility = View.GONE
        }

        mainViewModel.responseAllUsers.observe(this, Observer {
            if (it!=null)
                mainListAdapter.setData(it.allUSersList)
            else
                Toast.makeText(this, "Error fetching Data", Toast.LENGTH_SHORT).show()
        })

        mainViewModel.errorMessage.observe(this, Observer {
            if(it!=null)
                Toast.makeText(this, "Error:"+ it , Toast.LENGTH_SHORT).show()
        })
    }

    override fun onDestroy() {
        mainViewModel.disposable.dispose()
        super.onDestroy()
    }
}