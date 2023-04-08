package ru.pseudonimb.filmsearch.recievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import ru.pseudonimb.filmsearch.data.entity.Film
import ru.pseudonimb.filmsearch.view.notifications.NotificationConstants
import ru.pseudonimb.filmsearch.view.notifications.NotificationHelper

class ReminderBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val bundle = intent?.getBundleExtra(NotificationConstants.FILM_BUNDLE_KEY)
        val film: Film = bundle?.get(NotificationConstants.FILM_KEY) as Film

        NotificationHelper.createNotification(context!!, film)
    }
}