insert into rol_usuario(nombre) values ('ADMIN');
insert into usuario(rol_usuario_id, usuario, clave, bestado) values 
(1,'gean','$2a$10$dbAnQXcVvSdCBmAREoItCek3SPt3ey4Lz9/V3dMZ02QDS/M0QpD0q','1');

insert into motivo(nombre) values 
('Actividades de Mantenimiento'),
('Cesión en Uso'),
('Reasignación del bien'),
('Reubicación del bien'),
('Reposición por garantia'),
('Reparación y/o mantenimiento'),
('Revisión técnica del bien'),
('Préstamo Temporal'),           
('Para baja'),
('Otras actividades por especificar');

insert into origen(nombre) values
('Mayorazgo'),
('Camacho'),
('Ancón'),
('Jicamarca'),
('Arequipa'),
('Huancayo'),
('Jicamarca'),
('Estaciones a nivel nacional'),
('Otros');

insert into marca(nombre) values
('DELL'),
('HP');

insert into modelo(nombre,marca_id) values
('POWER EDGE R420',1),
('MAG 03PSU',2);

insert into puesto(nombre) values
('COORDINADOR'),
('PROGRAMADOR');

insert into personal(nombre, puesto_id) values
('GEAN BAILA',1),
('CARLOS LAURENTE',2);

insert into estado_item(nombre) values
('Disponible'),
('Prestado');