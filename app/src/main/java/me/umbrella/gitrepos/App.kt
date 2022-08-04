package me.umbrella.gitrepos

import android.app.Application
import me.umbrella.gitrepos.data.di.DataModule
import me.umbrella.gitrepos.domain.di.DomainModule
import me.umbrella.gitrepos.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}