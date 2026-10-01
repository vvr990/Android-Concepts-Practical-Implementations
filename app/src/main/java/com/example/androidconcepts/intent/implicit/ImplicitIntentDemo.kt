package com.example.androidconcepts.intent.implicit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class ImplicitIntentDemo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("Implicit Intent Demo")

                Button(
                    onClick = {

                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.google.com")
                        )

                        startActivity(intent)
                    }
                ) {
                    Text("Open Google")
                }
            }
        }
    }
}