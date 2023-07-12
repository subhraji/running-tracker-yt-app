package com.example.runningappyt.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.runningappyt.repositories.MainRepository
import javax.inject.Inject

class StatisticsViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {

}