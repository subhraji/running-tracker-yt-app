package com.example.runningappyt.todo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetTodosViewModel @Inject constructor(private val repository: GetTodosRepository) : ViewModel() {

    val todosLiveData : LiveData<Outcome<GetTodosResponse>>
    get() = repository.todos

    init {
        viewModelScope.launch {
            repository.getTodos()
        }
    }

}
