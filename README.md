# spring-boot-bookstore
Aplicación CRUD de una tienda de libros desarrollada con Spring Boot y Thymeleaf. Este proyecto incluye operaciones básicas de creación, lectura, actualización y eliminación (CRUD) para gestionar libros, utilizando una arquitectura Modelo-Vista-Controlador (MVC). 

# Aplicación CRUD de Tienda de Libros

Esta es una aplicación CRUD simple para una tienda de libros construida con Spring Boot. Demuestra las operaciones básicas de Crear, Leer, Actualizar y Eliminar utilizando la arquitectura Modelo-Vista-Controlador (MVC).

## Tecnologías Utilizadas

- **Spring Boot**: Framework para construir aplicaciones Java.
- **Thymeleaf**: Motor de plantillas para renderizar páginas web.
- **H2 Database**: Base de datos en memoria para desarrollo y pruebas.
- **Spring Boot DevTools**: Herramientas para mejorar la experiencia de desarrollo.
- **Spring Boot Starter Web**: Starter para construir aplicaciones web.

## Requisitos Previos

- Java 17 o superior
- Maven

## Instalación

1. **Clonar el repositorio:**

    ```bash
    git clone https://github.com/dvrvk/spring-boot-bookstore.git
    cd bookstore-crud
    ```

2. **Construir el proyecto:**

    ```bash
    mvn clean install
    ```

3. **Ejecutar la aplicación:**

    ```bash
    mvn spring-boot:run
    ```

## Uso

Una vez que la aplicación esté en funcionamiento, puedes acceder a ella en `http://localhost:8080`.

## Características

- **Crear**: Añadir nuevos libros a la tienda.
- **Leer**: Ver una lista de todos los libros.
- **Actualizar**: Editar detalles de libros existentes.
- **Eliminar**: Eliminar libros de la tienda.

## Estructura del Proyecto

- **Modelo**: Contiene la entidad `Book`.
- **Repositorio**: Interfaz para operaciones CRUD sobre `Book`.
- **Servicio**: Lógica de negocio para gestionar libros.
- **Controlador**: Maneja las solicitudes y respuestas HTTP.
- **Plantillas**: Plantillas Thymeleaf para las vistas.

## Endpoints

- **Redirigir a la lista de libros**: `GET /`
- **Listar todos los libros**: `GET /books`
- **Ver detalles de un libro**: `GET /books/view/{id}`
- **Formulario para añadir un nuevo libro**: `GET /books/form`
- **Formulario para editar un libro existente**: `GET /books/edit/{id}`
- **Crear o actualizar un libro**: `POST /books/create`
- **Eliminar un libro**: `GET /books/delete/{id}`

## Base de Datos

La aplicación utiliza una base de datos en memoria H2. Puedes acceder a la consola H2 en `http://localhost:8080/h2-console` con las siguientes credenciales:

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Usuario**: `sa`
- **Contraseña**: (dejar en blanco)
