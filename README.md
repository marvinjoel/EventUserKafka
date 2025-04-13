# Event User Kafka: Plataforma de Seguimiento de Actividad de Usuario en Tiempo Real

 Event User Kafka es una solución robusta y escalable para rastrear la actividad de los usuarios en tiempo real. La arquitectura se basa en los siguientes pilares:

* **Productor de Eventos de Usuario:** Una aplicación Spring Boot encargada de generar y publicar eventos de actividad del usuario (actualmente, el registro de nuevos usuarios) en un tópico de Apache Kafka.
* **Consumidor de Eventos de Usuario:** Otra aplicación Spring Boot que escucha el tópico de Kafka, procesa los eventos de registro de usuario y los persiste de forma segura en una base de datos PostgreSQL.
* **Apache Kafka:** El corazón de la comunicación asíncrona, actuando como un bus de eventos distribuido y tolerante a fallos.
* **Seguridad:** Las contraseñas de los usuarios se encriptan utilizando Spring Security (BCrypt) antes de ser almacenadas.
* **Integridad de Datos:** Se implementa una restricción de unicidad a nivel de base de datos para garantizar que cada usuario tenga un correo electrónico único.
* **Dockerización:** El proyecto completo se puede contenerizar fácilmente utilizando Docker y Docker Compose para un despliegue sencillo y consistente en diferentes entornos.