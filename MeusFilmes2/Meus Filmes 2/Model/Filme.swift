//
//  Filme.swift
//  Meus Filmes
//
//  Created by Diego on 03/06/21.
//

import Foundation
class Filme: NSObject {
    var nome: String
    var nota: Int
    var indicado: Bool
    var reassistido: Int
    
    init(nome: String, nota: Int, indicado: Bool, reassistido: Int) {
        self.nome = nome
        self.nota = nota
        self.indicado = indicado
        self.reassistido = reassistido
    }
    
    override var description: String{
        return "nome:\(self.nome), nota:\(self.nota), indicado ao oscar? \(self.indicado ? "sim" : "não"), reassistido: \(self.reassistido > 1 ? "\(self.reassistido) vezes" : "não")"
    }
}
