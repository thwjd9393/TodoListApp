package com.jscompany.tp16todolistapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jscompany.tp16todolistapp.R
import com.jscompany.tp16todolistapp.databinding.FragmentEndBinding
import com.jscompany.tp16todolistapp.databinding.FragmentProceedingBinding

class EndFragment : Fragment() {

    lateinit var binding: FragmentEndBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<FragmentEndBinding>(inflater, R.layout.fragment_end, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}