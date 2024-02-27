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
                    Text("Specific Ui").font(.system(size: 12, weight:.black))
                }
                SharedClockScreenContent().tabItem {
                    Text("Shared Ui").font(.system(size: 12, weight: .regular))
                }
            }
        }
    }
}
