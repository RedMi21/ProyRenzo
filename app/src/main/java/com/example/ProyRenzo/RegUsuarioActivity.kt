package com.example.ProyRenzo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ProyRenzo.LibroSqLite.BDHelper

class RegUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_usuario)

        val btnGrabar : Button = findViewById(R.id.btnGrabarUsuario)

        val btnTest : Button = findViewById(R.id.btnTest)

        btnGrabar.setOnClickListener {
            val inputCorreo : EditText = findViewById(R.id.txtCorreo)
            val inputUsuario : EditText = findViewById(R.id.txtUsuario)
            val inputContrasenia : EditText = findViewById(R.id.txtContrasenia)

            val correo = inputCorreo.text.toString()
            val usuario = inputUsuario.text.toString()
            val contrasenia = inputContrasenia.text.toString()

            val db = BDHelper(this, null)

            db.CrearRegistro(correo, usuario, contrasenia)
            Toast.makeText(this, "Se registro el usuario de manera exitosa", Toast.LENGTH_LONG).show()

            inputCorreo.text.clear()
            inputUsuario.text.clear()
            inputContrasenia.text.clear()
        }

        btnTest.setOnClickListener {
            val db = BDHelper(this, null)
            val cursor = db.ListarTodosRegistros()

            cursor!!.moveToLast()

            val indexCorreo = cursor.getColumnIndex("CORREO")
            val correo = cursor!!.getString(indexCorreo)

            Toast.makeText(this, "Ultimo correo registrado es: " + correo, Toast.LENGTH_LONG).show()

        }
    }
}