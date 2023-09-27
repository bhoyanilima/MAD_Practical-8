package com.example.mad_practical_8

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun setAlarm(militime:Long,action:String){
        val intentalarm = Intent (applicationContext,AlarmBroadcastReceiver::class.java)
        intentalarm.putExtra(AlarmBroadcastReceiver.ALARMKEY,action)
        val pendingIntent = getSystemService(ALARM_SERVICE)as AlarmManager
            val manager = getSystemService(ALARM_SERVICE)as AlarmManager
        if(action==AlarmBroadcastReceiver.ALARMSTOP)
        {
            manager.setExact(AlarmManager.RTC_WAKEUP,militime,pendingIntent)
        }
        else
        {
            manager.cancel(pendingIntent)
            sendBroadcast(intentalarm)
        }
    }

}