import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        //call initKoin() fun in KoinModule.kt in shared module common main
        KoinModuleKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
            TabView {
                ProductsContent().tabItem {
                    Text("products")
                }
                SharedClockScreenContent().tabItem {
                    Text("shared screen")
                }
            }
		}
	}
}
