package com.gilangarinata.aloapps.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gilangarinata.aloapps.databinding.ActivityLoginBinding
import com.gilangarinata.aloapps.local.PreferenceManager
import com.gilangarinata.aloapps.tools.Utils

/**
 * Created by Gilang Arinata on 20/03/21.
 * https://github.com/gilangarinata/
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    private fun validateUserHaveLoginInfo(){
        val userInfo = PreferenceManager(this).getUserInfo()
        userInfo?.let {
            val isLoggedIn = it.username.isNotEmpty()
            if(isLoggedIn) {
                openMainActivity()
            }
        }
    }

    private fun openMainActivity(){
        startActivity(Intent(this, MainActivity::class.java))
        this.finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        validateUserHaveLoginInfo()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView(){
        binding.btnLogin.setOnClickListener { onBtnLoginClicked() }
    }

    private fun onBtnLoginClicked(){
        val usernameValue = binding.etUsername.text.trim().toString()
        val passwordValue = binding.etPassword.text.trim().toString()
        if(Utils().isValidUsername(usernameValue)){
            if(Utils().isValidPassword(passwordValue)){
                PreferenceManager(this).saveUserInfo(usernameValue)
                openMainActivity()
            }else{
                binding.etPassword.error = "Password tidak boleh kosong."
            }
        }else{
            binding.etUsername.error = "Username tidak boleh kosong."
        }
    }
}