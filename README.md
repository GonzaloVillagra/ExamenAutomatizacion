# Examen Final - Automatización de Pruebas


# Actividad 1 - Configuraciones iniciales del proyecto

-para el control de las versiones se inicio un repositorio Git "https://github.com/GonzaloVillagra/ExamenAutomatizacion" con estrategia de ramificacion
-para las ramificaciones de utilizo GitFlow:

Ramas Creadas
    -main
    -develop
    -feature

para mantener un orden apropiado en armonia con las buenas practicas

-las dependencias pom.xl se integraron las librerias necesarias para las pruebas unitarias y pruebas de aceptacion (JUnit 5, Cucumber) respectivamente

# Actividad 2 - Implementacion y configuracion de CI Pipelines

-se creo pipeline como archivo en el directorio rapois para definir la infraestructura del pipeline como codigo
-para la pruebas se creo codigo en calculadora y calculadora test para los Test Unitarios

* CI

-se creacion etapas de build, Unit Test y por ultima Integration Tests

# Actividad 3 - implementacion y despliege 

-para las pruebas de aceptacion de implemento Cucumber con un escenario Ghenkins para simular un login
-se extendio el pipeline creado para la actividad 2 para contener las etapas: Acceptance Tests y Deploy to staging
-se creo un scrip que se ejecuta cuando falla en alguna etapa critica del despliegue, garantizando la recuperacion del sistema


