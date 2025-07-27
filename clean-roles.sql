-- Script para limpiar roles duplicados y resetear la tabla
-- Ejecutar este script en tu gestor de base de datos MySQL

USE ecomovil_db;

-- Eliminar todas las relaciones usuario-rol
DELETE FROM user_roles;

-- Eliminar todos los roles
DELETE FROM roles;

-- Resetear el AUTO_INCREMENT
ALTER TABLE roles AUTO_INCREMENT = 1;

-- Verificar que las tablas estén vacías
SELECT COUNT(*) as total_roles FROM roles;
SELECT COUNT(*) as total_user_roles FROM user_roles;

-- Los nuevos roles se crearán automáticamente cuando inicies la aplicación:
-- 1. ADMIN
-- 2. ROLE_OWNER  
-- 3. ROLE_ACQUIRER
