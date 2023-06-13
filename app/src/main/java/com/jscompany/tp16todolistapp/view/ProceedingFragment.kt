package com.jscompany.tp16todolistapp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jscompany.tp16todolistapp.R
import com.jscompany.tp16todolistapp.databinding.FragmentProceedingBinding

class ProceedingFragment : Fragment() {

    lateinit var binding: FragmentProceedingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //프래그먼트에서 화면 붙이기
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_proceeding, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //쓰기 페이지로 이동 버튼
        binding.btnGoWrite.setOnClickListener {
            moveWrite()
        }

    }

    // 쓰기 페이지로 이동
    fun moveWrite() {
        requireContext().startActivity(Intent(requireContext(), WriteActivity::class.java))
    }
}