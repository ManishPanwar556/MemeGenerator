package com.example.memegenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.memegenerator.repository.MainRepository
import com.example.memegenerator.viewModel.MemeViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel:MemeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.updateLiveData()
        subscribeObserver()
//        viewModel.deleteData()

    }
    private fun subscribeObserver(){
        val rev=findViewById<RecyclerView>(R.id.rev)

        viewModel.data.observe(this, Observer {list->
            Toast.makeText(this,"$list",Toast.LENGTH_SHORT).show()
            rev.adapter=MyAdapter(this,list)
            rev.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        })
    }
}