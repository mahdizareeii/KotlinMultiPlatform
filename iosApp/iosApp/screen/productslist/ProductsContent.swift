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
import ComposeApp
import KMMViewModelSwiftUI

struct ProductsContent : View {
    
    @StateViewModel var productsViewModel = GetIosViewModel().getProductsViewModel()
    
    @State var route: Router = .empty
    
    var body: some View {
        ScrollView(.vertical){
            LazyVStack(){
                switch productsViewModel.uiState {
                case is BaseUiStateInitialUiState<ProductsUiState>: EmptyView()
                case is BaseUiStateLoadingUiState<ProductsUiState>: ProductsSkeleton()
                case is BaseUiStateEmptyUiState<ProductsUiState>: Text("Empty")
                case is BaseUiStateSuccessUiState<ProductsUiState>:
                    ForEach((productsViewModel.uiState.value(forKey: "state") as? ProductsUiState)?.products ?? [], id: \.self) { uiItem in
                        generateView(item: uiItem)
                    }
                case let error as BaseUiStateErrorUiState<ProductsUiState>:
                    Text("Try again \n" + (error.throwable.message?.description ?? "error"))
                        .onTapGesture {
                            error.onTryAgainClicked()
                        }
                default :
                    EmptyView()
                }
            }
        }.onReceive(sharePublisher(productsViewModel.events())) { event in
            handleViewModelEvents(event: event)
        }.navigation(route: $route)
    }
    
    @ViewBuilder
    private func generateView(item: BaseComponentData) -> some View {
        switch item {
        case let productData as ProductComponentData:
            ProductComponent(data: productData)
                .padding(.horizontal, 8)
                .padding(.vertical, 4)
                .onTapGesture {
                    productsViewModel.onProductComponentClicked(
                        data: ProductViewArgs(
                            _id: productData.id,
                            _title: productData.title,
                            _description: productData.description,
                            _image: productData.image
                        )
                    )
                }
            
        default:
            Text("")
        }
    }
    
    private func handleViewModelEvents(event: ProductsEvent) {
        switch event {
        case let event as ProductsEvent.NavigateToProductViewScreen: route = .ProductView(args: event.args)
        case is ProductsEvent.Initial: print("Initial event")
        default: print("default event")
        }
    }
}


#Preview {
    ProductsContent()
}
