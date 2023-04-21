package com.example.colddrink.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.colddrink.R
import com.example.colddrink.SharedViewModel
import com.example.colddrink.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn200ml.setOnClickListener {
            sharedViewModel.updatePrice(20)
            setQuantityAndNavigate("200")
        }

        binding.btn500ml.setOnClickListener {
            sharedViewModel.updatePrice(40)
            setQuantityAndNavigate("500")
        }

        binding.btn1l.setOnClickListener {
            sharedViewModel.updatePrice(60)
            setQuantityAndNavigate("1000")
        }
    }

    private fun setQuantityAndNavigate(selectedQuantity: String) {
        sharedViewModel.setQuantity(selectedQuantity)
        findNavController().navigate(R.id.action_firstFragment_to_brandFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}