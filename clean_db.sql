-- Script para limpiar roles duplicados
USE ecomovil;

-- Desactivar foreign key checks temporalmente
SET FOREIGN_KEY_CHECKS = 0;

-- Eliminar todas las relaciones usuario-rol
DELETE FROM user_roles;

-- Eliminar todos los roles
DELETE FROM roles;

-- Reactivar foreign key checks
SET FOREIGN_KEY_CHECKS = 1;

-- Verificar que no queden roles
SELECT COUNT(*) AS 'Roles_restantes' FROM roles;
