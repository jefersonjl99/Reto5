/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  jefer
 * Created: Sep 8, 2021
 */
USE ecodosruedas;
SELECT nomFabricante FROM bicicleta
UNION ALL 
SELECT nomFabricante FROM motocicletaelectrica order by nomFabricante;
SELECT 'Consulta 2';
SELECT * FROM Bicicleta WHERE fecha >= 2019 ORDER BY nomFabricante;
SELECT 'Consulta 3';
SELECT nomFabricante FROM motocicletaelectrica WHERE proveedor='Auteco';
SELECT 'Consulta 4';
SELECT COALESCE (fk_Moto, fk_Bicicleta) as nombre from Compra WHERE cliente = "lucky"  ORDER BY nombre;
SELECT 'Consulta 5';
SELECT alias, nombre, apellido from Cliente, Compra WHERE alias = cliente AND fk_Bicicleta= "Yeti"  ORDER BY nombre;
SELECT 'Consulta 6';
SELECT COUNT(*) FROM Bicicleta WHERE fecha >= 2019;