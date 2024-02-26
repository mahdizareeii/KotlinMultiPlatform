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
                    Text("products").font(.system(size: 12, weight:.black))
                }
                SharedClockScreenContent().tabItem {
                    Text("shared screen").font(.system(size: 12, weight: .regular))
                }
            }
        }
    }
}
