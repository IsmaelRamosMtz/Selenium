# Borrador de tarjeta (sin publicar)

**Título:** Documentar NavigationTest y comprobar visibilidad en Google y el resumen de registro.

**Origen:** Petición del usuario y autorización expresa para trabajar en esta carpeta sin tarjeta ni Git.

**Objetivo:** Hacer legible `NavigationTest.java` para alguien sin experiencia con Selenium y añadir aserciones Java/AssertJ para los elementos visibles del flujo.

**Precondiciones:** Java 17, Maven, Chrome, formulario local `D:\Workspace selenium\mini-web-apps\mini-web-apps\registration\register.html`, imagen del proyecto y acceso a scripts CDN.

| Paso | Acción | Resultado esperado |
| --- | --- | --- |
| 1 | Abrir Google. | Cuerpo visible y título con `Google`. |
| 2 | Completar el formulario y guardar. | Se abre otra pestaña con título `Resumen`; nombre y apellido visibles y correctos. |
| 3 | Ejecutar los ejemplos de AssertJ. | Todas las comparaciones pasan. |

**Implementación:** `src/test/java/com/seleniumBasic/seleniumBasic/NavigationTest.java` editado. Aserciones y cobertura documentadas en `coverage.md`.

**Evidencia:** Validación pendiente; `java` y `mvn` no disponibles en PATH. Véase `execution.md`.

**Gestor, proyecto, responsable y prioridad:** Pendientes. **Estado:** borrador sin publicar.
