# Contexto del proyecto

- Fecha: 2026-10-07. Carpeta: `C:\Users\ismae\Desktop\Projects\seleniumBasic`.
- No hay repositorio Git ni rama. El usuario autorizó editar esta carpeta sin tarjeta.
- Alcance: comentarios y aserciones de visibilidad en `NavigationTest.java`.

## Archivos revisados

| Archivos | Estado | Función |
| --- | --- | --- |
| `pom.xml`, `.classpath`, `.project`, `.settings/*`, `.gitignore` | Leídos | Maven/Eclipse, Java 17, dependencias y configuración. |
| `src/main/java/.../App.java` | Leído | Aplicación de ejemplo. |
| `src/test/java/.../AppTest.java` | Leído | Prueba antigua con JUnit 3. |
| `src/test/java/.../NavigationTest.java` | Leído | Pruebas de Selenium y ejemplos de AssertJ. |
| `src/test/java/resources/wallpaper.png` | Comprobado, no inspeccionado | Archivo binario usado para carga de imagen. |
| `target/*` | Excluido | Salida generada. |
| `D:\Workspace selenium\mini-web-apps\mini-web-apps\registration\{register.html,register.js,summary.html,summary.js}` | Leídos | Formulario externo, guardado en `localStorage` y resumen en otra pestaña. |

## Herramientas y flujo

- Java 17; Maven según `pom.xml`; Selenium 4.50.0; JUnit Jupiter 5.10.0; AssertJ 3.27.7; ChromeDriver local.
- Las pruebas crean `ChromeDriver` directamente. No hay Page Objects ni helpers compartidos.
- Selectores CSS/ID y aserciones AssertJ. La prueba de registro usa `Thread.sleep(3000)` antes de cambiar a la pestaña nueva y verificar elementos visibles.
- El formulario depende de scripts CDN; la imagen de prueba está dentro del proyecto. El HTML del formulario está fuera del proyecto.
- No se encontró `java` ni `mvn` en PATH, por lo que la compilación y ejecución están pendientes.

Cobertura: [coverage.md](coverage.md). Evidencia: [execution.md](execution.md).
