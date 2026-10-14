package com.example.appperrroparahacerferiamachinmiviejoalv

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
   private lateinit var btningresar: Button
   private lateinit var btncancelar: Button
   private lateinit var pbcarga: ProgressBar
   private lateinit var tvmensaje: TextView
   private lateinit var etxtnombre: EditText
   private lateinit var etxtmatricula: EditText
   private var contadorAsistentes=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Conectar las vistas
        tvmensaje = findViewById(R.id.tvmensaje)
        etxtnombre = findViewById(R.id.etxtnombre)
        btningresar = findViewById(R.id.btningresar)
        pbcarga=findViewById(R.id.pbcarga)
        etxtmatricula=findViewById(R.id.etxtmatricula)
        btncancelar=findViewById(R.id.btncancelar)

        //Creacion del listener
        btningresar.setOnClickListener { ingresar() }
        btncancelar.setOnClickListener { limpiarCampos() }
    }
    private fun ingresar(){


    }
    private fun limpiarCampos(){
        etxtmatricula.setText("")
        etxtnombre.setText("")
        pbcarga.visibility= View.GONE
        tvmensaje.text="Escribe tu matricula para iniciar"
        btningresar.text="Saludar"
        btncancelar.isEnabled=true
        etxtnombre.requestFocus()

    }
}