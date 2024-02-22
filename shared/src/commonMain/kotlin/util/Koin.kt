package util

import getPlatform
import network.api.apiModule
import network.di.networkModule
import org.koin.core.context.startKoin
import repository.repositoryModule

fun initKoin() = startKoin {
    modules(
        listOf(
            networkModule,
            apiModule,
            repositoryModule,
            *getPlatform().module.toTypedArray()
        )
    )
}