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
        ScrollView {
            LazyVStack(alignment: .leading) {
                AsyncImage(url: URL(string: args?.image ?? "")) { phase in
                    switch phase {
                    case .success(let image):
                        image
                            .resizable()
                            .scaledToFill()
                            .frame(maxWidth: .infinity, maxHeight: 200)
                            .clipped()
                            .background(Color.black)
                    default:
                        Color.gray
                            .frame(maxWidth: .infinity, maxHeight: 200)
                    }
                }
                .aspectRatio(contentMode: .fill)
                
                Spacer().frame(height: 3)
                
                Text(args?.title ?? "")
                    .fontWeight(.bold)
                    .font(.system(size: 18))
                    .padding(.horizontal, 8)
                
                Spacer().frame(height: 1)
                
                Text(args?.desc ?? "")
                    .fontWeight(.light)
                    .font(.system(size: 14))
                    .padding(.horizontal, 8)
            }
        }
    }
}
