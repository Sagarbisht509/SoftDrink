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
import com.example.colddrink.databinding.FragmentSummaryBinding

class BrandFragment : Fragment() {

    private var _binding : FragmentBrandBinding?= null
    //private val binding get() = _binding!!

    private val sharedViewModel : SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      //  _binding = FragmentBrandBinding.inflate(inflater, container, false)
       // return binding.root

        val b = FragmentBrandBinding.inflate(inflater, container, false)
        _binding = b

        return b.root

    }

  /*  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextScreen.setOnClickListener {
            findNavController().navigate(R.id.action_brandFragment_to_pickupFragment)
        }
    }
*/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}