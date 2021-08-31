package com.example.lisadedesejo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var btAdd: FloatingActionButton
    private lateinit var lvDesejos: ListView
    private lateinit var desejos: ArrayList<Desejo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.desejos = ArrayList()
        this.btAdd = findViewById(R.id.fabAdd)
        this.lvDesejos = findViewById(R.id.lvDesejos)

        val layout = android.R.layout.simple_list_item_1
        this.lvDesejos.adapter = ArrayAdapter<Desejo>(this, layout, this.desejos)

        this.btAdd.setOnClickListener({ adicionarDesejo(it) })

        this.lvDesejos.setOnItemClickListener(ClickNoItemDaLista())
        this.lvDesejos.setOnItemLongClickListener(ClickLongoNoItemDaLista())
    }

    private fun adicionarDesejo(view: View){
        val intent = Intent(this, TelaCadastro::class.java)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                val desejo = data?.getSerializableExtra("DESEJO") as Desejo
                (this.lvDesejos.adapter as ArrayAdapter<Desejo>).add(desejo)
            }
        }
    }

    inner class ClickNoItemDaLista: AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val desejo = this@MainActivity.desejos[position]
            Toast.makeText(this@MainActivity, "${desejo.descricao} R$ ${desejo.valor}", Toast.LENGTH_SHORT).show()
        }
    }

    inner class ClickLongoNoItemDaLista: AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
            val desejo = this@MainActivity.desejos[position]
            (this@MainActivity.lvDesejos.adapter as ArrayAdapter<Desejo>).remove(desejo)
            return true
        }
    }
}


