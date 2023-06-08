package com.example.register.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.register.R
import com.example.register.databinding.MainFragmentBinding

class MainFragment:Fragment() {
    private lateinit var binding:MainFragmentBinding
    private lateinit var navController:NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startRegister.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_registerFragment)
        }
        binding.loginText.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_logInFragment)
        }

    }


}