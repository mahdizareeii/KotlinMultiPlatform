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
                NavigationView {
                    ProductsContent().navigationBarHidden(false)
                }.tabItem {
                    Text("Specific Ui").font(.system(size: 12, weight:.black))
                }
                
                NavigationView {
                    SharedClockScreenContent().navigationBarHidden(false)
                }.tabItem {
                    Text("Shared Ui").font(.system(size: 12, weight: .regular))
                }
            }
        }
    }
}
