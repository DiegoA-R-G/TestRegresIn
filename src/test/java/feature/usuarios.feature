#language:es
#encoding:UTF-8
Característica: Gestión de Usuarios

  Escenario: Crear un nuevo usuario
    Dado que el usuario se va a registrar
    Cuando se crea un usuario con los siguientes detalles:
      | name    | job |
      | morpheus  | lider   |
    Entonces el codigo de estado de la respuesta debe ser 201

  Escenario: Obtener información de usuario
    Dado que el usuario quiere obtener todos los usuarios
    Cuando se solicita la información del usuario
    Entonces el código de estado de la respuesta debe ser 200