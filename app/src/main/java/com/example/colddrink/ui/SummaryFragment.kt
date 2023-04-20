package com.example.colddrink.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.colddrink.R
import com.example.colddrink.databinding.FragmentFirstBinding
import com.example.colddrink.databinding.FragmentSummaryBinding

class SummaryFragment : Fragment() {

    private var _binding : FragmentSummaryBinding?= null
   // private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       // _binding = FragmentSummaryBinding.inflate(inflater, container, false)
       // return binding.root
        val b = FragmentSummaryBinding.inflate(inflater, container, false)
        _binding = b

        return b.root
    }

   /* override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}