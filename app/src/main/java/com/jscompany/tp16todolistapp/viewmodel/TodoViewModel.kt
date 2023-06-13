package com.jscompany.tp16todolistapp.viewmodel

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.jscompany.tp16todolistapp.G
import com.jscompany.tp16todolistapp.model.TodoVO
import com.jscompany.tp16todolistapp.view.WriteActivity

class TodoViewModel constructor(val context: Context) {
    val status : MutableLiveData<Int> = MutableLiveData(G.NOT_COMPLATE) //상태 : 비완료 = 0 ,완료 = 1
    val title : MutableLiveData<String> = MutableLiveData("")
    val content : MutableLiveData<String> = MutableLiveData("")

    val items : MutableLiveData<MutableList<TodoVO>> = MutableLiveData(mutableListOf()) //초기화

    //제목 & 내용 sqLite에 저장
    fun setData(title : String, content : String) {
        //1. list에 저장 - items에 add따위는 없으니까 list에 넣기
        val list = items.value
        list?.add(TodoVO(G.NOT_COMPLATE, title, content))

        items.postValue(list) // 별도 스레드에서 작업

        //2. sqlite에 저장

    }

    //제목 & 내용 sqLite 업데이트
    fun updateData(isComplete : MutableLiveData<Boolean>) {

    }

    // 저장한 메모 상태 업데이트
    fun setStatus() {
        Toast.makeText(context, "클릭", Toast.LENGTH_SHORT).show()
    }



}


