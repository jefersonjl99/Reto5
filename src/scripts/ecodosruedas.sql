/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  jefer
 * Created: Sep 7, 2021
 */
DROP DATABASE IF EXISTS ecodosruedas;
CREATE SCHEMA ecodosruedas;
USE ecodosruedas;

CREATE TABLE Bicicleta(
	nomFabricante VARCHAR (30) PRIMARY KEY,
    precio int,
    fecha YEAR
);
insert into Bicicleta (nomFabricante,precio,fecha)
values 
("Cannondale","1200000",2020),
("Trek", "1450000", 2019),
("Yeti", "2000000", 2020),
("Fuji", "950000", 2021),
("Bmc", "1950000", 2018);

CREATE TABLE proveedorMotor (
	nombre VARCHAR (30) PRIMARY KEY,
    direccion VARCHAR(30),
    telefono VARCHAR(10)
);  

insert into proveedorMotor (nombre,direccion,telefono)
values 
("Auteco","calle 7 No. 45-17",05713224459),
("Hitachi", "calle 19 No. 108-26", 05714223344),
("Bosch", "carrera 68 No. 26-45", 05715678798),
("Teco", "calle 77 No. 68-33", 05712213243),
("General Electric", "calle 29 No. 26-12", 05717239919);

CREATE TABLE motocicletaElectrica(
	nomFabricante VARCHAR(30) PRIMARY KEY,
    precio VARCHAR (30),
    autonomia VARCHAR(10),
    proveedor VARCHAR (30),
    FOREIGN KEY (proveedor) REFERENCES proveedorMotor(nombre)
);
insert into motocicletaElectrica (nomFabricante,precio,autonomia,proveedor)
values 
("Starker","4200000","18 horas","Auteco"),
("Lucky Lion","5600000","14 horas","Hitachi"),
("Be Electric","4600000","26 horas","Auteco"),
("Aima","8000000","36 horas","Bosch"),
("Mec de Colombia","5900000","20 horas","Teco"),
("Atom Electric","4500000","12 horas","General Electric"); 

CREATE TABLE Cliente (
	aliasName VARCHAR (20) PRIMARY KEY,
	nombre VARCHAR (40),
    apellido VARCHAR (40),
    email VARCHAR(30) null,
    celular VARCHAR(10) null, 
    contrasena VARCHAR(8) null,
    nacimiento VARCHAR(30) null
);  
insert into Cliente (aliasName,nombre,apellido,email,celular,contrasena,nacimiento)
values 
("lucky","Pedro","Perez",null,null,null,null),
("malopez","Maria","Lopez",null,null,null,null),
("diva","Ana","Diaz",null,null,null,null),
("dreamer","Luis","Rojas",null,null,null,null),
("ninja","Andres","Cruz",null,null,null,null),
("neon","Nelson","Ruiz",null,null,null,null),
("rose","Claudia","Mendez",null,null,null,null),
("green","Jorge","Rodriguez",null,null,null,null); 

CREATE TABLE Compra (
	cliente VARCHAR (20),
	fk_Bicicleta VARCHAR (30) ,
    fk_Moto VARCHAR (30) ,
    fechaConsulta DATETIME,
    FOREIGN KEY (cliente) REFERENCES Cliente(aliasName),
    FOREIGN KEY (fk_Bicicleta) REFERENCES Bicicleta(nomFabricante),
    FOREIGN KEY (fk_Moto) REFERENCES motocicletaElectrica(nomFabricante)
);  
insert into Compra (cliente,fk_Bicicleta,fk_Moto,fechaConsulta)
values 
("lucky","Cannondale",null,'2017-10-25 20:00:00'),
("lucky","Trek",null,'2019-03-15 18:30:00'),
("lucky",null,"Starker",'2019-05-20 20:30:00'),
("malopez","Cannondale",null,'2018-05-20 20:30:00'),
("malopez",null,"Starker",'2020-01-20 20:30:00'),
("diva","Yeti",null,'2019-05-20 20:30:00'),
("diva","Fuji",null,'2018-06-22 21:30:00'),
("diva",null,"Lucky Lion",'2020-03-17 15:30:20'),
("dreamer",null,"Lucky Lion",'2020-03-17 15:30:20'),
("dreamer",null,"Be Electric",'2020-04-10 18:30:20'),
("ninja",null,"Aima",'2020-02-17 20:30:20'),
("ninja",null,"Starker",'2020-02-20 16:30:20'),
("ninja",null,"Mec de Colombia",'2020-03-27 18:30:20'),
("rose",null,"Atom Electric",'2020-03-20 21:30:20'),
("green","Yeti",null,'2020-01-10 17:30:20'),
("green","Trek",null,'2020-02-15 20:30:20'),
("green","Bmc",null,'2020-03-17 18:30:20');
