package com.example.foto

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var ivFoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.ivFoto = findViewById(R.id.ivMainFoto)
        this.ivFoto.setOnClickListener({ capturarFoto(it) })
    }

    private fun capturarFoto (view: View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null)
            startActivityForResult(intent, 1)
        else
            Toast.makeText(this, "Erro, não tem activity", Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if( resultCode == Activity.RESULT_OK){
            if(requestCode == 1){
                val foto: Bitmap? = data?.getParcelableExtra("data")
                this.ivFoto.setImageBitmap(foto)
            }
        }
    }
}