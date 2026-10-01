package com.example.androidconcepts.service.bound

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class BoundServiceDemo : ComponentActivity() {

    private var boundService: BoundService? = null
    private var isBound = false

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(
            name: ComponentName?,
            service: IBinder?
        ) {

            val binder =
                service as BoundService.LocalBinder

            boundService = binder.getService()

            isBound = true
        }

        override fun onServiceDisconnected(
            name: ComponentName?
        ) {
            isBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindService(
            Intent(
                this,
                BoundService::class.java
            ),
            connection,
            Context.BIND_AUTO_CREATE
        )

        setContent {

            var deviceInfo by remember {
                mutableStateOf("No Data")
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {

                    Text("Bound Service Demo")

                    Spacer(
                        modifier =
                            Modifier.height(20.dp)
                    )

                    Button(
                        onClick = {

                            if (isBound) {

                                deviceInfo =
                                    boundService!!
                                        .getDeviceInfo()
                            }
                        }
                    ) {

                        Text("Get Device Info")
                    }

                    Spacer(
                        modifier =
                            Modifier.height(20.dp)
                    )

                    Text(deviceInfo)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (isBound) {
            unbindService(connection)
        }
    }
}