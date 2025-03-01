/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casounoservidor;

/**
 *
 * @author ✩°｡⋆⸜ 🎧✮‎‧₊˚✧
 */
public class Electronico extends Producto{

    public Electronico(int codigo, String nombre, String desccripcion, double precioCosto, double precioVenta, boolean altaPrioridad) {
        super(codigo, nombre, desccripcion, precioCosto, precioVenta, altaPrioridad);
    }
    
    public void calcularPrecioVenta(){
         precioVenta = precioCosto * 1.15;
        if (altaPrioridad) precioVenta *= 1.10;
    }

}

