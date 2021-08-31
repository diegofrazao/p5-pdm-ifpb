//
//  Forca.swift
//  forca
//
//  Created by Diego on 02/06/21.
//

import Foundation

class Forca {
    var palavra: Array<Character>
    var status: Array<Character>
    var dica: String
    var tentativas: Int
    var letrasJogadas: Array<Character>
    var palavras = [["CAFE","BEBIDA"],["PAO","COMIDA"],["TELEVISAO","ASSISTIR"],["CELULAR","FAZ LIGACAO"],["COMPRAS","SHOPPING"]]
    
    init() {
        let n = Int.random(in: 0..<self.palavras.count)
        let sorteada = self.palavras[n]
        self.palavra = Array(sorteada[0])
        self.dica = sorteada[1]
        self.tentativas = 0
        self.letrasJogadas = Array()
        self.status = Array(repeating: "_", count: self.palavra.count)
    }
    
    func restart(){
        let n = Int.random(in: 0..<self.palavras.count)
        let sorteada = self.palavras[n]
        self.palavra = Array(sorteada[0])
        self.dica = sorteada[1]
        self.tentativas = 0
        self.letrasJogadas = Array()
        self.status = Array(repeating: "_", count: self.palavra.count)
    }
    
    func jogadaValida(letra: Character) -> Bool {
        return !self.letrasJogadas.contains(letra) && self.palavra.contains(letra) && self.tentativas < 11
    }
    
    func jogar(letra: Character){
        if (self.jogadaValida(letra: letra)){
            self.letrasJogadas.append(letra)
            for i in 0..<self.palavra.count{
                if (self.palavra[i] == letra) {
                    self.status[i] = letra
                }
            }
        }else{
            self.tentativas += 1
            if(!self.letrasJogadas.contains(letra)){
                self.letrasJogadas.append(letra)
            }
        }
    }
    
    func terminou() -> Bool {
        return self.palavra == self.status || self.tentativas >= 10
    }
    
    func resultado()-> String {
        if (self.terminou()){
            if (self.palavra == self.status){
                return "Ganhou"
            }else{
                return "Perdeu"
            }
        }else{
            return "Jogo não terminou"
        }
    }
}
