# Examen C — Consumo eléctrico mensual

Duración: **60 minutos**. Trabaje sobre esta carpeta. La base compila y muestra el formulario parcial; el botón no calcula ni navega.

## Componentes entregados

Catálogo de versiones y wrapper completos; Gradle, tema, colores y dimensiones configurados. Formulario con nombre, potencia del equipo y horas diarias de uso. Resultado con nombre, primer valor, clasificación y botón Volver. MainActivity y ResultadoActivity incluyen imports comunes, clase, onCreate y setContentView provisional. Kotlin conserva comentarios guía; strings.xml no tiene comentarios.

## Pendientes exactos

- E01: habilitar ViewBinding en app/build.gradle.kts y agregar sus imports, propiedades e inflación en ambas Activity; reemplazar setContentView provisional.
- E02: agregar inputLayoutTarifa con editTextTarifa antes de buttonCalcular. Usar numberDecimal, hint_tarifa y unidad_tercero.
- E03: agregar textViewSecundario entre textViewPrimario y textViewClasificacionResultado; usar los recursos indicados en el Word y crear los 9 strings de abajo.
- E04: implementar en MainActivity la lectura y validación del nombre y tres números, errores por campo y botón Calcular.
- E05: implementar ambos cálculos y clasificación con when dentro de MainActivity; se permiten funciones privadas en ella.
- E06: completar ResultadoActivity con recepción, presentación y finish() en Volver. Registrarla en AndroidManifest.xml con exported=false.

Ambas clases ya existen; no crear clases adicionales. Los detalles y la rúbrica están en el Word.

## Validación y cálculo

Nombre obligatorio después de trim. Potencia mayor que 0 y hasta 10000 W; horas diarias mayores que 0 y hasta 24; tarifa mayor que 0 y hasta S/ 10 por kWh. Rechazar vacíos, texto y valores no finitos. Limpiar errores al recalcular y no navegar con datos inválidos. Usar punto decimal; admitir coma es opcional.

Consumo mensual (kWh) = (potencia / 1000) × horas × 30. Costo mensual = consumo mensual × tarifa.

- Consumo ≤ 100 kWh → Consumo bajo
- 100 kWh < consumo ≤ 200 kWh → Consumo moderado
- Consumo > 200 kWh → Consumo alto

Calcular y clasificar sin redondear; mostrar consumo e importe con 2 decimales. Si el resultado no es finito, mostrar error_calculo y no navegar.

Enviar mediante Intent.putExtra: "nombre" (String), "primario" (consumo mensual, Double), "secundario" (costo mensual, Double) y "clasificacion" (String). Recibir con getStringExtra y getDoubleExtra. No serializar objetos ni convertir Double a String para enviarlos.

## Strings que debe crear

| Nombre | Valor |
| --- | --- |
| hint_tarifa | Tarifa por kWh |
| error_nombre | Ingrese su nombre |
| error_potencia | Ingrese una potencia mayor que 0 y hasta 10000 |
| error_horas | Ingrese horas mayores que 0 y hasta 24 |
| error_tarifa | Ingrese una tarifa mayor que 0 y hasta 10 |
| resultado_secundario_formato | Costo mensual: S/ %1$.2f |
| clasificacion_1 | Consumo bajo |
| clasificacion_2 | Consumo moderado |
| clasificacion_3 | Consumo alto |

## Verificación y entrega

Abrir esta carpeta en Android Studio y sincronizar con SDK 36 y JDK compatible con Java 17. Android Studio genera local.properties. Ejecutar ./gradlew assembleDebug. Entregar ZIP sin build, .gradle, .idea ni local.properties, con capturas del primer caso y una validación fallida.
