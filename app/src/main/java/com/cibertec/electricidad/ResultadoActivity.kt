package com.cibertec.electricidad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

//E01
import com.cibertec.electricidad.databinding.ActivityResultadoBinding

// E01: agregar el import de ViewBinding después de habilitarlo en Gradle.
class ResultadoActivity : AppCompatActivity() {
    // E01: declarar la propiedad binding para activity_resultado.xml.

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // E01: reemplazar la carga provisional por la inflación con ViewBinding.
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mostrarResultado()

        binding.buttonVolver.setOnClickListener {
            finish()
        }
    }

    private fun mostrarResultado(){
        val nombre = intent.getStringExtra("nombre") ?: getString(R.string.valor_no_disponible)
        val primario = intent.getDoubleExtra("primario",0.0)
        val secundario = intent.getDoubleExtra("secundario", 0.0)
        val clasificacion = intent.getStringExtra("clasificacion")?: getString(R.string.valor_no_disponible)

        binding.textViewNombreResultado.text = getString(R.string.resultado_nombre_formato,nombre)
        binding.textViewPrimario.text = getString(R.string.resultado_primario_formato, primario)
        binding.textViewSecundario.text = getString(R.string.resultado_secundario_formato, secundario)
        binding.textViewClasificacionResultado.text = clasificacion
    }

}



// E06: recibir "nombre" y "clasificacion" con getStringExtra.
// Recibir "primario" y "secundario" con getDoubleExtra.
// Mostrar el nombre, ambos valores y la clasificación en sus TextView.
// Conectar buttonVolver con finish() y registrar la Activity en el Manifest.