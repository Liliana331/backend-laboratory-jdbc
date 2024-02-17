/*
Este es un script de guia para crear tablas e ingresar, modificar, eliminar registros
*/

/*
-- create esquema
CREATE DATABASE IF NOT EXISTS udemy;

-- usar esquema recien creado
USE udemy;

-- crear tabla si no existe
CREATE TABLE IF NOT EXISTS persona(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR (100),
    apellido VARCHAR (100),
    email VARCHAR (100),
    telefono INT
);

*/

-- insertar datos
/*
INSERT INTO udemy.persona (nombre, apellido, email, telefono) VALUES ("Maria", "Andrade", "maria@email.com", 123456);
INSERT INTO udemy.persona (nombre, apellido, email, telefono) VALUES ("Pedro", "Galvan", "pedro@email.com", 123456);
INSERT INTO udemy.persona (nombre, apellido, email, telefono) VALUES ("Carlos", "Ruiz", "carlos@email.com", 123456);
*/

-- actualizar campos
/*
UPDATE udemy.persona SET telefono = 987456 WHERE id = 2 ;
UPDATE udemy.persona SET telefono = 571645 WHERE id = 3 ;
*/

-- consultar estado tabla
SELECT * FROM udemy.persona;


