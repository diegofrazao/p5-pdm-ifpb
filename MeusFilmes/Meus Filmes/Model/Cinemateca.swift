//
//  Cinemateca.swift
//  Meus Filmes
//
//  Created by Diego on 03/06/21.
//

import Foundation
class Cinemateca {
    private var lista: Array<Filme>
    
    init() {
        self.lista = Array<Filme>()
    }
    
    func add(filme: Filme){
        self.lista.append(filme)
    }
    
    func count() -> Int{
        return self.lista.count
    }
    
    func get() -> Array<Filme> {
        return self.lista
    }
}
