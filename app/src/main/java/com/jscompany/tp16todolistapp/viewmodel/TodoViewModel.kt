package com.jscompany.tp16todolistapp.viewmodel

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jscompany.tp16todolistapp.G
import com.jscompany.tp16todolistapp.model.DBHelper
import com.jscompany.tp16todolistapp.model.TodoVO
import com.jscompany.tp16todolistapp.view.MainActivity
import com.jscompany.tp16todolistapp.view.WriteActivity

class TodoViewModel constructor(val context: Context) {
    var status : MutableLiveData<Int> = MutableLiveData(G.NOT_COMPLATE) //상태 : 비완료 = 0 ,완료 = 1
    var title : MutableLiveData<String> = MutableLiveData("")
    var content : MutableLiveData<String> = MutableLiveData("")

    val items : MutableLiveData<MutableList<TodoVO>> = MutableLiveData(mutableListOf()) //초기화

    val dbHelper = DBHelper(context)

    fun onTextChange(s : CharSequence?, start:Int, end:Int, count:Int) { //텍스트 왓쳐를 대신하는 넘
        title.value = s.toString() // dataBing에선 value!!!!
    }

    fun onTextChange2(s : CharSequence?, start:Int, end:Int, count:Int) { //텍스트 왓쳐를 대신하는 넘
        content.value = s.toString()
    }

    //제목 & 내용 sqLite에 저장
    fun setData() {
        if(title.value!!.isEmpty() || content.value!!.isEmpty()) {
            Toast.makeText(context, "내용을 채워주세요", Toast.LENGTH_SHORT).show()
            return
        }

        //1. list에 저장 - items에 add따위는 없으니까 list에 넣기
        val list = items.value
        list?.add(TodoVO(G.NOT_COMPLATE, title.value!!, content.value!!))

        items.postValue(list) // 별도 스레드에서 작업

        Log.d("TAG", "${G.NOT_COMPLATE} , ${title.value} , ${content.value}")

        //2. sqlite에 저장
        dbHelper.insertTodo(G.NOT_COMPLATE, title.value!!, content.value!!)
//        Toast.makeText(context, "등록 완료", Toast.LENGTH_SHORT).show()

        dbHelper.selectAll(0)

        moveMain()
    }

    //제목 & 내용 sqLite 업데이트
    fun updateData(isComplete : MutableLiveData<Boolean>) {

    }

    // 저장한 메모 상태 업데이트
    fun setStatus() {
        Toast.makeText(context, "클릭", Toast.LENGTH_SHORT).show()
    }

    fun moveMain() {
        context.startActivity(Intent(context, MainActivity::class.java))
    }

}



