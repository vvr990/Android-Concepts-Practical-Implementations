package com.example.androidconcepts.service.background

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class BackgroundServiceDemo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Button(
                    onClick = {
                        startService(
                            Intent(
                                this@BackgroundServiceDemo,
                                BackgroundService::class.java
                            )
                        )
                    }
                ) {
                    Text("Start Background Service")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        stopService(
                            Intent(
                                this@BackgroundServiceDemo,
                                BackgroundService::class.java
                            )
                        )
                    }
                ) {
                    Text("Stop Background Service")
                }
            }
        }
    }
}