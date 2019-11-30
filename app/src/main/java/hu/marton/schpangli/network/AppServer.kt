package hu.marton.schpangli.network

import android.content.Context

class AppServer(context: Context) {

    init {
        ApiService.create(context)
    }
}