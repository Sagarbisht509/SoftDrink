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

class BrandFragment : Fragment() {

    private var binding : FragmentBrandBinding?= null
    private val sharedViewModel : SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentBrandBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
        }

        binding?.nextScreen?.setOnClickListener {
            if(sharedViewModel.isBrandSelected()) {
                sharedViewModel.setBrand("Coke")
            }
            findNavController().navigate(R.id.action_brandFragment_to_pickupFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}