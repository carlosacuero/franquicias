# Franquicias API

## Descripción
API para gestionar una lista de franquicias, sucursales y productos.
Tener en cuenta la configuración de la base de datos, se creo con el nombre de dbfranquicias

## Requisitos
- Java 17
- Maven
- MySQL

## Instrucciones
1. Clonar el repositorio.
2. Configurar la base de datos en `application.properties`.
3. Ejecutar `mvn clean install`.
4. Ejecutar `java -jar target/franquicias-api.jar`.

## Docker
1. Construir la imagen: `docker build -t franquicias-api .`
2. Ejecutar el contenedor: `docker run -p 8080:8080 franquicias-api`
