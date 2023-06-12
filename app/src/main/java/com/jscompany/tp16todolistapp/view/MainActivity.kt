package com.jscompany.tp16todolistapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.jscompany.tp16todolistapp.R
import com.jscompany.tp16todolistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //탭이름
    var tabTitle: MutableList<String> = mutableListOf("진행중", "완료")

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

        //4. 프래그먼트 페이지 붙이기
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })

        //5. 탭 이름 연동
        TabLayoutMediator(binding.tabLayout,binding.viewPager) { tab, position ->
            tab.text = tabTitle.get(position).toString()
        }.attach()

    }
}