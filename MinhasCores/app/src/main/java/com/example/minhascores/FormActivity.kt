package com.example.minhascores

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import kotlin.text.*

class FormActivity : AppCompatActivity() {
    private lateinit var etColorName: EditText
    private lateinit var sbRed: SeekBar
    private lateinit var sbGreen: SeekBar
    private lateinit var sbBlue: SeekBar
    private lateinit var btCode: Button
    private lateinit var btSave: Button
    private lateinit var btCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etColorName = findViewById(R.id.etFormColorName)
        this.sbRed = findViewById(R.id.sbFormRed)
        this.sbGreen = findViewById(R.id.sbFormGreen)
        this.sbRed = findViewById(R.id.sbFormRed)
        this.sbBlue = findViewById(R.id.sbFormBlue)
        this.btCode = findViewById(R.id.btFormCode)
        this.btSave = findViewById(R.id.btFormSave)
        this.btCancel = findViewById(R.id.btFormCancel)

        if (intent.hasExtra("EDIT_COLOR")){
            val color = intent.getSerializableExtra("EDIT_COLOR") as Collor
            this.etColorName.setText(color.name)
            this.btCode.text = color.toHex()
            this.btCode.setBackgroundColor(color.code)
            this.sbRed.progress = Color.red(color.code)
            this.sbGreen.progress = Color.green(color.code)
            this.sbBlue.progress = Color.blue(color.code)
        }

        btSave.setOnClickListener { clickButtonSave(it) }
        btCancel.setOnClickListener { finish() }
        btCode.setOnClickListener { copyToClipBoard() }

        setSeekListener(sbRed)
        setSeekListener(sbGreen)
        setSeekListener(sbBlue)
    }

//

    private fun copyToClipBoard() {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("Color", btCode.text)
        clipboard.setPrimaryClip(clipData)
        Toast.makeText(this, "Copied color:${btCode.text}", Toast.LENGTH_SHORT).show()
    }

    private fun clickButtonSave(view: View) {
        val text = this.etColorName.text.toString()
        val colorCode = Color.rgb(sbRed.progress, sbGreen.progress, sbBlue.progress)

        val c = if (intent.hasExtra("EDIT_COLOR")) {
            val color = intent.getSerializableExtra("EDIT_COLOR") as Collor
            color.name = text
            color.code = colorCode
            color
        }else{
            Collor(text, colorCode)
        }

        val intent = Intent()
        intent.putExtra("COLOR_SAVE", c)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun setSeekListener (seekBar: SeekBar) {
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val colorCode = Color.rgb(sbRed.progress, sbGreen.progress, sbBlue.progress)
                btCode.text = String.format("#%06X", (0xFFFFFF and colorCode))
                btCode.setBackgroundColor(colorCode)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}
