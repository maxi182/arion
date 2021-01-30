package com.example.rootstrapinterview.ui.di

import com.example.rootstrapinterview.RootstrapApplication
import com.example.rootstrapinterview.ui.viewmodel.CharactersListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by Maxi
 * since 29/01/2021
 */

val CharacterListModule : Module = module {
    viewModel { CharactersListViewModel(androidApplication() as RootstrapApplication, get()) }
}