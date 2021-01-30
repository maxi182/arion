package com.example.rootstrapinterview

import android.app.Application
import com.example.rootstrapinterview.data.di.DataModule
import com.example.rootstrapinterview.domain.di.DomainModule
import com.example.rootstrapinterview.ui.di.AppModules
import com.example.rootstrapinterview.utils.StorageProvider
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module

/**
 * Created by Maxi
 * since 29/01/2021
 */
class RootstrapApplication: Application() {

    private val storageProvider: StorageProvider by inject()

    override fun onCreate() {
        super.onCreate()
        initKoin()
        storageProvider.init(this)
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@RootstrapApplication)
            loadKoinModules(mutableListOf<Module>().plus(AppModules).plus(DataModule).plus(DomainModule))
        }
    }
}