package com.example.ProyRenzo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ProyRenzo.LibroSqLite.BDHelper

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val inputUsuario: EditText = findViewById(R.id.LoginTxtUsuario)
        val inputContrasena: EditText = findViewById(R.id.LoginTxtContrasena)
        val btnLogin: Button = findViewById(R.id.LoginbtnAcceder)

        btnLogin.setOnClickListener {

            val usuario = inputUsuario.text.toString()
            val contrasena = inputContrasena.text.toString()

            val bd = BDHelper(this, null)
            val cursor = bd.Acceder(usuario, contrasena)

            if (cursor!!.count <= 0) {
                Toast.makeText(this, "Usuario y/o contraseña incorrecta", Toast.LENGTH_LONG).show()
            } else {
                cursor!!.moveToFirst()
                val usuarioIndex = cursor.getColumnIndex("USUARIO");
                val usuario = cursor.getString(usuarioIndex)

                val productScreen = Intent(this, LibroActivity::class.java)
                startActivity(productScreen)
            }


        }

    }
}