//
//  SharedClockScreenContent.swift
//  iosApp
//
//  Created by Mahdi Zareei on 2/26/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import ComposeApp
import SwiftUI

struct SharedClockScreenUiController: UIViewControllerRepresentable{
    func makeUIViewController(context: Context) -> UIViewController {
        SharedClockScreenViewControllerKt.SharedClockScreenViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct SharedClockScreenContent: View {
    var body: some View {
        SharedClockScreenUiController()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}
