import SwiftUI

@main
struct iOSApp: App {

    init() {
        KoinModuleKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}