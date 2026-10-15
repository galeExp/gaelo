package com.example.appperrroparahacerferiamachinmiviejoalv

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
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
        contadorAsistentes++

        val nombre=etxtnombre.text.toString().trim()
        val matricula=etxtmatricula.text.toString().trim()

        if(nombre.isEmpty()){
            Toast.makeText(this,"Escribe tu nombre", Toast.LENGTH_SHORT).show()
            return
        }else if (nombre.length<3){
            Toast.makeText(this,"EL nombre es muy corto", Toast.LENGTH_SHORT).show()
            return
        }
        if(matricula.isEmpty()){
            Toast.makeText(this,"Escribe tu matricula", Toast.LENGTH_SHORT).show()
            return
        }else if (matricula.length!=7){
            Toast.makeText(this,"La matricula debe contener 7 caracteres", Toast.LENGTH_SHORT).show()
            return
        }
        val datos = "$nombre\n$matricula"

        pbcarga.visibility= View.VISIBLE
        tvmensaje.text=""
        btningresar.isEnabled=false
        Handler(Looper.getMainLooper()).postDelayed({
            pbcarga.visibility= View.GONE
            tvmensaje.text="HOLA, $datos pusado \n   BIENVENIDO"
            btningresar.isEnabled=true
            etxtnombre.isEnabled=true


        },1500)

    }
    private fun limpiarCampos(){
        etxtmatricula.setText("")
        etxtnombre.setText("")
        pbcarga.visibility= View.GONE
        tvmensaje.text="Escribe tu matricula para iniciar"
        btningresar.text="Saludar"
        btningresar.isEnabled=true
        btncancelar.isEnabled=true
        etxtmatricula.requestFocus()

    }
}