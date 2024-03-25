package com.purplestudio.findroomate

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.purplestudio.findroomate.databinding.ActivityMainBinding
import com.purplestudio.findroomate.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var user: User

    private lateinit var binding: ActivitySummaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrieveUser()
        displayUser()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.textViewEmailAddress.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${user.email}")
            startActivity(intent)
        }
        binding.textViewPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user.phone}")
            startActivity(intent)
        }
    }

    private fun retrieveUser() {
        user = intent.getSerializableExtra("User") as User
    }

    private fun displayUser() {
        binding.textViewUserFullName.text = user.getFullName()
        binding.textViewEmailAddress.text = user.email
        binding.textViewPhone.text = user.phone

    }
}