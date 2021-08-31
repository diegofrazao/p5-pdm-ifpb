//
//  FormViewController.swift
//  Meus Filmes
//
//  Created by Diego on 03/06/21.
//

import UIKit

class FormViewController: UIViewController {

    
    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var slNota: UISlider!
    @IBOutlet weak var lbNota: UILabel!
    @IBOutlet weak var swIndicado: UISwitch!
    @IBOutlet weak var lbReassitido: UILabel!
    @IBOutlet weak var stReasistido: UIStepper!
    
    var cinemateca: Cinemateca!

    @IBAction func sliderChanged(_ sender: UISlider) {
        let sliderValue = Int(self.slNota.value)
        self.lbNota.text = String(sliderValue)
    }
    
    @IBAction func stepperChanged(_ sender: UIStepper) {
        let stepValue = Int(self.stReasistido.value)
        self.lbReassitido.text = String(stepValue)
    }
    
    @IBAction func Salvar(_ sender: Any) {
        let nome = self.tfNome.text!
        let nota = Int(self.slNota.value)
        let indicado = Bool(self.swIndicado.isOn)
        let reassistido = Int(self.stReasistido.value)
        
        let filme = Filme(nome: nome, nota: nota, indicado: indicado, reassistido: reassistido)
        print(filme)
        self.cinemateca = (UIApplication.shared.delegate as! AppDelegate).cinemateca
        self.cinemateca.add(filme: filme)
        
        self.navigationController?.popViewController(animated: true)
    }
    
}
