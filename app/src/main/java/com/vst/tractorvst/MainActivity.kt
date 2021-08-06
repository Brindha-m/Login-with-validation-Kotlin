package com.vst.tractorvst

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private var btnLogout: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogout = findViewById(R.id.btnLogout)
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }
    }
