#!/bin/bash
echo "⏳ Compilando proyectos..."
mvn clean package -DskipTests

echo "🚀 Levantando servicios con Docker Compose..."
docker-compose up --build
