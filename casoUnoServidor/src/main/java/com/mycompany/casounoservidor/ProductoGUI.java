/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casounoservidor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author ✩°｡⋆⸜ 🎧✮‎‧₊˚✧
 */
public class ProductoGUI extends JFrame {
    
    private ArrayList<Producto> productos;
    
    // Componentes de la interfaz
    private JSpinner spnCodigo;
    private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JTextField txtPrecioCosto;
    private JCheckBox chkAltaPrioridad;
    private JComboBox<String> cmbCondicion;
    private JRadioButton radElectronico;
    private JRadioButton radRopa;
    private ButtonGroup grpTipoProducto;
    private JTable tblProductos;
    private DefaultTableModel modeloTabla;
    
    public ProductoGUI() {
        productos = new ArrayList<>();
        iniciarComponentes();
    }
    
    private void iniciarComponentes() {
        setTitle("Sistema de Gestión de Productos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(8, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Código
        panelFormulario.add(new JLabel("Código:"));
        spnCodigo = new JSpinner(new SpinnerNumberModel(1, 1, 9999, 1));
        panelFormulario.add(spnCodigo);
        
        // Nombre
        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);
        
        // Descripción
        panelFormulario.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextArea(3, 20);
        JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);
        panelFormulario.add(scrollDescripcion);
        
        // Precio Costo
        panelFormulario.add(new JLabel("Precio Costo:"));
        txtPrecioCosto = new JTextField();
        panelFormulario.add(txtPrecioCosto);
        
        // Alta Prioridad
        panelFormulario.add(new JLabel("Alta Prioridad:"));
        chkAltaPrioridad = new JCheckBox();
        panelFormulario.add(chkAltaPrioridad);
        
        // Condición
        panelFormulario.add(new JLabel("Condición:"));
        cmbCondicion = new JComboBox<>(new String[]{"NUEVO", "USADO", "REMANUFACTURADO"});
        panelFormulario.add(cmbCondicion);
        
        // Tipo de Producto
        panelFormulario.add(new JLabel("Tipo de Producto:"));
        JPanel panelTipo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radElectronico = new JRadioButton("Electrónico");
        radRopa = new JRadioButton("Ropa");
        grpTipoProducto = new ButtonGroup();
        grpTipoProducto.add(radElectronico);
        grpTipoProducto.add(radRopa);
        radElectronico.setSelected(true);
        panelTipo.add(radElectronico);
        panelTipo.add(radRopa);
        panelFormulario.add(panelTipo);
        
        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnAgregar = new JButton("Agregar Producto");
        JButton btnReporte = new JButton("Reporte de Productos");
        
        btnAgregar.addActionListener((ActionEvent e) -> {
            agregarProducto();
        });
        
        btnReporte.addActionListener((ActionEvent e) -> {
            generarReporte();
        });
        
        panelBotones.add(btnAgregar);
        panelBotones.add(btnReporte);
        
        // Tabla de productos
        String[] columnas = {"Código", "Nombre", "Precio Venta", "Condición", "Tipo"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tblProductos = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tblProductos);
        
        // Agregar componentes al frame
        add(panelFormulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(scrollTabla, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private void agregarProducto() {
        try {
            int codigo = (int) spnCodigo.getValue();
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            double precioCosto = Double.parseDouble(txtPrecioCosto.getText());
            boolean altaPrioridad = chkAltaPrioridad.isSelected();
            
            Prioridad condicion;
            switch(cmbCondicion.getSelectedIndex()) {
                case 0:
                    condicion = Prioridad.NUEVO;
                    break;
                case 1:
                    condicion = Prioridad.USADO;
                    break;
                case 2:
                    condicion = Prioridad.REMANUFACTURADO;
                    break;
                default:
                    condicion = Prioridad.NUEVO;
            }
            
            Producto producto;
            String tipo;
            
            if (radElectronico.isSelected()) {
                producto = new Electronico(codigo, nombre, descripcion, precioCosto, altaPrioridad, condicion);
                tipo = "Electrónico";
            } else {
                producto = new Ropa(codigo, nombre, descripcion, precioCosto, altaPrioridad, condicion);
                tipo = "Ropa";
            }
            
            productos.add(producto);
            
            // Agregar a la tabla
            Object[] fila = {
                producto.getCodigo(),
                producto.getNombre(),
                producto.getPrecioVenta(),
                producto.getCondicion().name(),
                tipo
            };
            
            modeloTabla.addRow(fila);
            
            // Limpiar campos
            spnCodigo.setValue((int)spnCodigo.getValue() + 1);
            txtNombre.setText("");
            txtDescripcion.setText("");
            txtPrecioCosto.setText("");
            chkAltaPrioridad.setSelected(false);
            cmbCondicion.setSelectedIndex(0);
            
            JOptionPane.showMessageDialog(this, "Producto agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en los datos numéricos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void generarReporte() {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay productos para generar el reporte", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        FileWriter escritor = null;
        try {
            escritor = new FileWriter("ReporteProductos.txt");
            
            double costoTotal = 0;
            double precioVentaTotal = 0;
            
            ArrayList<Producto> electronicos = new ArrayList<>();
            ArrayList<Producto> ropas = new ArrayList<>();
            
            for (Producto p : productos) {
                costoTotal += p.getPrecioCosto();
                precioVentaTotal += p.getPrecioVenta();
                
                if (p instanceof Electronico) {
                    electronicos.add(p);
                } else if (p instanceof Ropa) {
                    ropas.add(p);
                }
            }
            
            double gananciaTotal = precioVentaTotal - costoTotal;
            
            escritor.write("*** Reporte de Productos ***\n");
            escritor.write("Costo Total: " + costoTotal + "\n");
            escritor.write("Precio de Venta Total: " + precioVentaTotal + "\n");
            escritor.write("Ganancia Total: " + gananciaTotal + "\n\n");
            
            escritor.write("Productos Electronicos:\n");
            for (Producto p : electronicos) {
                escritor.write("- " + p.getCodigo() + " " + p.getNombre() + " " + 
                        p.getCondicion().name() + " " + p.getPrecioVenta() + "\n");
            }
            
            escritor.write("\nProductos Ropa:\n");
            for (Producto p : ropas) {
                escritor.write("- " + p.getCodigo() + " " + p.getNombre() + " " + 
                        p.getCondicion().name() + " " + p.getPrecioVenta() + "\n");
            }
            
            JOptionPane.showMessageDialog(this, "Reporte generado correctamente en ReporteProductos.txt", 
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (escritor != null) {
                try {
                    escritor.close();
                } catch (Exception e) {
                    // Ignorar excepción al cerrar
                }
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductoGUI().setVisible(true);
        });
    }
} 