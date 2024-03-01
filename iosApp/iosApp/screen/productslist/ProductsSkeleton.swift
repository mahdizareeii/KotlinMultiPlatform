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
            LazyVStack{
                ForEach(0..<10){ _ in
                    Rectangle()
                        .cornerRadius(4)
                        .foregroundColor(.gray.opacity(0.3))
                        .frame(height: 100)
                        .padding(.vertical, 4)
                        .padding(.horizontal, 8)
                }
            }
            .modifier(Shimmer())
        }
    }
}
#Preview {
    ProductsSkeleton()
}
