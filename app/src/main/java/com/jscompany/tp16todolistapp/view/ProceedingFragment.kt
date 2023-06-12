package com.jscompany.tp16todolistapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jscompany.tp16todolistapp.R
import com.jscompany.tp16todolistapp.databinding.FragmentProceedingBinding

class ProceedingFragment : Fragment() {

    lateinit var binding: FragmentProceedingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_proceeding, container, false)
    }
}