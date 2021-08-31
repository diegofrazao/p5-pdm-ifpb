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
    var filmeParaEdicao: Int!

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
        
        if (self.filmeParaEdicao != nil){
            self.cinemateca.update(index: filmeParaEdicao, filme: filme)
        }else{
            self.cinemateca.add(filme: filme)
        }
        
        print(filme)
        self.navigationController?.popViewController(animated: true)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.cinemateca = (UIApplication.shared.delegate as! AppDelegate).cinemateca
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        if(self.filmeParaEdicao != nil){
            let filme = self.cinemateca.get(index: filmeParaEdicao)
            self.tfNome.text = filme.nome
            self.lbNota.text = String(filme.nota)
            self.slNota.value = Float(filme.nota)
            self.swIndicado.isOn = filme.indicado
            self.lbReassitido.text = String(filme.reassistido)
            self.stReasistido.value = Double(filme.reassistido)
        }
    }
    
}
