Feature: Login en la aplicacion
  Como usuario registrado
  Quiero ingresar mis credenciales
  Para acceder a mi cuenta

  @acceptance
  Scenario: Login exitoso con credenciales validas
    Given que estoy en la pagina de login
    When ingreso usuario "admin" y clave "1234"
    Then deberia ver la pagina de inicio