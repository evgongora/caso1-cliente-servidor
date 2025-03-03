/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.casounoservidor;

/**
 *
 * @author ✩°｡⋆⸜ 🎧✮‎‧₊˚✧
 */
public enum Prioridad {
     NUEVO(1.05), USADO(1.03), REMANUFACTURADO(1.02);

    private final double comision;

    Prioridad(double comision) {
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }
    
    // Método estático para obtener la comisión basada en el valor del enum
    public static double getComisionByName(String name) {
        try {
            return valueOf(name).getComision();
        } catch (IllegalArgumentException e) {
            return NUEVO.getComision(); // Valor por defecto
        }
    }
}

    

