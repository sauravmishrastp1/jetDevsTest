package com.imaginato.homeworkmvvm.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.imaginato.homeworkmvvm.data.local.demo.Demo
import com.imaginato.homeworkmvvm.data.local.demo.DemoDatabase
import com.imaginato.homeworkmvvm.databinding.ActivityLoginBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.inject

class LoginActivity : AppCompatActivity() {
    private val viewModel by viewModel<LoginActivityViewModel>()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cvLoginButton.setOnClickListener {
            viewModel.validateFeilds(binding.etUserName.text.toString(),binding.etPassword.text.toString())
        }
        initObserve()

    }

    private fun initObserve() {

        viewModel.loginResponseResult.observe(this){
            Toast.makeText(applicationContext,"${it.errorMessage}",Toast.LENGTH_SHORT).show()



        }

        viewModel.progress.observe(this) {
            binding.progressBar.isVisible = it
        }

        viewModel.errorMessage.observe(this){
            Toast.makeText(applicationContext,it,Toast.LENGTH_SHORT).show()

        }


    }
}