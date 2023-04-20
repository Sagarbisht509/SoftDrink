package com.example.colddrink.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.colddrink.R
import com.example.colddrink.SharedViewModel
import com.example.colddrink.databinding.FragmentBrandBinding
import com.example.colddrink.databinding.FragmentPickupBinding

class PickupFragment : Fragment() {

    private var _binding : FragmentPickupBinding?= null
   // private val binding get() = _binding!!

    private val sharedViewModel : SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      //  _binding = FragmentPickupBinding.inflate(inflater, container, false)
        //return binding.root

        val b = FragmentPickupBinding.inflate(inflater, container, false)
        _binding = b

        return b.root
    }
/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextScreen.setOnClickListener {
            findNavController().navigate(R.id.action_pickupFragment_to_summaryFragment)
        }
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}