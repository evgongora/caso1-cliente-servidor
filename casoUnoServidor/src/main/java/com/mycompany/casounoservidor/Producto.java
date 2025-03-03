/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casounoservidor;

/**
 *
 * @author ✩°｡⋆⸜ 🎧✮‎‧₊˚✧
 */
public abstract class Producto {
    protected int codigo;
    protected String nombre;
    protected String descripcion;
    protected double precioCosto;
    protected double precioVenta;
    protected boolean altaPrioridad;
    protected Prioridad condicion;
    
    public Producto(int codigo, String nombre, String descripcion, double precioCosto, double precioVenta, boolean altaPrioridad, Prioridad condicion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.altaPrioridad = altaPrioridad;
        this.condicion = condicion;
    }
    
    public abstract void calcularPrecioVenta();
    
    // Getters y setters
    public int getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public double getPrecioCosto() {
        return precioCosto;
    }
    
    public double getPrecioVenta() {
        return precioVenta;
    }
    
    public boolean isAltaPrioridad() {
        return altaPrioridad;
    }
    
    public Prioridad getCondicion() {
        return condicion;
    }
}
