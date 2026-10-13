# Evidencia de NavigationTest

- Fecha: 2026-10-07.
- Destino: carpeta local sin Git, autorizada por el usuario y sin tarjeta.
- Estado: **implementado, pendiente de validación**.

| Verificación | Resultado |
| --- | --- |
| Lectura de manifiesto, pruebas, configuración y HTML/JS externo | Completada. |
| Archivo `register.html`, `summary.js` e imagen de prueba | Existen. |
| Compilación y ejecución de `NavigationTest` | No ejecutadas: `java` y `mvn` no están en PATH. |

| Escenario | Aserciones | Estado |
| --- | --- | --- |
| Google | Cuerpo visible y título con `Google`. | No ejecutado. |
| Registro | Formulario, título y datos visibles; título `Resumen`; nombre y apellido enviados. | No ejecutado. |
| Ejemplos AssertJ | Valor exacto, mayúsculas/minúsculas, nulos y lista. | No ejecutado. |

Para validar en un entorno con Java, Maven y Chrome: `mvn -Dtest=NavigationTest test`. El registro también requiere el formulario externo y acceso a sus scripts CDN.
