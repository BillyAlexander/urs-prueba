# *UNIDAD DEL REGISTRO SOCIAL*

Buenas tardes estimados, por favor realizar la prueba que se ha especificado en el archivo pdf que se encuentra en este repositorio.

Para subir sus ejercicios deben crear un Branch con el formato `ursdev_apellido_nombre`.

No se olviden de realizar una breve descripcion para despliegue en local. De ser posible en sintaxis Markdown.

Si tienen alguna duda o consulta con respecto al ejercicio pueden comunicarse conmigo al siguiente correo alexcordova111@gmail.com

¡Exitos!



______

# URS
## EJERCICIO DE PRUEBA 


Se construyo un aplicativo dividido en backend y frontend

- Backend Spring Framework
- Frontend HTML, JS

## Installation

BACKEND

JAVA 17
SPRINGBOOT 3.1

DESCARGARSE EL PROYECTO DE LA RAMA usrdev_villa_edwin, ejecutar los comandos

```sh
cd prueba
mvn package -Dmaven.test.skip
java -jar target/prueba-0.0.1-SNAPSHOT.jar
```
o 
```sh
cd prueba
mvn spring-boot:run
```

Verificar el despliegue en

```sh
http://localhost:8087/usr-distribution/distribution/
```
Para el frontend abrir en el navegador el archivo pruebaapp/index.html