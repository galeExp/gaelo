  package com.example.primer_intento

  import android.os.Bundle
  import android.os.Handler
  import android.os.Looper
  import android.os.PersistableBundle
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
  import org.w3c.dom.Text

  class MainActivity : AppCompatActivity() {
      //Declaracion de variables
      private lateinit var tvSaludo: TextView
      private lateinit var etxtNombre: EditText
      private lateinit var btnSaludar: Button
      private lateinit var  pbCarga: ProgressBar
      private lateinit var etxtApellido: EditText
      private lateinit var btnlimpiar: Button
      private var clicks

      //Zona Oncreate
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          enableEdgeToEdge()
          setContentView(R.layout.activity_main)
          ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)){v,insets->
              val systemBars= insets.getInsets(WindowInsetsCompat.Type.systemBars())
              v.setPadding(systemBars.left,systemBars.top,systemBars.right,systemBars.bottom)
              insets
          }
          //Conectar las vistas
          tvSaludo = findViewById(R.id.tvSaludo)
          etxtNombre = findViewById(R.id.etxtNombre)
          btnSaludar = findViewById(R.id.btnSaludar)
          pbCarga=findViewById(R.id.pbCarga)
          etxtApellido=findViewById(R.id.etxtApellido)
          btnlimpiar=findViewById(R.id.btnlimpiar)

          //Creacion del listener
          btnSaludar.setOnClickListener { saludar() }
          btnlimpiar.setOnClickListener { limpiarCampos() }

      }
      //Funciones
      private fun saludar(){
        clicks++

          val nombre=etxtNombre.text.toString().trim()
          val apellido=etxtApellido.text.toString().trim()

          if(nombre.isEmpty()){
          Toast.makeText(this,"Escribe tu nombre",Toast.LENGTH_SHORT).show()
          return
          }else if (nombre.length<3){
            Toast.makeText(this,"EL nombre es muy corto", Toast.LENGTH_SHORT).show()
            return
          }

          val nombreCompleto = if(apellido.isNotEmpty()) nombre else "$nombre $apellido"


          pbCarga.visibility= View.VISIBLE
          tvSaludo.text=""
          btnSaludar.isEnabled=false
          Handler(Looper.getMainLooper()).postDelayed({
              pbCarga.visibility= View.GONE
              tvSaludo.text="HOLA, $nombreCompleto has pusado \n   BIENVENIDO"
              btnSaludar.isEnabled=true
              etxtNombre.isEnabled=false


          },1500)

      }
      private fun limpiarCampos(){
            etxtNombre.setText("")
            etxtApellido.setText("")
            pbCarga.visibility= View.GONE
            tvSaludo.text="Escribe  tu nombre ára iniciar"
            btnSaludar.text="Saludar"
            btnSaludar.isEnabled=true
            etxtNombre.requestFocus()

      }


  }
