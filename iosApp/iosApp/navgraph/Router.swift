//
//  AppNavGraph.swift
//  iosApp
//
//  Created by Mahdi Zareei on 3/1/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import shared
import Foundation
import SwiftUI

enum Router : Equatable{
    case ProductsScreen
    case ProductView(args: ProductViewArgs)
    case SharedScreen
    case empty

    @ViewBuilder
    var builder: some View {
        switch self {
        case .ProductView(let args): ProductViewContent(args: args)
        case .ProductsScreen: ProductsContent()
        case .SharedScreen: SharedClockScreenUiController()
        default: Text("route does not define")
        }
    }
}
