# 🚗 EcoMovil API

API REST para la plataforma de movilidad sostenible EcoMovil, desarrollada con Spring Boot 3.3.5 y Java 23.

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Tecnologías](#️-tecnologías)
- [Prerrequisitos](#-prerrequisitos)
- [Instalación](#-instalación)
- [Configuración](#️-configuración)
- [Ejecución](#-ejecución)
- [Documentación API](#-documentación-api)
- [Endpoints](#-endpoints)
- [Ejemplos de Uso](#-ejemplos-de-uso)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Troubleshooting](#-troubleshooting)

## ✨ Características

- 🔐 **Autenticación JWT** con Spring Security
- 👥 **Sistema de usuarios y roles** (ADMIN, ROLE_OWNER, ROLE_ACQUIRER)
- 🚗 **Gestión de vehículos** ecoamigables
- 📅 **Sistema de reservas** de vehículos
- 👨‍🎓 **Gestión de estudiantes** y planes
- 💬 **Sistema de foro** para la comunidad
- 📖 **Documentación automática** con Swagger/OpenAPI
- 🔄 **Hot reload** para desarrollo
- 🏗️ **Arquitectura DDD** (Domain Driven Design) con CQRS
- 🔒 **Variables de entorno** para configuración segura

## 🛠️ Tecnologías

- **Framework**: Spring Boot 3.3.5
- **Lenguaje**: Java 23
- **Base de datos**: MySQL 8.0+
- **ORM**: Spring Data JPA / Hibernate
- **Seguridad**: Spring Security + JWT
- **Documentación**: Swagger/OpenAPI 3
- **Build Tool**: Maven 3.8+

## 📋 Prerrequisitos

Antes de ejecutar la aplicación, asegúrate de tener instalado:

- ☕ **Java 23** (JDK)
- 🗄️ **MySQL Server 8.0+**
- 🔧 **Maven 3.8+** (opcional, incluye wrapper)
- 🌐 **Git** (para clonar el repositorio)

### Verificar instalaciones:

```bash
java -version    # Debería mostrar Java 23
mysql --version  # Debería mostrar MySQL 8.0+
mvn -version     # Opcional, usa ./mvnw si no tienes Maven
```

## 🚀 Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/Open-Source-SW56-Group-2-EcoMovil/Back-End-EcoMovil.git
cd Back-End-EcoMovil
```

### 2. Configurar base de datos

Crear la base de datos en MySQL:

```sql
CREATE DATABASE ecomovil;
CREATE USER 'ecomovil_user'@'localhost' IDENTIFIED BY 'ecomovil_password';
GRANT ALL PRIVILEGES ON ecomovil.* TO 'ecomovil_user'@'localhost';
FLUSH PRIVILEGES;
```

## ⚙️ Configuración

### Configuración de Base de Datos

Edita el archivo `src/main/resources/application.properties`:

```properties
# Base de datos local
spring.datasource.url=jdbc:mysql://localhost:3306/ecomovil?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD_MYSQL
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

# JWT Configuration  
authorization.jwt.secret=mySecretKey
authorization.jwt.expiration.days=7

# Application Info
spring.application.name=EcoMovil API - Development
spring.profiles.active=dev
```

### Variables de Entorno (Opcional)

Puedes usar variables de entorno en lugar de hardcodear credenciales:

```bash
export DB_HOST=localhost
export DB_PORT=3306
export DB_NAME=ecomovil
export DB_USER=root
export DB_PASSWORD=tu_password
export JWT_SECRET=mySecretKey
```

## 🏃‍♂️ Ejecución

### Opción 1: Usando Maven Wrapper (Recomendado)

```bash
# Windows
./mvnw.cmd spring-boot:run

# Linux/Mac/Git Bash
./mvnw spring-boot:run
```

### Opción 2: Usando Maven instalado

```bash
mvn spring-boot:run
```

### ✅ Verificar que funciona

Una vez iniciada la aplicación (toma ~30-60 segundos), verifica que esté funcionando:

- **API Base**: http://localhost:8080
- **Swagger UI**: **http://localhost:8080/swagger-ui/index.html** 📖
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

Deberías ver el mensaje:
```
Started EcomovilApiApplication in X.XXX seconds
```

## 📖 Documentación API

### 🎯 Swagger UI - **URL Principal**
**http://localhost:8080/swagger-ui/index.html**

La documentación interactiva incluye:
- 📋 Lista completa de endpoints
- 🧪 Pruebas en vivo de la API
- 📝 Esquemas de request/response
- 🔐 Autenticación con JWT tokens

## 🛣️ Endpoints Principales

### 🔐 Autenticación
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/v1/authentication/sign-up` | Registrar usuario |
| `POST` | `/api/v1/authentication/sign-in` | Iniciar sesión |

### 👤 Usuarios
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/v1/users` | Listar usuarios (requiere auth) |

### 🚗 Vehículos
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/v1/vehicles` | Crear vehículo |
| `GET` | `/api/v1/vehicles` | Listar vehículos |
| `GET` | `/api/v1/vehicles/{id}` | Obtener vehículo |
| `GET` | `/api/v1/vehicles/type/{type}` | Filtrar por tipo |

### 📅 Reservas
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/v1/reservations` | Crear reserva |
| `GET` | `/api/v1/reservations/all` | Listar reservas |
| `GET` | `/api/v1/reservations/id/{id}` | Obtener reserva |
| `PUT` | `/api/v1/reservations/{id}` | Actualizar reserva |
| `DELETE` | `/api/v1/reservations/{id}` | Eliminar reserva |

### 👨‍🎓 Perfiles
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/v1/profiles` | Crear perfil |
| `GET` | `/api/v1/profiles` | Listar perfiles |
| `GET` | `/api/v1/profiles/{id}` | Obtener perfil |
| `PUT` | `/api/v1/profiles/id/{id}` | Actualizar perfil |

## 🧪 Ejemplos de Uso

### 1. Registrar Usuario

```bash
curl -X POST http://localhost:8080/api/v1/authentication/sign-up \
  -H "Content-Type: application/json" \
  -d '{
    "username": "juan_doe",
    "password": "password123",
    "email": "juan@example.com"
  }'
```

**Respuesta exitosa:**
```json
{
  "id": 1,
  "username": "juan_doe",
  "email": "juan@example.com", 
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### 2. Iniciar Sesión

```bash
curl -X POST http://localhost:8080/api/v1/authentication/sign-in \
  -H "Content-Type: application/json" \
  -d '{
    "username": "juan_doe",
    "password": "password123"
  }'
```

### 3. Listar Usuarios (Requiere autenticación)

```bash
curl -X GET http://localhost:8080/api/v1/users \
  -H "Authorization: Bearer TU_JWT_TOKEN_AQUI"
```

### 4. Crear Vehículo

```bash
curl -X POST http://localhost:8080/api/v1/vehicles \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer TU_JWT_TOKEN_AQUI" \
  -d '{
    "brand": "Tesla",
    "model": "Model 3", 
    "type": "ELECTRIC",
    "licensePlate": "ABC123"
  }'
```

## 🔧 Modo de Desarrollo

### Hot Reload
La aplicación incluye **Spring Boot DevTools** para hot reload automático:

1. ✅ **Cambios en código Java** → Reinicio automático
2. ✅ **Cambios en properties** → Recarga automática  
3. ✅ **Cambios en templates** → Recarga instantánea

### Logs de Desarrollo
Para ver logs detallados durante desarrollo:

```bash
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dlogging.level.org.springframework.web=DEBUG"
```

## 📁 Estructura del Proyecto

```
src/main/java/upc/edu/ecomovil/api/
├── 🔐 iam/                     # Identity & Access Management
│   ├── domain/                 # Entidades, VOs, Comandos
│   ├── application/            # Servicios de aplicación  
│   ├── infrastructure/         # Repositorios, Configuración
│   └── interfaces/             # Controllers REST
├── 🚗 vehicles/                # Gestión de vehículos
├── 📅 reservations/            # Sistema de reservas
├── 👤 user/                    # Perfiles de usuario
├── 🎓 plan2/                   # Planes de servicio
├── 💬 forum/                   # Sistema de foro
└── 🔧 shared/                  # Código compartido
```

### Patrón DDD implementado:
- **Domain**: Entidades, Value Objects, Comandos
- **Application**: Casos de uso, Servicios
- **Infrastructure**: Persistencia, Configuración
- **Interfaces**: REST Controllers, DTOs

## 🔧 Troubleshooting

### Problemas Comunes

#### 🔴 Error: Puerto 8080 ocupado
```bash
# Verificar qué proceso usa el puerto
netstat -ano | findstr :8080

# En Windows - terminar proceso
taskkill /PID <PROCESS_ID> /F

# En Linux/Mac
lsof -ti:8080 | xargs kill -9
```

#### 🔴 Error de conexión a MySQL
```bash
# Verificar que MySQL esté ejecutándose
# Windows
net start mysql

# Linux/Mac  
sudo systemctl start mysql

# Verificar conexión
mysql -u root -p -e "SELECT 1"
```

#### 🔴 Error de compilación Java
```bash
# Verificar versión de Java
java -version

# Limpiar y recompilar
./mvnw clean compile

# Si persiste el error
./mvnw clean install -DskipTests
```

#### 🔴 Error de roles duplicados en base de datos
```sql
-- Limpiar datos y reiniciar
DELETE FROM user_roles;
DELETE FROM roles; 
DELETE FROM users;

-- Reiniciar la aplicación para que se recreen automáticamente
```

#### 🔴 Error "Non unique result exception"
```sql
-- Verificar roles duplicados
SELECT name, COUNT(*) FROM roles GROUP BY name HAVING COUNT(*) > 1;

-- Si hay duplicados, reiniciar la aplicación con ddl-auto=create-drop
```

### Logs útiles para debugging

```bash
# Ver logs detallados de Hibernate
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dlogging.level.org.hibernate.SQL=DEBUG"

# Ver logs de Spring Security
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dlogging.level.org.springframework.security=DEBUG"
```

## 🚀 Despliegue

### Build para producción
```bash
./mvnw clean package -DskipTests
```

El archivo JAR se genera en: `target/api-0.0.1-SNAPSHOT.jar`

### Ejecutar JAR
```bash
java -jar target/api-0.0.1-SNAPSHOT.jar
```

## 🧪 Testing

### Ejecutar tests
```bash
./mvnw test
```

### Coverage report
```bash
./mvnw jacoco:report
```

## 📞 Contacto y Soporte

Para reportar problemas o solicitar características:

1. 🐛 **Issues**: [Crear issue en GitHub](https://github.com/Open-Source-SW56-Group-2-EcoMovil/Back-End-EcoMovil/issues)
2. 📧 **Email**: ecomovil.support@ejemplo.com
3. 💬 **Discord**: #ecomovil-dev

---

## 🎯 Próximos Pasos

1. **🧪 Probar la API** usando [Swagger UI](http://localhost:8080/swagger-ui/index.html)
2. **🎨 Implementar frontend** para consumir la API
3. **☁️ Desplegar en la nube** (Railway, AWS, Heroku)
4. **🔄 Configurar CI/CD** para automatizar deployments

---

**¡Desarrollado con ❤️ para un futuro más sostenible!** 🌱

### Equipo EcoMovil
- Group 2 - Open Source SW56
- Universidad Peruana de Ciencias Aplicadas (UPC)
