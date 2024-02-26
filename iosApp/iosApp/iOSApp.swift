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
                    Text("products").font(Font.system(size: 16, weight: .regular))
                }
                SharedClockScreenContent().tabItem {
                    Text("shared screen").font(Font.system(size: 16, weight: .regular))
                }
            }
		}
	}
}
