//
//  ProductsContent.swift
//  iosApp
//
//  Created by Mahdi Zareei on 2/23/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared
import KMMViewModelSwiftUI

struct ProductsContent : View {
    
    @StateViewModel var productsViewModel = GetIosViewModel().getProductsViewModel()
    
    var body: some View {
        LazyVStack(){
            
        }
    }
}

struct Products_Previews : PreviewProvider{
    static var previews: some View {
        ProductsContent()
    }
}
