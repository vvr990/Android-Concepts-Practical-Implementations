package com.example.androidconcepts.service.bound

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder

class BoundService : Service() {

    private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
        fun getService(): BoundService = this@BoundService
    }

    fun getDeviceInfo(): String {

        return """
            Manufacturer: ${Build.MANUFACTURER}
            Model: ${Build.MODEL}
            Android Version: ${Build.VERSION.RELEASE}
        """.trimIndent()
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }
}