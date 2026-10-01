package com.example.androidconcepts.intent.explicit

import android.content.Intent
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

class ExplicitIntentDemo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("Explicit Intent Demo")

                Button(
                    onClick = {
                        startActivity(
                            Intent(
                                this@ExplicitIntentDemo,
                                SecondActivity::class.java
                            )
                        )
                    }
                ) {
                    Text("Open Second Activity")
                }
            }
        }
    }
}