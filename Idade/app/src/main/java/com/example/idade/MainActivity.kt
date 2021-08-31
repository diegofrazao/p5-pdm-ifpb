package com.example.idade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.idade.model.Pessoa

class MainActivity : AppCompatActivity() {
    private lateinit var btCalular: Button
    private lateinit var etNome: EditText
    private lateinit var etAno: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.etNome = findViewById(R.id.etMainNome)
        this.etAno = findViewById(R.id.etMainAno)
        this.btCalular = findViewById(R.id.btMainCalcular)
        this.btCalular.setOnClickListener({ calcularIdade(it) })
    }

    private fun calcularIdade(view: View) {
        val nome = etNome.text.toString()
        val ano = etAno.text.toString().toInt()
        val pessoa = Pessoa(nome, ano)
        val intent = Intent(this, OutraActivity::class.java)
        intent.putExtra("PESSOA_ENVIADA", pessoa)
        startActivity(intent)
    }

}