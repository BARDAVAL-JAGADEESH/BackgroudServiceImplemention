package com.bardaval.backgroudserviceringtone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    // Buttons for starting and stopping the service
    private lateinit var startButton: Button
    private lateinit var stopButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Assigning the buttons from the layout
        startButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)

        // Start service button click listener
        startButton.setOnClickListener {
            // Start the ringtone service
            startService(Intent(this, NewService::class.java))
        }

        // Stop service button click listener
        stopButton.setOnClickListener {
            // Stop the ringtone service
            stopService(Intent(this, NewService::class.java))
        }
    }
}
