package com.example.apphoroscopo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton: Button = findViewById<Button>(R.id.btnEnviar)
        val texto: EditText = findViewById(R.id.txtNombre)
        val calendario: DatePicker = findViewById<DatePicker>(R.id.datePicker)

        boton.setOnClickListener{
            val dia = calendario.dayOfMonth
            val mes = calendario.month+1
            val anio = calendario.year
            val nombre = texto.text

            Toast.makeText(this, "$nombre Fecha seleccionada: $dia/$mes/$anio", Toast.LENGTH_SHORT).show()

            // Para realizar el envío de información de una activity a la otr
            val intentFuturo = Intent(this, ActividadVerFuturo::class.java)
            // Añadir el nombre, el día y el mes de nacimiento como extras al Intent
            intentFuturo.putExtra("nombre", nombre.toString()) //Necesitamos hacerlo así
            intentFuturo.putExtra("dia", dia)
            intentFuturo.putExtra("mes", mes)
            startActivity(intentFuturo)
        }
    }
}