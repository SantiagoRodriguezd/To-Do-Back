Backend de Aplicación To-Do List con Spring Boot y Maven

Este proyecto es un backend para una aplicación de lista de tareas (To-Do List) desarrollado con Java, Spring Boot y Maven. A continuación, se detalla el proceso de instalación, configuración y ejecución del proyecto.

Clonar el repositorio
Primero, clona este repositorio en tu máquina local. Abre una terminal y ejecuta:
https://github.com/SantiagoRodriguezd/To-Do-Back.git

Compilar y ejecutar el proyecto
Una vez configurada la base de datos, puedes compilar y ejecutar el proyecto con Maven.

1. Limpiar el proyecto (opcional)
Puedes ejecutar el siguiente comando para limpiar el proyecto antes de compilarlo:

mvn clean

2. Compilar el proyecto
Ejecuta el siguiente comando para compilar el proyecto:

mvn install

3. Ejecutar el proyecto
Una vez compilado, puedes ejecutar la aplicación usando el siguiente comando:

mvn spring-boot:run

Documentación de la API
La API expone los siguientes endpoints:

Autenticación de Usuarios
POST /users/login: Autentica a un usuario.
{
    "username": "user1",
    "password": "user_1"
}
o
{
    "username": "user2",
    "password": "user_2"
}
Endpoints de Tareas
GET /tasks: Obtiene todas las tareas para un usuario autenticado.
POST /tasks: Crea una nueva tarea.
{       
        "title": " Tarea nueva",
        "completed": false,
        "priority": "low",
        "userId": 3
}
PUT /tasks/{id}: Actualiza si fue completada una tarea existente.
DELETE /tasks/{id}: Elimina una tarea existente.