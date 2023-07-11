package com.example.runningappyt.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.runningappyt.R
import com.example.runningappyt.databinding.ActivityMainBinding
import com.example.runningappyt.db.RunDAO
import com.example.runningappyt.todo.GetTodosViewModel
import com.example.runningappyt.todo.Outcome
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: GetTodosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeApiCall()
    }

    private fun observeApiCall(){
        mainViewModel.todosLiveData.observe(this, Observer { outcome ->
            when(outcome){
                is Outcome.Success ->{
                    if(outcome.data.size > 0){
                        binding.titleTv.text = outcome.data[0].title.toString()
                    }else{
                        Toast.makeText(this,"size => "+outcome.data.size, Toast.LENGTH_SHORT).show()
                    }
                }

                is Outcome.Failure<*> -> {
                    Toast.makeText(this,outcome.e.message, Toast.LENGTH_SHORT).show()

                    outcome.e.printStackTrace()
                    Log.i("status",outcome.e.cause.toString())
                }

                else -> {}
            }
        })
    }
}