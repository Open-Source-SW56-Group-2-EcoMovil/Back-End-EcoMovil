@echo off
REM Script para ejecutar la aplicación EcoMovil localmente en Windows

echo === Iniciando EcoMovil API en modo desarrollo ===

REM Verificar si Java está instalado
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Error: Java no está instalado o no está en el PATH
    pause
    exit /b 1
)

REM Mostrar versión de Java
echo Verificando versión de Java...
java -version

REM Verificar si Maven está disponible, si no usar el wrapper
mvn -version >nul 2>&1
if %errorlevel% equ 0 (
    echo Usando Maven del sistema
    set BUILD_COMMAND=mvn
) else (
    echo Usando Maven Wrapper
    set BUILD_COMMAND=mvnw.cmd
)

REM Limpiar y compilar el proyecto
echo Compilando el proyecto...
%BUILD_COMMAND% clean compile

if %errorlevel% neq 0 (
    echo Error: Falló la compilación del proyecto
    pause
    exit /b 1
)

REM Ejecutar la aplicación con perfil de desarrollo
echo Iniciando la aplicación...
echo La aplicación estará disponible en: http://localhost:8080
echo Swagger UI estará disponible en: http://localhost:8080/swagger-ui.html
echo.
echo Para detener la aplicación presiona Ctrl+C
echo.

%BUILD_COMMAND% spring-boot:run -Dspring-boot.run.profiles=dev

pause
