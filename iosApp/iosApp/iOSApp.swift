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
            ProductsContent()
		}
	}
}
