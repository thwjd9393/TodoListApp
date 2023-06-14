package com.jscompany.tp16todolistapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jscompany.tp16todolistapp.R
import com.jscompany.tp16todolistapp.databinding.ActivityWriteBinding
import com.jscompany.tp16todolistapp.model.DBHelper
import com.jscompany.tp16todolistapp.viewmodel.TodoViewModel

class WriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //화면 연동
        val binding : ActivityWriteBinding = DataBindingUtil.setContentView(this,R.layout.activity_write)

        //뷰 모델 연동
        binding.vm = TodoViewModel(this)

        // 라이브데이터 변화 반영 설정
        binding.lifecycleOwner = this


    }
}