package com.jscompany.tp16todolistapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jscompany.tp16todolistapp.R
import com.jscompany.tp16todolistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //탭이름
    var titles: MutableList<String> = mutableListOf("진행중", "완료")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //데이터 바인딩
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //1. 아답터 부르기
        val tabAdapter = TabAdapter(this)

        //2. 프래그먼트 화면 추가
        tabAdapter.addFragment(ProceedingFragment())
        tabAdapter.addFragment(EndFragment())

        //3. 뷰 페이저에 아답터 연결
        binding.viewPager.adapter = tabAdapter

    }
}