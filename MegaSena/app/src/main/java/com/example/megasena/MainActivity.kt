package com.example.megasena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.botao = findViewById(R.id.btnCliqueAqui)
        this.botao.setOnClickListener({ megasena(it) })
    }

    fun megasena(view: View){
        var numeros = mutableListOf<Int>()

        while (numeros.size <6){
            var sorteio = Random().nextInt(60)+1
            if(sorteio !in numeros)
                numeros.add(sorteio)
        }
        Log.i("MEGASENA", numeros.toList().sorted().toString())
    }
}