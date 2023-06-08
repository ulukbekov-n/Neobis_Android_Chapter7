package com.example.register.fragments

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.register.R
import com.example.register.databinding.RegisterFragmentBinding

class RegisterFragment:Fragment(), View.OnClickListener,View.OnFocusChangeListener,View.OnKeyListener {
    private lateinit var binding: RegisterFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegisterFragmentBinding.inflate(inflater, container, false)
        binding.infoName.onFocusChangeListener = this
        binding.infoSurname.onFocusChangeListener = this
        binding.infoBirthday.onFocusChangeListener = this
        binding.infoNumber.onFocusChangeListener = this
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerBack.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_emailRegisterFragment)
        }

    }
    private fun validateName():Boolean{
        var errorMessage:String?= null
        val value = binding.infoName.text.toString()
        if(value.isEmpty()){
            errorMessage ="Name is required"
        }


        if (errorMessage!=null){
            binding.inputName.apply {
                isErrorEnabled = true
                error = errorMessage }
            }
        return errorMessage == null
    }

    private fun validateSurName():Boolean{
        var errorMessage:String?= null
        val value = binding.infoSurname.text.toString()
        if(value.isEmpty()){
            errorMessage ="Name is required"
        }


        if (errorMessage!=null){
            binding.inputSurname.apply {
                isErrorEnabled = true
                error = errorMessage }
        }
        return errorMessage == null
    }

    private fun validateBirthday():Boolean{
        var errorMessage:String?= null
        val value = binding.infoBirthday.text.toString()
        if(value.isEmpty()){
            errorMessage ="Name is required"
        }


        if (errorMessage!=null){
            binding.inputBirthday.apply {
                isErrorEnabled = true
                error = errorMessage }
        }
        return errorMessage == null
    }
    private fun validateNumber():Boolean{
        var errorMessage:String?= null
        val value = binding.infoNumber.text.toString()
        if(value.isEmpty()){
            errorMessage ="Name is required"
        }


        if (errorMessage!=null){
            binding.inputNumber.apply {
                isErrorEnabled = true
                error = errorMessage }
        }
        return errorMessage == null
    }
    override fun onClick(view: View?) {

    }


    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view !=null){
            when(view.id){
                R.id.infoName->{
                    if(hasFocus){
                        if(binding.inputName.isCounterEnabled){
                            binding.inputName.isErrorEnabled = false
                        }
                    }else{
                        validateName()
                    }
                }
                R.id.infoSurname->{
                    if(hasFocus){
                        if(binding.inputSurname.isCounterEnabled){
                            binding.inputSurname.isErrorEnabled = false
                        }
                    }else{
                        validateSurName()
                    }
                }
                R.id.infoBirthday->{
                    if(hasFocus){
                        if(binding.inputBirthday.isCounterEnabled){
                            binding.inputBirthday.isErrorEnabled = false
                        }
                    }else{
                        validateBirthday()
                    }
                }
                R.id.infoNumber->{
                    if(hasFocus){
                        if(binding.inputNumber.isCounterEnabled){
                            binding.inputNumber.isErrorEnabled = false
                        }
                    }else{
                        validateNumber()
                    }
                }
            }
        }
    }

    override fun onKey(view: View?, event: Int, keyEvent: KeyEvent?): Boolean {
        return false
    }
}