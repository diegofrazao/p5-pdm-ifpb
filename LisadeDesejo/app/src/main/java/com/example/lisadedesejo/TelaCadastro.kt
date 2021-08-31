package com.example.lisadedesejo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class TelaCadastro : AppCompatActivity() {
    private lateinit var btCadastrar: Button
    private lateinit var btCancelar: Button
    private lateinit var etDescricao: TextView
    private lateinit var etValor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro)

        this.btCadastrar = findViewById(R.id.btCadastrar)
        this.btCancelar = findViewById(R.id.btCancelar)
        this.etDescricao = findViewById(R.id.etDescricao)
        this.etValor = findViewById(R.id.etValor)

        this.btCadastrar.setOnClickListener({ cadastrarDesejo(it) })
        this.btCancelar.setOnClickListener({ finish() })

    }

    private fun cadastrarDesejo(view: View) {
        val descricao = etDescricao.text.toString()
        val valor = etValor.text.toString().toFloat()
        val desejo = Desejo(descricao, valor)
        val intent = Intent()
        intent.putExtra("DESEJO", desejo)
        setResult(RESULT_OK, intent)
        finish()
    }
}