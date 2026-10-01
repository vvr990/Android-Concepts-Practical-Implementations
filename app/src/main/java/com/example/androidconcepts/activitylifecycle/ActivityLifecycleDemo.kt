package com.example.androidconcepts.activitylifecycle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ActivityLifecycleDemo : ComponentActivity() {

    companion object {
        var currentState by mutableStateOf("Not Started")
        var lifecycleHistory by mutableStateOf("")
    }

    private fun updateLifecycle(method: String) {
        currentState = method
        lifecycleHistory += "✓ $method\n"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        updateLifecycle("onCreate()")

        setContent {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Activity Lifecycle Demo"
                )

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = "Current State"
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = currentState
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = "Lifecycle History"
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = lifecycleHistory
                        )
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        updateLifecycle("onStart()")
    }

    override fun onResume() {
        super.onResume()
        updateLifecycle("onResume()")
    }

    override fun onPause() {
        super.onPause()
        updateLifecycle("onPause()")
    }

    override fun onStop() {
        super.onStop()
        updateLifecycle("onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        updateLifecycle("onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        updateLifecycle("onDestroy()")
    }
}