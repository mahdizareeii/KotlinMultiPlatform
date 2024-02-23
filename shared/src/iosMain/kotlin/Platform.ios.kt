import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.UIKit.UIDevice
import viewmodel.ProductsViewModel

class IOSPlatform(
    override val module: List<Module> = listOf(
        module {
            factory {
                ProductsViewModel(
                    getProductsUseCase = get(),
                    productsSectionMapper = get()
                )
            }
        }
    ),
    override val httpEngine: HttpClientEngineFactory<*> = Darwin
) : Platform {
    override val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

object GetIosViewModel : KoinComponent {
    fun getProductsViewModel() = get<ProductsViewModel>()
}

actual fun getPlatform(): Platform = IOSPlatform()