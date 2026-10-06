package com.cibertec.electricidad

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
//E01
import com.cibertec.electricidad.databinding.ActivityMainBinding

// E01: agregar el import de ViewBinding después de habilitarlo en Gradle.
class MainActivity : AppCompatActivity() {
    // E01: declarar la propiedad binding para activity_main.xml.

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // E01: reemplazar la carga provisional por la inflación con ViewBinding.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener {
            calcularYMostrarResultado()
        }

        binding.editTextNombre.doAfterTextChanged {
            binding.inputLayoutNombre.error = null
        }

        binding.editTextPotencia.doAfterTextChanged {
            binding.inputLayoutPotencia.error = null
        }

        binding.editTextHoras.doAfterTextChanged {
            binding.inputLayoutHoras.error = null
        }

        binding.editTextTarifa.doAfterTextChanged {
            binding.inputLayoutTarifa.error = null
        }

    }



    private fun calcularYMostrarResultado(){

    // E05: implementar ambos cálculos y la clasificación con when en esta Activity.
        // Puede organizar la lógica en funciones privadas de esta misma Activity.
        // E06: enviar directamente con Intent.putExtra: "nombre" y "clasificacion"

        val nombre = binding.editTextNombre.text.toString().trim()
        val potencia = leerPotencia(binding.editTextPotencia.text.toString())
        val horas = leerHoras(binding.editTextHoras.text.toString())
        val tarifa = leerTarifa(binding.editTextTarifa.text.toString())
        var formularioValido = true

        if (nombre.isBlank()){
            binding.inputLayoutNombre.error = getString(R.string.error_nombre)
            formularioValido = false

        }

        if (potencia == null){
            binding.inputLayoutPotencia.error = getString(R.string.error_potencia)
            formularioValido = false

        }

        if(horas == null){
            binding.inputLayoutHoras.error = getString(R.string.error_horas)
            formularioValido = false
        }

        if(tarifa == null){
            binding.inputLayoutTarifa.error = getString(R.string.error_tarifa)
            formularioValido = false
        }

        if(!formularioValido || potencia == null || horas == null || tarifa == null) {
            return
        }

        val consumo = calcularConsumo(potencia,horas)

        val costo = calcularCostoMensual(consumo,tarifa)

        if(!consumo.isFinite() || !costo.isFinite()) {
            binding.inputLayoutTarifa.error = getString(R.string.error_calculo)
            return
        }

        val clasificacion = clasificarConsumo (consumo)


        val intent = Intent(this, ResultadoActivity::class.java).apply {
            putExtra("nombre",nombre)
            putExtra("primario", consumo)
            putExtra("secundario", costo)
            putExtra("clasificacion",clasificacion)
        }
        startActivity(intent)


    }

    private fun leerPotencia (valor: String): Double? {
        val normalizado = valor.trim().replace(',','.')
        val potencia = normalizado.toDoubleOrNull() ?: return null
        if(!potencia.isFinite()) return null
        return if (potencia > POTENCIA_MINIMA && potencia <= POTENCIA_MAXIMA) potencia else null
    }

    private fun leerHoras (valor: String): Double? {
        val normalizado = valor.trim().replace(',','.')
        val horas = normalizado.toDoubleOrNull() ?: return null
        if(!horas.isFinite()) return null
        return if (horas > HORAS_MINIMA && horas <= HORAS_MAXIMA) horas else null
    }

    private fun leerTarifa (valor: String): Double? {
        val normalizado = valor.trim().replace(',','.')
        val tarifa = normalizado.toDoubleOrNull() ?: return null
        if(!tarifa.isFinite()) return null
        return if (tarifa > TARIFA_MINIMA && tarifa <= TARIFA_MAXIMA) tarifa else null
    }

    private fun calcularConsumo(potencia: Double, horas: Double): Double{
        return (potencia/1000) *horas * 30

    }

    private fun calcularCostoMensual(consumo: Double, tarifa: Double): Double{
        return consumo*tarifa

    }

    private fun clasificarConsumo(consumo: Double): String{
        return when {
            consumo <= CONSUMO_BAJO -> getString(R.string.clasificacion_1)
            consumo <= CONSUMO_MODERADO -> getString(R.string.clasificacion_2)
            else -> getString(R.string.clasificacion_3)

        }
    }












        // como String; "primario" y "secundario" como Double.
        // No crear clases auxiliares ni serializar objetos.


    companion object {
        const val POTENCIA_MAXIMA = 10000.0
        const val POTENCIA_MINIMA = 0.0
        const val HORAS_MAXIMA = 24.0
        const val HORAS_MINIMA = 0.0
        const val TARIFA_MAXIMA = 10.0
        const val TARIFA_MINIMA = 0.0
        const val CONSUMO_BAJO = 100.0

        const val CONSUMO_MODERADO = 200.0



    }


}
