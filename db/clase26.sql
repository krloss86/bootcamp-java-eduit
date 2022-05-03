/*CREAR UNA TABLA DESDE SQL*/
/*CREAR TABLAS*/
CREATE TABLE users (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	username VARCHAR(50) NOT NULL,
	PASSWORD VARCHAR(100) NOT NULL
);

/*INSERT DE DATOS EN UNA TABLA*/
INSERT INTO users(username,PASSWORD) VALUES('eduit','eduit');

/*VER LOS REGISTROS DE UNA TABLA*/
SELECT * FROM users;

/*ver los registros, pero no todos*/
SELECT username FROM users;

INSERT INTO users(username,PASSWORD) VALUES('root','1234');
INSERT INTO users(username,PASSWORD) VALUES('admin','12345');
INSERT INTO users(username,PASSWORD) VALUES('guess','guess');

SELECT * FROM users;

/*FILTRAR DATOS DE UNA TABLA USANDO WHERE*/
SELECT * FROM users WHERE username = 'guess';

/**/
CREATE TABLE articulos (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	titulo VARCHAR(100) NOT NULL,
	codigo VARCHAR(10) NOT NULL,/*UNICO*/
	fecha_creacion DATE NOT NULL,
	precio FLOAT NOT NULL,
	stock INT NOT NULL,
	marcas_id INT NOT NULL,
	categorias_id INT NOT null
);

/*tablas MAESTROS*/
CREATE TABLE categorias (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	descripcion VARCHAR(100) NOT NULL,
	habilitada INT NOT NULL
);
CREATE TABLE marcas(
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	descripcion VARCHAR(100) NOT NULL,
	habilitada INT NOT NULL
);

/*insertar registros en marcas*/
INSERT INTO marcas(descripcion,habilitada) VALUES('nike',1);
INSERT INTO marcas(descripcion,habilitada) VALUES('adidas',1);

/*select*/
SELECT * FROM marcas;

/*INSERT INTO ARTICULOS*/
INSERT INTO articulos(TITULO,CODIGO,PRECIO,FECHA_CREACION,MARCAS_ID,CATEGORIAS_ID,STOCK)
VALUES('ZAPATILLA NIKE', '0000000001',15000,CURDATE(),1,1,10);

/*VER DATOS DE ARTICULOS*/
SELECT * FROM articulos;

INSERT INTO categorias (descripcion,habilitada) VALUES('libros',1);
SELECT * FROM categorias

/*crear una clave foranea VIA SCRIPT*/
ALTER TABLE articulos 
ADD CONSTRAINT FK_articulos_categorias 
FOREIGN KEY (categorias_id) 
REFERENCES categorias(id);

/*modificar datos de una tabla*/
/*ANTES DE EJECUTAR UN UPDATE, PRIMERO PONGAN "EL WHERE" HAGAN UN SELECT*/
SELECT * FROM articulos WHERE id = 3;

UPDATE articulos
SET titulo = 'ZAPATILLAS'
WHERE id = 3;

/*modificar mas de un campo a la vez*/
UPDATE articulos
SET titulo = 'ZAPATILLAS', stock = 5, categorias_id = 1
WHERE id = 3;

SELECT * FROM articulos;

/*ELIMINAR UN REGISTRO DE UNA TABLA*/
DELETE FROM CATEGORIAS WHERE ID=1;


/*resumen
CREACION DE TABLAS: 
	CREATE TABLE <NOMBRE> 

INSERT DE DATOS
	INSERT INTO <TABLA> (CAMPOS...) VALUES(...)

ACTUALIZACION DE REGISTROS
	UPDATE TABLA SET CAMPO1=VALOR1, CAMPOn=VALORn.... WHERE <CAMPO>=<VALOR>

ELIMINAR REGISTROS
	DELETE FROM TABLA WHERE CAMPO=VALOR

constraint
FK= CLAVE FORANEA

CARDINALIDAD
*/

/*FUNCIONES */

DELETE FROM articulos;
SELECT *FROM articulos;

/*crear tabla newsletters*/
CREATE TABLE newsletters (
	id INT AUTO_INCREMENT primary key NOT NULl,
	email VARCHAR(100) NOT NULL,
	fecha_registro DATE NOT NULL
);

