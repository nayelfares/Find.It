package com.emarketing.findit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emarketing.findit.ui.Register
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        register.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
    }
}