import UIKit
import SwiftUI
import ComposeApp

struct TestComposeUiController: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct TestComposeContentView: View {
    var body: some View {
        TestComposeUiController()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}



