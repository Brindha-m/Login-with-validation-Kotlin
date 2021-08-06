package com.vst.tractorvst

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*



class RegistrationActivity : AppCompatActivity() {
    private var logo: ImageView? = null
    private var joinus: ImageView? = null
    private var username: AutoCompleteTextView? = null
    private var email: AutoCompleteTextView? = null
    private var password: AutoCompleteTextView? = null
    private var signup: Button? = null
    private var signin: TextView? = null
    private var progressDialog: ProgressDialog? = null
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    private val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        initializeGUI()
        signup!!.setOnClickListener {
            val inputName = username!!.text.toString().trim { it <= ' ' }
            val inputPw = password!!.text.toString().trim { it <= ' ' }
            val inputEmail = email!!.text.toString().trim { it <= ' ' }
            if (validateInput(inputName, inputPw, inputEmail)) registerUser(
                inputName,
                inputPw,
                inputEmail
            )
        }
        signin!!.setOnClickListener {
            startActivity(
                Intent(
                    this@RegistrationActivity,
                    MainActivity::class.java
                )
            )
        }
    }

    private fun initializeGUI() {
        logo = findViewById(R.id.ivRegLogo)
        username = findViewById(R.id.atvUsernameReg)
        email = findViewById(R.id.atvEmailReg)
        password = findViewById(R.id.atvPasswordReg)
        signin = findViewById(R.id.tvSignIn)
        signup = findViewById(R.id.btnSignUp)
        progressDialog = ProgressDialog(this)

    }

    private fun registerUser(inputName: String, inputPw: String, inputEmail: String) {
        startActivity(
            Intent(
                this@RegistrationActivity,
                MainActivity::class.java
            )
        )


    }



    private fun validateInput(inName: String, inPw: String, inEmail: String): Boolean {
        if (inName.isEmpty()) {
            username!!.error = "Username is empty."
            return false
        }
        if (inPw.isEmpty()) {
            password!!.error = "Password is empty."
            return false
        }
        if (inEmail.isEmpty()) {
            email!!.error = "Email is empty."
            return false
        }
        if (inPw< 6.toString()) {
            password!!.error = "Password is not Valid"

        }

        if (inEmail.matches(emailPattern.toRegex())) {
            email!!.error = "Valid email address"

        } else {
            email!!.error ="Invalid email address"
        }

        if (inPw.matches(passwordPattern.toRegex())) {
            return true
        } else {
            password!!.error ="Invalid password"
        }

        return true
    }
}