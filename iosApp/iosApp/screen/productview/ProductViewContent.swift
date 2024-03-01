//
//  ProductViewContent.swift
//  iosApp
//
//  Created by Mahdi Zareei on 2/28/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import shared
import Foundation
import SwiftUI

struct ProductViewContent: View {
    var args: ProductViewArgs? = nil
    
    var body: some View {
        ScrollView{
            LazyVStack{
                Text(args?.title ?? "")
            }
        }
    }
}
