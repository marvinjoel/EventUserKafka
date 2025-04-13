# Event User Kafka: Plataforma de Seguimiento de Actividad de Usuario en Tiempo Real

 Event User Kafka es una solución robusta y escalable para rastrear la actividad de los usuarios en tiempo real. La arquitectura se basa en los siguientes pilares:

* **Productor de Eventos de Usuario:** Una aplicación Spring Boot encargada de generar y publicar eventos de actividad del usuario (actualmente, el registro de nuevos usuarios) en un tópico de Apache Kafka.
* **Consumidor de Eventos de Usuario:** Otra aplicación Spring Boot que escucha el tópico de Kafka, procesa los eventos de registro de usuario y los persiste de forma segura en una base de datos PostgreSQL.
* **Apache Kafka:** El corazón de la comunicación asíncrona, actuando como un bus de eventos distribuido y tolerante a fallos.
* **Seguridad:** Las contraseñas de los usuarios se encriptan utilizando Spring Security (BCrypt) antes de ser almacenadas.
* **Integridad de Datos:** Se implementa una restricción de unicidad a nivel de base de datos para garantizar que cada usuario tenga un correo electrónico único.
* **Dockerización:** El proyecto completo se puede contenerizar fácilmente utilizando Docker y Docker Compose para un despliegue sencillo y consistente en diferentes entornos.


## Instrucciones de Ejecución (Docker)

Para ejecutar el proyecto utilizando Docker, asegúrate de tener Docker y Docker Compose instalados en tu sistema.

1.  **Clona el repositorio del proyecto (si aún no lo has hecho).**
2.  **Navega al directorio raíz del proyecto** donde se encuentra el archivo `docker-compose.yml`.
3.  **Ejecuta el siguiente comando para construir las imágenes y levantar los contenedores en segundo plano:**

    ```bash
    docker-compose up -d
    ```

    Este comando construirá las imágenes Docker para el productor, el consumidor, Kafka, Zookeeper y Kafdrop (si lo incluiste) y los ejecutará en contenedores separados.

4.  **Opcional: Para ver los logs de los contenedores, puedes usar el siguiente comando (reemplaza `<nombre_del_servicio>` con `user-activity-producer` o `user-activity-consumer`):**

    ```bash
    docker logs -f <nombre_del_servicio>
    ```

5.  **Una vez que los contenedores estén en funcionamiento, podrás interactuar con las aplicaciones:**
    * El **productor** estará accesible en `http://localhost:${SPRING_PRODUCER_PORT}` (por defecto, `http://localhost:8000`).
    * El **consumidor** estará escuchando los eventos de Kafka y guardando los datos en la base de datos PostgreSQL configurada.
    * **Kafdrop** (si está incluido) estará accesible en `http://localhost:19000` para monitorizar Kafka.

6.  **Para detener los contenedores, ejecuta el siguiente comando en el mismo directorio:**

    ```bash
    docker-compose down
    ```