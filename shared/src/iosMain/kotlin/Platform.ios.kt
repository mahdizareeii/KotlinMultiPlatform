import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.component.KoinComponent
import org.koin.core.module.Module
import platform.UIKit.UIDevice

class IOSPlatform(
    override val module: List<Module> = listOf(
//TODO define modules here
    ),
    override val httpEngine: HttpClientEngineFactory<*> = Darwin
) : Platform {
    override val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

object GetIosViewModel : KoinComponent {

}

actual fun getPlatform(): Platform = IOSPlatform()