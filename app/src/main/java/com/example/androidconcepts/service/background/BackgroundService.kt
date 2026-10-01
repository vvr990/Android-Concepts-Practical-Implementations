package com.example.androidconcepts.service.background

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class BackgroundService : Service() {

    private var isRunning = true

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int
    ): Int {

        Thread {
            var count = 1

            while (isRunning) {

                Log.d(
                    "BACKGROUND_SERVICE",
                    "Syncing data... $count"
                )

                count++

                Thread.sleep(5000)
            }
        }.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}