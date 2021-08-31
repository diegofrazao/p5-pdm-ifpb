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
    
    func get(index: Int) -> Filme {
        return self.lista[index]
    }
    
    func get() -> Array<Filme> {
        return self.lista
    }
    
    func del(index: Int){
        self.lista.remove(at: index)
    }
    
    func mov(at: Int, to: Int){
        let filme = self.lista[at]
        self.lista.remove(at: at)
        self.lista.insert(filme, at: to)
    }
    
    func update(index: Int, filme: Filme){
        self.lista[index] = filme
    }
}
