import android.os.Build
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import viewmodel.ProductsViewModel

class AndroidPlatform(
    override val module: List<Module> = listOf(
        module {
            viewModel {
                ProductsViewModel(
                    getProductsUseCase = get(),
                    productsSectionMapper = get()
                )
            }
        }
    ),
    override val httpEngine: HttpClientEngineFactory<*> = CIO
) : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()