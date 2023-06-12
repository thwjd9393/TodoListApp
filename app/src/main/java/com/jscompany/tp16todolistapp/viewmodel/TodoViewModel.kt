package com.jscompany.tp16todolistapp.viewmodel

import androidx.lifecycle.MutableLiveData

class TodoViewModel {
    val isComplete : MutableLiveData<Boolean> = MutableLiveData(false) //완료버튼
    val title : MutableLiveData<String> = MutableLiveData("")
    val content : MutableLiveData<String> = MutableLiveData("")
}


