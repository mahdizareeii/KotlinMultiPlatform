package util

import domain.mapper.mapperModule
import domain.usecase.useCaseModule
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
            useCaseModule,
            mapperModule,
            *getPlatform().module.toTypedArray()
        )
    )
}