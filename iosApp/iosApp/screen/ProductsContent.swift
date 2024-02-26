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
            switch productsViewModel.uiState {
            case is BaseUiStateLoadingUiState: Text("Loading")
            case is BaseUiStateEmptyUiState: Text("Empty")
            case is BaseUiStateSuccessUiState<ProductsUiState>: Text("Success")
            case is BaseUiStateErrorUiState: Text("Error")
            default : Text("-")
            }
        }
    }
}

struct Products_Previews : PreviewProvider{
    static var previews: some View {
        ProductsContent()
    }
}
