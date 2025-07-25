#!/bin/bash

# Script para ejecutar la aplicación EcoMovil localmente

echo "=== Iniciando EcoMovil API en modo desarrollo ==="

# Verificar si Java está instalado
if ! command -v java &> /dev/null; then
    echo "Error: Java no está instalado o no está en el PATH"
    exit 1
fi

# Verificar versión de Java
JAVA_VERSION=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}')
echo "Versión de Java: $JAVA_VERSION"

# Verificar si Maven está disponible, si no usar el wrapper
if command -v mvn &> /dev/null; then
    echo "Usando Maven del sistema"
    BUILD_COMMAND="mvn"
else
    echo "Usando Maven Wrapper"
    BUILD_COMMAND="./mvnw"
fi

# Limpiar y compilar el proyecto
echo "Compilando el proyecto..."
$BUILD_COMMAND clean compile

if [ $? -ne 0 ]; then
    echo "Error: Falló la compilación del proyecto"
    exit 1
fi

# Ejecutar la aplicación con perfil de desarrollo
echo "Iniciando la aplicación..."
echo "La aplicación estará disponible en: http://localhost:8080"
echo "Swagger UI estará disponible en: http://localhost:8080/swagger-ui.html"
echo ""
echo "Para detener la aplicación presiona Ctrl+C"
echo ""

$BUILD_COMMAND spring-boot:run -Dspring-boot.run.profiles=dev
