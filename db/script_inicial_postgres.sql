drop schema public cascade;
create schema public;

CREATE TABLE users (
	id SERIAL primary key NOT NULL,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS newsletter (
  id SERIAL PRIMARY KEY NOT NULL,
  email varchar(100) NOT NULL,
  fecha_alta date NOT NULL
);

-- Volcando estructura para tabla digitalers.categorias
CREATE TABLE IF NOT EXISTS categorias (
  id SERIAL PRIMARY KEY NOT NULL,
  descripcion varchar(45) NOT NULL,
  codigo varchar(10) NOT NULL,
  habilitada int NOT NULL
);

-- Volcando estructura para tabla digitalers.marcas
CREATE TABLE IF NOT EXISTS marcas (
  id SERIAL PRIMARY KEY NOT NULL,
  descripcion varchar(45) NOT NULL,
  codigo varchar(10) NOT NULL,
  habilitada int NOT NULL
) ;

-- Volcando estructura para tabla digitalers.cupones
CREATE TABLE IF NOT EXISTS cupones (
  id SERIAL PRIMARY KEY NOT NULL,
  nombre varchar(100) NOT NULL,
  codigo varchar(10) NOT NULL,
  fecha_vigencia_desde date NOT NULL,
  fecha_vigencia_hasta date DEFAULT NULL,
  descuento float DEFAULT 0
) ;

-- Volcando estructura para tabla digitalers.articulos
CREATE TABLE IF NOT EXISTS articulos (
  id SERIAL PRIMARY KEY NOT NULL,
  titulo varchar(100) NOT NULL,
  codigo varchar(10) NOT NULL,
  fecha_creacion date NOT NULL,
  precio float NOT NULL,
  stock int NOT NULL,
  marcas_id int NOT NULL,
  categorias_id int NOT NULL  
) ;

CREATE TABLE IF NOT EXISTS paises (
  id SERIAL PRIMARY KEY NOT NULL,
  descripcion varchar(100) NOT NULL,
  descripcion_corta varchar(6) NOT NULL,
  habilitada int NOT NULL
);

CREATE TABLE IF NOT EXISTS socios (
  id SERIAL PRIMARY KEY NOT NULL,
  nombre varchar(50) NOT NULL,
  apellido varchar(50) NOT NULL,
  email varchar(100) DEFAULT NULL,
  fecha_alta date NOT NULL,
  direccion VARCHAR(100),
  paises_id int,
  users_id int NOT NULL
) ;

CREATE TABLE IF NOT EXISTS estados_ordenes (
  id SERIAL PRIMARY KEY NOT NULL,
  descripcion varchar(45) NOT NULL,
  descripcion_corta varchar(45) DEFAULT NULL,
  estado_final int NOT NULL
) ;

CREATE TABLE IF NOT EXISTS medios_pagos (
  id SERIAL PRIMARY KEY NOT NULL,
  descripcion varchar(100) NOT NULL,
  descripcion_corta varchar(10) NOT NULL,
  codigo varchar(5) NOT NULL,
  habilitada int NOT NULL
) ;

CREATE TABLE IF NOT EXISTS ordenes (
  id SERIAL PRIMARY KEY NOT NULL,
  fecha_creacion date DEFAULT NULL,
  socios_id int DEFAULT NULL,
  estados_ordenes_id int DEFAULT NULL,
  monto_total float DEFAULT NULL,
  cupones_id int DEFAULT NULL  
) ;

CREATE TABLE IF NOT EXISTS direcciones_ordenes (
  id SERIAL PRIMARY KEY NOT NULL,
  ordenes_id int NOT NULL,
  paises_id int NOT NULL,
  direccion_envio varchar(500) NOT NULL
) ;

CREATE TABLE IF NOT EXISTS ordenes_items (
  id SERIAL PRIMARY KEY NOT NULL,
  ordenes_id int NOT NULL,
  numero_item int NOT NULL,
  cantidad int NOT NULL,
  articulos_id int NOT NULL,
  precio_unitario float NOT NULL
) ;

CREATE TABLE IF NOT EXISTS pagos_ordenes (
  id SERIAL PRIMARY KEY NOT NULL,
  ordenes_id int NOT NULL,
  medios_pagos_id int NOT NULL,
  fecha_pago date NOT NULL,
  monto float NOT NULL
) ;

CREATE TABLE IF NOT EXISTS roles (
	id SERIAL PRIMARY KEY NOT NULL,
	role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS users_roles (
	users_id INT NOT NULL,
	roles_id INT NOT NULL
);

--constraints

--ARTICULOS
ALTER TABLE ARTICULOS ADD CONSTRAINT FK_articulos_categorias FOREIGN KEY (CATEGORIAS_ID) REFERENCES CATEGORIAS(ID);
ALTER TABLE ARTICULOS ADD CONSTRAINT FK_articulos_marcas FOREIGN KEY (MARCAS_ID) REFERENCES MARCAS(ID);
ALTER TABLE ARTICULOS ADD CONSTRAINT UN_articulos_codigo unique (CODIGO);
ALTER TABLE ARTICULOS ADD CONSTRAINT CK_articulo_precio_positivo CHECK(precio >=0);
--ordenes
ALTER TABLE ORDENES ADD CONSTRAINT FK_ordenes_estados_ordenes FOREIGN KEY (ESTADOS_ORDENES_ID) REFERENCES ESTADOS_ORDENES(ID);
ALTER TABLE ORDENES ADD CONSTRAINT FK_ordenes_socios FOREIGN KEY (SOCIOS_ID) REFERENCES SOCIOS(ID);
ALTER TABLE ORDENES ADD CONSTRAINT FK_ordenes_cupones FOREIGN KEY (CUPONES_ID) REFERENCES CUPONES(ID);
--ORDENES_ITEMS
ALTER TABLE ORDENES_ITEMS ADD CONSTRAINT FK_items_ordenes_ordenes FOREIGN KEY (ordenes_id) REFERENCES ORDENES(ID);
ALTER TABLE ORDENES_ITEMS ADD CONSTRAINT FK_items_ordenes_articulos FOREIGN KEY (articulos_id) REFERENCES ARTICULOS(ID);
--PAGOS_ORDENES
ALTER TABLE PAGOS_ORDENES ADD CONSTRAINT FK_pagos_ordenes_ordenes FOREIGN KEY (ordenes_id) REFERENCES ORDENES(ID);
ALTER TABLE PAGOS_ORDENES ADD CONSTRAINT FK_pagos_ordenes_medios_pagos FOREIGN KEY (medios_pagos_id) REFERENCES MEDIOS_PAGOS(ID);
--DIRECCIONES_ORDENES
ALTER TABLE DIRECCIONES_ORDENES ADD CONSTRAINT FK_direcciones_ordenes_ordenes FOREIGN KEY (ordenes_id) REFERENCES ORDENES(ID);
ALTER TABLE DIRECCIONES_ORDENES ADD CONSTRAINT FK_direcciones_ordenes_paises FOREIGN KEY (paises_id) REFERENCES PAISES(ID);
--MARCAS
ALTER TABLE MARCAS ADD CONSTRAINT UN_marcas_codigo unique (CODIGO);
ALTER TABLE CATEGORIAS ADD CONSTRAINT UN_categorias_codigo unique (CODIGO);
--CUPONES
ALTER TABLE CUPONES ADD CONSTRAINT CHECK_DESCUENTO CHECK(DESCUENTO >= 0 AND DESCUENTO <=100);
ALTER TABLE CUPONES ADD CONSTRAINT UN_CUPON_CODIGO unique (CODIGO);
--USERS
ALTER TABLE USERS ADD CONSTRAINT UN_users_username UNIQUE (username);
--SOCIOS
ALTER TABLE SOCIOS ADD CONSTRAINT FK_socios_users FOREIGN KEY (users_id) REFERENCES USERS(ID);
--ROLES
ALTER TABLE ROLES ADD CONSTRAINT UN_ROLE UNIQUE (ROLE);
--USERS_ROLES
ALTER TABLE users_roles ADD CONSTRAINT fk_users_roles_id FOREIGN KEY (users_id) REFERENCES users(id); 
ALTER TABLE users_roles ADD CONSTRAINT fk_users_roles_r_id FOREIGN KEY (roles_id) REFERENCES roles(id);

--datos iniciales de prueba
--paises
insert into PAISES (descripcion, descripcion_corta,habilitada) values('ARGENTINA','ARG',1);
insert into PAISES (descripcion, descripcion_corta,habilitada) values('BRASIL','BRA',1);
--users
INSERT INTO USERS (username, password) values('eduit','$2y$10$pz6nmql6Sz5kOcNuSZw/reJSu1ZG1QYS8TMMRnNNZ0dO4zPARYD9m');
INSERT INTO SOCIOS (nombre,apellido,email,fecha_alta,users_id,direccion,paises_id) VALUES('carlos','lopez','email@email.com',CURRENT_DATE,(SELECT id FROM users LIMIT 1), NULL,(SELECT id FROM paises LIMIT 1));
--categorias
insert into CATEGORIAS (descripcion,codigo,habilitada) values('categoria 1', 'cat000',1);
insert into CATEGORIAS (descripcion,codigo,habilitada) values('categoria 2', 'cat001',1);
--marcas
insert into MARCAS (descripcion, codigo,habilitada) values('marca 1', 'cod000',1);
insert into MARCAS (descripcion, codigo,habilitada) values('marca 2', 'cod001',1);
--estados ordenes
insert into estados_ordenes (descripcion,descripcion_corta,estado_final) values('ESTADO CREADA','INICIAL', 0); 
insert into estados_ordenes (descripcion,descripcion_corta,estado_final) values('ESTADO FACTURADA','FACTURADA', 1);
insert into estados_ordenes (descripcion,descripcion_corta,estado_final) values('ESTADO CANCELADA','CANCELADA', 1);

--medios pagos
insert into medios_pagos (descripcion,descripcion_corta,codigo,habilitada) values('EFECTIVO CONTRAREEMBOLSO','EFE_REE','001',1);
--paises
insert into paises (descripcion, descripcion_corta,habilitada) values('ARGENTINA','ARG',1);
--roles
INSERT INTO roles(role) VALUES('ADMIN');
INSERT INTO roles(role) VALUES('USER');
INSERT INTO users_roles(USERS_ID,ROLES_ID) VALUES(1,1);








CREATE TABLE producto (
	id INT(10) NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	precio FLOAT NOT NULL,
	fecha_creacion DATE NOT NULL,
	imagen VARCHAR(100) NULL DEFAULT NULL,
	codigo VARCHAR(7) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE INDEX codigo (codigo)
)

/*crud*/
INSERT INTO producto (nombre, precio,fecha_creacion,imagen,codigo) 
VALUES('mate listo',1500, CURDATE(),'','0001')

select * FROM producto 

UPDATE producto SET precio = precio * 1.1

DELETE FROM producto WHERE id = 1












SELECT * from producto


select * FROM categorias


SELECT * FROM productos where id =  1
SELECT * FROM productos where codigo =  'CODIGO'

> GET > id como parametro
  GET > codigo como parametro


CREATE TABLE producto (
	id SERIAL NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	precio FLOAT NOT NULL,
	fecha_creacion DATE NOT NULL,
	imagen VARCHAR(100) NULL DEFAULT NULL,
	codigo VARCHAR(7) NOT NULL,
	PRIMARY KEY (id)
);
ALTER TABLE producto ADD CONSTRAINT UN_producto_codigo unique (codigo);

UPDATE PRODUCTO set nombre='cupon despedida',precio='35.0'WHERE codigo = 'null'

CREATE TABLE meli_site (
	id SERIAL PRIMARY KEY NOT NULL,
	codigo VARCHAR(4) NOT NULL,
	NAME VARCHAR(100) NOT NULL
);

ALTER TABLE meli_site ADD CONSTRAINT UN_meli_site UNIQUE (codigo);