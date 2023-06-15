package com.example.register.fragments

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.register.R
import com.example.register.databinding.EmailRegisterFragmentBinding

class EmailRegisterFragment: Fragment(),View.OnClickListener,View.OnFocusChangeListener,View.OnKeyListener {
    private lateinit var binding: EmailRegisterFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EmailRegisterFragmentBinding.inflate(inflater, container, false)
        binding.infoEmail.onFocusChangeListener = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBack.setOnClickListener{
            findNavController().navigate(R.id.action_emailRegisterFragment_to_mainFragment)
        }
        binding.regEmail.setOnClickListener {
            if (validateEmail()) {
                findNavController().navigate(R.id.action_emailRegisterFragment_to_registerFragment)
            }
        }

    }

    private fun validateEmail():Boolean{
        var errorMessage:String?= null
        val usernameInput = binding.infoEmail.text.toString().trim()
        val value = binding.infoEmail.text.toString()
        if(value.isEmpty()){
            errorMessage ="Email is required"
        }else if(Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMessage = "Email address is invalid"
        }

        if (errorMessage!=null){
            binding.inputEmail.apply {
                isErrorEnabled = true
                error = errorMessage
            binding.regEmail.backgroundTintList =
                ColorStateList.valueOf(resources.getColor(R.color.purple_700))
                binding.regEmail.setBackgroundResource(R.drawable.enabled_button)
            }
            binding.regEmail.isEnabled = false
            binding.regEmail.backgroundTintList = ColorStateList.valueOf(resources.getColor(
                androidx.appcompat.R.color.material_grey_100))
        }else {
            binding.inputEmail.isErrorEnabled = false
            binding.regEmail.isEnabled = true
        }
        return errorMessage == null
    }
    override fun onClick(view: View?) {

    }


    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view !=null){
            when(view.id){
                R.id.infoEmail->{
                    if(hasFocus){
                        if(binding.inputEmail.isCounterEnabled){
                            binding.inputEmail.isErrorEnabled = false
                        }
                    }else{
                        validateEmail()
                    }
                }
            }
        }
    }

    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        return false
    }

}