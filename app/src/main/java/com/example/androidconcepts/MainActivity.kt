package com.example.androidconcepts
import com.example.androidconcepts.service.foreground.ForegroundServiceDemo
import com.example.androidconcepts.activitylifecycle.ActivityLifecycleDemo
import com.example.androidconcepts.intent.explicit.ExplicitIntentDemo
import com.example.androidconcepts.intent.implicit.ImplicitIntentDemo
import com.example.androidconcepts.service.background.BackgroundServiceDemo
import com.example.androidconcepts.service.bound.BoundServiceDemo



import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Button(
                        onClick = {
                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    ActivityLifecycleDemo::class.java
                                )
                            )
                        }
                    ) {
                        Text("Activity Lifecycle")
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    ExplicitIntentDemo::class.java
                                )
                            )
                        }
                    ) {
                        Text("Explicit Intent")
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    ImplicitIntentDemo::class.java
                                )
                            )
                        }
                    ) {
                        Text("Implicit Intent")
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    ForegroundServiceDemo::class.java
                                )
                            )
                        }
                    ) {
                        Text("Foreground Service")
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    BackgroundServiceDemo::class.java
                                )
                            )
                        }
                    ) {
                        Text("Background Service")
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    BoundServiceDemo::class.java
                                )
                            )
                        }
                    ) {
                        Text("Bound Service")
                    }
                }
            }
        }
    }
}