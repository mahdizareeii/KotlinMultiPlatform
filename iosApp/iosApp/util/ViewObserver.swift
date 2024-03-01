//
//  ViewObserver.swift
//  iosApp
//
//  Created by Mahdi Zareei on 3/1/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Combine

private class ObservableModel<StateObserved>: ObservableObject {
    @Published var stateObserved: StateObserved?
    
    init(statePublisher: AnyPublisher<StateObserved, Never>) {
        statePublisher
            .compactMap { $0 }
            .receive(on: DispatchQueue.main)
            .assign(to: &$stateObserved)
    }
}


//example of using view observer
//var body: some View {
//    NavigationView {
//        VStack {
//            ObservingView(statePublisher: statePublisher(loginViewModel.uiStates())) { state in
//
//            }
//        }
//    }
//}
public struct ObservingView<StateObserved, Content>: View where Content: View {
    @ObservedObject private var model: ObservableModel<StateObserved>
    
    private let content: (StateObserved) -> Content
    
    public init(statePublisher: AnyPublisher<StateObserved, Never>, @ViewBuilder content: @escaping (StateObserved) -> Content) {
        self.model = ObservableModel(statePublisher: statePublisher)
        self.content = content
    }
    
    public var body: some View {
        let view: AnyView
        if let viewState = self.model.stateObserved {
            view = AnyView(content(viewState))
        } else {
            view = AnyView(EmptyView())
        }
        
        return view
    }
}
