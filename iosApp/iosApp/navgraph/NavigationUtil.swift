//
//  AppNavGraph.swift
//  iosApp
//
//  Created by Mahdi Zareei on 3/1/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

extension View {
    @ViewBuilder
    func navigation(route: Binding<Router>) -> some View {
        if route.wrappedValue != .empty {
            modifier(NavigationModifier(route: route))
        } else {
            self
        }
    }
}

struct NavigationModifier: ViewModifier {
    @State private var isActive: Bool = true
    @Binding var route: Router

    func body(content: Content) -> some View {
        content
            .background {
                NavigationLink(
                    destination: route.builder,
                    isActive: $isActive
                ) {
                    EmptyView()
                }
                .hidden()
            }
            .onChange(of: isActive) { newValue in
                if !newValue {
                    route = .empty
                }
            }
    }
}
