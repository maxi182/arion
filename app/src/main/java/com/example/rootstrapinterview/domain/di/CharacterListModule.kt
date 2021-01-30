package com.example.rootstrapinterview.domain.di

import com.example.rootstrapinterview.domain.CharacterListRepoImpl
import com.example.rootstrapinterview.domain.CharacterListUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by Maxi
 * since 29/01/2021
 */
val CharacterListModule: Module = module {
    factory { CharacterListUseCase(get() as CharacterListRepoImpl) }
    factory { CharacterListRepoImpl(get(), get()) }
}