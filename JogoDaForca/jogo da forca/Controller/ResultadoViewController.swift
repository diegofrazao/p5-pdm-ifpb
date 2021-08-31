//
//  ResultadoViewController.swift
//  jogo da forca
//
//  Created by Diego on 02/06/21.
//

import UIKit

class ResultadoViewController: UIViewController {
    var resultado: String?
    public var completionHandler: ((Bool?)->Void)?
    
    @IBOutlet weak var lbResultado: UILabel!
    @IBAction func btVoltar(_ sender: Any) {
        completionHandler?(true)
        self.dismiss(animated: true, completion: nil)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        self.lbResultado.text = self.resultado
    }
}
