package edu.iesam.examaad1eval.features.core

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class examaad1eval : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@examaad1eval)

            //modules()
        }
    }
}
