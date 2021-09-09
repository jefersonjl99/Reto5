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
UPDATE Bicicleta
  SET fecha=2017
  WHERE nomFabricante='Cannondale';
  
UPDATE Cliente
  SET celular=3115678432
  WHERE alias='ninja';
  
DELETE FROM Compra WHERE cliente='green' and fk_Bicicleta='Trek';