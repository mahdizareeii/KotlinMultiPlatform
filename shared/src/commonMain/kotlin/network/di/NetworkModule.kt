package network.di

import getPlatform
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.plugin
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(getPlatform().httpEngine){
            install(Logging){
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
            install(ContentNegotiation){
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }.also {
            it.plugin(HttpSend).intercept { request->
                request.url{
                    if (host.isEmpty()){
                        protocol = URLProtocol.HTTPS
                        host = "www.gamerpower.com"
                    }
                }
                execute(request)
            }
        }
    }
}