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
        ScrollView(.vertical){
            LazyVStack(){
                switch productsViewModel.uiState {
                case is BaseUiStateLoadingUiState: ProductsSkeleton()
                case is BaseUiStateEmptyUiState: Text("Empty")
                case is BaseUiStateSuccessUiState<ProductsUiState>:
                    ForEach((productsViewModel.uiState.value(forKey: "state") as? ProductsUiState)?.products ?? [], id: \.self) { uiItem in
                        generateView(item: uiItem)
                    }
                case is BaseUiStateErrorUiState: Text("Error")
                default :  Text("")
                }
            }
        }
    }
    
    @ViewBuilder
    private func generateView(item: BaseComponentData) -> some View {
        switch item {
        case let productData as ProductComponentData:
            ProductComponent(data: productData).padding(.horizontal, 8).padding(.vertical, 4)
        default:
            Text("")
        }
    }
}

struct Products_Previews : PreviewProvider{
    static var previews: some View {
        ProductsContent()
    }
}
