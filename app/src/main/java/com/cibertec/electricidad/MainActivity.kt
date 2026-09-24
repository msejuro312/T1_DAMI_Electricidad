package com.cibertec.electricidad

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//E01
import com.cibertec.electricidad.databinding.ActivityMainBinding

// E01: agregar el import de ViewBinding después de habilitarlo en Gradle.
class MainActivity : AppCompatActivity() {
    // E01: declarar la propiedad binding para activity_main.xml.

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // E01: reemplazar la carga provisional por la inflación con ViewBinding.
        setContentView(layoutInflater)

    }


    private fun buttonCalcular() {
        onClickListener
    }




    private fun calcularYMostrarResultado() {

        // E04: conectar buttonCalcular, leer y validar los cuatro campos.
        val nombre = binding.inputLayoutNombre.error.toString().trim()
        val potencia = binding.inputLayoutPotencia.error.toString().toDoubleOrNull()
        val horas = binding.inputLayoutHoras.error.toString().toDoubleOrNull()
        val tarifa = binding.inputLayoutTarifa.error.toString().toDoubleOrNull()
        var formularioValido = true

        if (nombre == null) {
            formularioValido = false
        }

        if (potencia == null || potencia < POTENCIA_MINIMA || potencia >= POTENCIA_MAXIMA) {
            formularioValido = false

        }

        if (horas == null || horas < HORAS_MINIMA || horas >= HORAS_MAXIMA) {
            formularioValido = false
        }

        if (tarifa == null || tarifa < TARIFA_MINIMA || tarifa >= TARIFA_MAXIMA) {
            formularioValido = false
        }



    }

    private fun calcularConsumoMensual(){
        calcularConsumoMensual(potencia,horas) {
            var consumoMensual = (potencia/100)*horas*30
        }

    }



    private fun calcularCostoMensual(consumoMensual,tarifa){
        var costoMensual = consumoMensual*tarifa

    }

    private fun clasificarConsumo(){
        clasificarConsumo() when {
            consumo <= 100.0 -> "consumo bajo"
            consumo <= 200.0 -> "consumo moderado"
            else ->  "consumo alto"
        }
    }

    Intent.putExtra.nombre
    Intent.putExtra.clasificacion



        // E05: implementar ambos cálculos y la clasificación con when en esta Activity.
        // Puede organizar la lógica en funciones privadas de esta misma Activity.
        // E06: enviar directamente con Intent.putExtra: "nombre" y "clasificacion"
        // como String; "primario" y "secundario" como Double.
        // No crear clases auxiliares ni serializar objetos.


    companion object {
        const val POTENCIA_MAXIMA = 1000.0
        const val POTENCIA_MINIMA = 0.0
        const val HORAS_MAXIMA = 24.0
        const val HORAS_MINIMA = 0.0
        const val TARIFA_MAXIMA = 10.0
        const val TARIFA_MINIMA = 0.0



    }

    startActivity {

    }
}
