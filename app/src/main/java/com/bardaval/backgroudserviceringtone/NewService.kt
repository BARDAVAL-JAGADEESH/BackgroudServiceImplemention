package com.bardaval.backgroudserviceringtone

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class NewService : Service() {

    // MediaPlayer object for playing the ringtone
    private lateinit var player: MediaPlayer

    // Start the service and play ringtone
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        // Initialize MediaPlayer with the default ringtone
        if (!this::player.isInitialized || !player.isPlaying) {
            player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
            player.isLooping = true // Set it to loop the ringtone
            player.start() // Start playing the ringtone
        }
        return START_STICKY
    }

    // Stop the service and release the MediaPlayer
    override fun onDestroy() {
        if (this::player.isInitialized && player.isPlaying) {
            player.stop() // Stop the ringtone
            player.release() // Release the resources
        }
        super.onDestroy()
    }

    // No binding for this service, return null
    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}
