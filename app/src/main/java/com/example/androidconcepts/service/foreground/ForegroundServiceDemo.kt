package com.example.androidconcepts.service.foreground

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat

class ForegroundServiceDemo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val context = LocalContext.current

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {

                    Text("Music Player Service")

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    Button(
                        onClick = {

                            ContextCompat
                                .startForegroundService(
                                    context,
                                    Intent(
                                        context,
                                        ForegroundService::class.java
                                    )
                                )
                        }
                    ) {
                        Text("Play Music")
                    }

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    Button(
                        onClick = {

                            context.stopService(
                                Intent(
                                    context,
                                    ForegroundService::class.java
                                )
                            )
                        }
                    ) {
                        Text("Stop Music")
                    }
                }
            }
        }
    }
}