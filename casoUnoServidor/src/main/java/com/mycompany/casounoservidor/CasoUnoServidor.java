/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.casounoservidor;

import javax.swing.SwingUtilities;

/**
 *
 * @author ✩°｡⋆⸜ 🎧✮‎‧₊˚✧
 */
public class CasoUnoServidor {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductoGUI().setVisible(true);
        });
    }
}
