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

    public Electronico(int codigo, String nombre, String descripcion, double precioCosto, boolean altaPrioridad, Prioridad condicion) {
        super(codigo, nombre, descripcion, precioCosto, 0, altaPrioridad, condicion);
        calcularPrecioVenta();
    }
    
    @Override
    public void calcularPrecioVenta(){
         precioVenta = precioCosto * 1.15;
        if (altaPrioridad) precioVenta *= 1.10;
    }

}

