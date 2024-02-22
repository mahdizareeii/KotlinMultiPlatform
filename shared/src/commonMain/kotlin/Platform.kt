import io.ktor.client.engine.HttpClientEngineFactory
import org.koin.core.module.Module

interface Platform {
    val name: String
    val module: List<Module>
    val httpEngine: HttpClientEngineFactory<*>
}

expect fun getPlatform(): Platform