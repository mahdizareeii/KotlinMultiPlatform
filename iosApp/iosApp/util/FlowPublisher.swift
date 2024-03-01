//
//  Publisher.swift
//  iosApp
//
//  Created by Mahdi Zareei on 3/1/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import Combine


func statePublisher<T>(_ flow: WrappedStateFlow<T>) -> AnyPublisher<T, Never>{
    return Deferred<Publishers.HandleEvents<PassthroughSubject<T, Never>>> {
        let subject = PassthroughSubject<T, Never>()
        let closeable = flow.watch { next in
            subject.send(next)
        }
        
        return subject.handleEvents(receiveCancel: {
            closeable.close()
        })
    }.eraseToAnyPublisher()
}

func sharePublisher<T>(_ flow: WrappedSharedFlow<T>) -> AnyPublisher<T, Never> {
    return Deferred<Publishers.HandleEvents<PassthroughSubject<T, Never>>> {
         let subject = PassthroughSubject<T, Never>()
         let closeable = flow.watch { next in
             if let next = next {
                 subject.send(next)
             }
         }
         
         return subject.handleEvents(receiveCancel: {
             closeable.close()
         })
     }.eraseToAnyPublisher()
}
