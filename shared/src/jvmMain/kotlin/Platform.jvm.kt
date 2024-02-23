import io.ktor.client.engine.HttpClientEngineFactory
import org.koin.core.module.Module

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override val module: List<Module>
        get() = TODO("Not yet implemented")
    override val httpEngine: HttpClientEngineFactory<*>
        get() = TODO("Not yet implemented")
}

actual fun getPlatform(): Platform = JVMPlatform()