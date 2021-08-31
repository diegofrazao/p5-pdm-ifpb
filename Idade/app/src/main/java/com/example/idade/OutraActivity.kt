package com.example.idade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.idade.model.Pessoa

class OutraActivity : AppCompatActivity() {
    private lateinit var tvFinaliza: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        val pessoa = intent.getSerializableExtra("PESSOA_ENVIADA") as Pessoa
        tvFinaliza = findViewById(R.id.tvOutraResultado)
        tvFinaliza.text = "${pessoa.nome}, você possui ${pessoa.idade()} anos"
        tvFinaliza.setOnClickListener({ finish() })
    }
}