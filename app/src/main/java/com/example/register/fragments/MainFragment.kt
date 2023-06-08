package com.example.register.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.register.databinding.MainFragmentBinding

class MainFragment:Fragment() {
    private lateinit var binding:MainFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=MainFragmentBinding.inflate(layoutInflater)

        binding.startRegister.setOnClickListener{
            startActivity(Intent(this,EmailRegisterFragment::class.java))
        }
    }
}