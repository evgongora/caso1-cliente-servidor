/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casounoservidor;

/**
 *
 * @author ✩°｡⋆⸜ 🎧✮‎‧₊˚✧
 */
public class Ropa extends Producto {

    public Ropa(int codigo, String nombre, String desccripcion, double precioCosto, double precioVenta, boolean altaPrioridad) {
        super(codigo, nombre, desccripcion, precioCosto, precioVenta, altaPrioridad);
    }
    
    public void calcularPrecioVenta() {
        precioVenta = precioCosto * Prioridad.getComision();
    }
}
    
