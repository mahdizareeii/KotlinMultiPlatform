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
        HStack {
            //TODO load image
            
            VStack{
                Text(data.title).font(Font.system(size: 14))
                Spacer().frame(height: 3)
                Text(data.description).font(Font.system(size: 10))
            }
        }
    }
}
