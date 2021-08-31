//
//  ViewController.swift
//  jogo da forca
//
//  Created by Diego on 02/06/21.
//

import UIKit

class MainViewController: UIViewController {

    @IBOutlet weak var lbDica: UILabel!
    @IBOutlet weak var lbQuantLetras: UILabel!
    @IBOutlet weak var lbLetrasJogadas: UILabel!
    @IBOutlet weak var lbTentativas: UILabel!
    @IBOutlet weak var lbStatus: UILabel!
    @IBOutlet weak var tfLetra: UITextField!
    @IBOutlet weak var ivForca: UIImageView!
    
    var forca: Forca!
    var playAgain: Bool = false
    
    @IBAction func btJogar(_ sender: Any) {
        let letra = Character(self.tfLetra.text!.uppercased())
        self.forca.jogar(letra: letra)
        self.atualizar()
        if (self.forca.terminou()){
            let rvc = self.storyboard?.instantiateViewController(identifier: "view_resultado") as! ResultadoViewController
            rvc.resultado = self.forca.resultado()
            rvc.modalPresentationStyle = .fullScreen
            rvc.completionHandler = { resp in
                self.playAgain = resp!
            }
            self.present(rvc, animated: true, completion: nil)
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.forca = Forca()
    }
    
    func atualizar(){
        self.lbDica.text = self.forca.dica
        self.lbQuantLetras.text = "Quantidade: \(self.forca.palavra.count) letras"
        self.lbLetrasJogadas.text = String(self.forca.letrasJogadas)
        self.lbTentativas.text = "Tentativas restantes: \(11 - self.forca.tentativas)"
        self.lbStatus.text = String(self.forca.status)
        self.ivForca.image = UIImage(named: String(self.forca.tentativas + 1))
    }
    
    func restart(){
        self.forca.restart()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
        if (self.playAgain){
            restart()
        }
        self.atualizar()
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillAppear(true)
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(true)
    }
}

