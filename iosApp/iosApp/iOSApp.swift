import SwiftUI
import shared

@main
struct iOSApp: App {
    
    init() {
        //call initKoin() fun in KoinModule.kt in shared module common main
        KoinModuleKt.doInitKoin()
    }
    
    var body: some Scene {
        @State var route: Router = .empty
        
        WindowGroup {
            //            NavigationView {
            //                TabView {
            //                    .tabItem {
            //                        Text("Specific Ui")
            //                            .font(.system(size: 12, weight:.black))
            //                            .onTapGesture {
            //                                route = .SharedScreen
            //                            }
            //                    }.tabItem {
            //                        Text("Shared Ui")
            //                            .font(.system(size: 12, weight: .regular))
            //                            .onTapGesture {
            //                                route = .ProductsScreen
            //                            }
            //                    }
            //                }.navigation(route: $route)
            //            }.navigationViewStyle(.stack)
            
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
            
//            NavigationView {
//                VStack {
//                    Button("go1") { route = .ProductsScreen }
//                    Button("go2") { route = .SharedScreen }
//                }.navigation(route: $route)
//            }.navigationViewStyle(.stack)
        }
    }
}
