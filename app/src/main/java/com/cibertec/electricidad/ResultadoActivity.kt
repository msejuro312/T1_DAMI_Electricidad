package com.cibertec.electricidad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cibertec.electricidad.databinding.ActivityMainBinding
//E01
import com.cibertec.electricidad.databinding.ActivityResultadoBinding

// E01: agregar el import de ViewBinding después de habilitarlo en Gradle.
class ResultadoActivity : AppCompatActivity() {
    // E01: declarar la propiedad binding para activity_resultado.xml.

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // E01: reemplazar la carga provisional por la inflación con ViewBinding.
        setContentView(layoutInflater)



        getStringExtra(R.string.resultado_nombre_formato)
        getStringExtra(R.string.clasificacion_1)
        getStringExtra(R.string.clasificacion_2)
        getStringExtra(R.string.clasificacion_3)







        // E06: recibir "nombre" y "clasificacion" con getStringExtra.
        // Recibir "primario" y "secundario" con getDoubleExtra.
        // Mostrar el nombre, ambos valores y la clasificación en sus TextView.
        // Conectar buttonVolver con finish() y registrar la Activity en el Manifest.

    }

    private fun buttonVolver() {
        finish()
    }
}
