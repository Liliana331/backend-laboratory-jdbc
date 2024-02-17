USE udemy;

/*
-- crear tabla
CREATE TABLE IF NOT EXISTS usuario(
	id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR (100),
    contrasenia VARCHAR (100)
);

-- insertar informacion
INSERT INTO usuario (usuario, contrasenia) VALUES ("maria@email.com", "hola123");
INSERT INTO usuario (usuario, contrasenia) VALUES ("pedro@email.com", "adios321");

-- actualizar
UPDATE usuario SET usuario = "carmenj@email.com", contrasenia = "algo475" WHERE id_usuario = 0;

-- eliminar
DELETE FROM usuario WHERE id_usuario = 0;

*/

-- consultar
SELECT id_usuario, nombre, contrasenia FROM udemy.usuario;