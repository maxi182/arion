package com.example.rootstrapinterview.ui.di

import com.example.rootstrapinterview.utils.StorageProvider
import org.koin.core.module.Module
import org.koin.dsl.module


val StorageProviderModule : Module = module {
    single { StorageProvider() }
}