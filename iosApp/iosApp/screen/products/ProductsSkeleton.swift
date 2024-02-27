//
//  ProductsSkeleton.swift
//  iosApp
//
//  Created by Mahdi Zareei on 2/27/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import Foundation

struct ProductsSkeleton: View {
    var body: some View{
        ScrollView{
            LazyVStack(spacing: 4){
                ForEach(0..<10){ _ in
                    Rectangle()
                        .frame(height: 100)
                        .padding()
                        .modifier(Shimmer())
                }
            }
        }
    }
}
