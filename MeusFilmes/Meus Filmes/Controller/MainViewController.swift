//
//  ViewController.swift
//  Meus Filmes
//
//  Created by Diego on 03/06/21.
//

import UIKit

class MainViewController: UIViewController {
    
    var cinemateca: Cinemateca!
    
    @IBOutlet weak var lbQuantidade: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.cinemateca = (UIApplication.shared.delegate as! AppDelegate).cinemateca
    }
    
    func atualizaQuantidade(){
        self.lbQuantidade.text = String(cinemateca.count())
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        atualizaQuantidade()
    }

}

