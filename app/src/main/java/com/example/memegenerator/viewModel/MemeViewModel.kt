package com.example.memegenerator.viewModel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.memegenerator.repository.MainRepository
import com.example.memegenerator.room.MemeEntity
import kotlinx.coroutines.*

class MemeViewModel
@ViewModelInject
constructor(private val repository: MainRepository
,@Assisted private val savedStateHandle:SavedStateHandle): ViewModel()
{
    private val _data:MutableLiveData<List<MemeEntity>> =MutableLiveData()
    val data:LiveData<List<MemeEntity>>
    get()=_data

    fun updateLiveData(){
        GlobalScope.launch {
            _data.postValue(repository.getMeme())
        }
    }
    fun getData():Deferred<List<MemeEntity>>{
        return GlobalScope.async {
            repository.getMeme()
        }
    }
    fun deleteData(){

    }
}