//
//  ProductComponent.swift
//  iosApp
//
//  Created by Mahdi Zareei on 2/26/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

struct ProductComponent: View {
    var data : ProductComponentData
    var body : some View {
        HStack(alignment:.top){
            AsyncImage(url: URL(string: data.image)){image in
                image.image?.resizable()
                    .scaledToFill()
                    .frame(width: 100, height: 100, alignment: .center)
                    .clipped()
            }.frame(width: /*@START_MENU_TOKEN@*/100/*@END_MENU_TOKEN@*/,height: 100)
                .cornerRadius(5)
            
            Spacer().frame(width: 0).padding(3)
            
            VStack(alignment: .leading){
                Text(data.title)
                    .font(Font.system(size: 14, weight: .bold))
                    .lineLimit(/*@START_MENU_TOKEN@*/2/*@END_MENU_TOKEN@*/)
                    .truncationMode(/*@START_MENU_TOKEN@*/.tail/*@END_MENU_TOKEN@*/)
                
                Spacer().frame(height: 0).padding(3)
                
                Text(data.description)
                    .font(Font.system(size: 10, weight: .light))
                    .lineLimit(3)
                    .truncationMode(/*@START_MENU_TOKEN@*/.tail/*@END_MENU_TOKEN@*/)
            }
        }
    }
}
struct ProductComponent_Preview: PreviewProvider {
    static var previews: some View {
        ProductComponent(
            data: ProductComponentData(image: "test", title: "test", description: "description")
        )
    }
}
