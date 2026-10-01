package com.example.androidconcepts.service.foreground

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.androidconcepts.R

import android.provider.Settings

class ForegroundService : Service() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int
    ): Int {

        val channelId = "MusicChannel"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                channelId,
                "Music Service",
                NotificationManager.IMPORTANCE_LOW
            )

            val manager =
                getSystemService(
                    NotificationManager::class.java
                )

            manager.createNotificationChannel(channel)
        }

        val notification =
            NotificationCompat.Builder(this, channelId)
                .setContentTitle("Music Player")
                .setContentText("Playing music...")
                .setSmallIcon(android.R.drawable.ic_media_play)
                .build()

        startForeground(1, notification)

        mediaPlayer = MediaPlayer.create(
            this,
            Settings.System.DEFAULT_RINGTONE_URI
        )

        mediaPlayer.isLooping = true

        mediaPlayer.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()

        if (::mediaPlayer.isInitialized) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}