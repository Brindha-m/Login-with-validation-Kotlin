package com.vst.tractorvst

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import android.app.ProgressDialog as ProgressDialog1


class LoginActivity : AppCompatActivity() {
    private var logo: ImageView? = null
    private var ivSignIn: ImageView? = null
    private var email: AutoCompleteTextView? = null
    private var password: AutoCompleteTextView? = null
    private var signUp: TextView? = null
    private var btnSignIn: Button? = null
    private var progressDialog: ProgressDialog1? = null
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    private val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initializeGUI()

        //startActivity(Intent(this@LoginActivity, MainActivity::class.java))

        btnSignIn!!.setOnClickListener {
            val inEmail = email!!.text.toString()
            val inPassword = password!!.text.toString()
            validateInput(inEmail, inPassword)


        }
        signUp!!.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    RegistrationActivity::class.java
                )
            )
        }


    }

        private fun initializeGUI() {
            logo = findViewById(R.id.ivLogLogo);
            ivSignIn = findViewById(R.id.ivSignIn);
            email = findViewById(R.id.atvEmailLog);
            password = findViewById(R.id.atvPasswordLog);
            signUp = findViewById(R.id.tvSignIn);
            btnSignIn = findViewById(R.id.btnSignIn);

        }

    fun validateInput(inemail: String, inpassword: String): Boolean {
        if (inemail.isEmpty()) {
            email!!.error = "Email field is empty."
            return false
        }

        if (inemail.isEmpty() && inpassword.isEmpty()) {
            email!!.error = "Email field is empty."
            password!!.error = "Password is empty."

            return false
        }

        if (inpassword.isEmpty()) {
            password!!.error = "Password is empty."

            return false
        }
        if (inpassword< 6.toString()) {
            password!!.error = "Password is not Valid"

        }

        if (inemail.matches(emailPattern.toRegex())) {
            email!!.error = "Valid email address"

        } else {
            email!!.error ="Invalid email address"
        }

        if (inpassword.matches(passwordPattern.toRegex())) {
            return true

        } else {
            password!!.error ="Invalid password"
        }

        return true
    }

}









    
