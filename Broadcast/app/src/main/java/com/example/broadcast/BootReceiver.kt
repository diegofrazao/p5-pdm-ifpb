package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "CELULAR ACABOU DE LIGAR", Toast.LENGTH_SHORT).show()
        val intentNova = Intent(context, MainActivity::class.java)
        intentNova.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intentNova)
    }
}