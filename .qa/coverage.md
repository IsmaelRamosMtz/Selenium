# Cobertura de NavigationTest

| Requisito | Escenario | Precondiciones | Acciones | Resultado esperado y aserción |
| --- | --- | --- | --- | --- |
| Abrir Google | `navigateToGoogle` | Chrome disponible y acceso a Google | Abrir la URL en español | El cuerpo de la página es visible (`isDisplayed`) y el título contiene `Google`. |
| Registrar datos | `fillOutRegistrationForm` | Formulario local y archivo de imagen disponibles; Chrome y scripts externos operativos | Completar campos y guardar | El formulario es visible; se abre el resumen; el encabezado y los datos de nombre y apellido son visibles; los textos contienen los valores enviados. |
| Mostrar aserciones de AssertJ | `asserJTest` | Ninguna | Evaluar valores de ejemplo | Las aserciones comprueban valores esperados, nulidad y contenido de lista. |
