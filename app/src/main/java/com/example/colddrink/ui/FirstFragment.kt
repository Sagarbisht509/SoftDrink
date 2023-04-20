package com.example.colddrink.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.colddrink.R
import com.example.colddrink.SharedViewModel
import com.example.colddrink.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding : FragmentFirstBinding?= null
    private val binding get() = _binding!!

    private val sharedViewModel : SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.root
/*
        val b = FragmentFirstBinding.inflate(inflater, container, false)
        _binding = b

        return b.root */
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btn200ml.setOnClickListener {
                Toast.makeText(activity, "200", Toast.LENGTH_SHORT).show()
                setQuantityAndNavigate("200")
            }
        }

        binding.btn500ml.setOnClickListener {
            Toast.makeText(activity, "500", Toast.LENGTH_SHORT).show()
            setQuantityAndNavigate("500")
        }

        binding.btn1l.setOnClickListener {
            Toast.makeText(activity, "1000", Toast.LENGTH_SHORT).show()
            setQuantityAndNavigate("1000")
        }
    }

    private fun setQuantityAndNavigate(selectedQuantity : String) {
        sharedViewModel.setQuantity(selectedQuantity)
        findNavController().navigate(R.id.action_firstFragment_to_brandFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null;
    }
}