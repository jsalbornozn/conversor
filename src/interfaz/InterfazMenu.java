package interfaz;

import java.awt.*;  
import javax.swing.*;
import javax.swing.border.*;

public class InterfazMenu {
	
    private JPanel panel;
    
    private JButton botonConversorMoneda;
    private JButton botonConversorTemperatura;
    private JButton botonConversorDatos;
    private JButton botonSalir;
    
    private JLabel label;
    
    private Color colorBackground = new Color(21, 71, 193);
    
    private Font font = new Font("Roboto", Font.BOLD, 18);

    public InterfazMenu(int width, int height) {
    	
        panel = new JPanel();
        panel.setBackground(colorBackground);
        panel.setPreferredSize(new Dimension(width,  height));
        
        botonConversorMoneda = new JButton();
        botonConversorTemperatura = new JButton();
        botonConversorDatos = new JButton();
        botonSalir = new JButton();
        
        setBotonMenu(botonConversorMoneda, "Conversor de moneda", width);
        setBotonMenu(botonConversorTemperatura, "Conversor de temperatura", width);
        setBotonMenu(botonConversorDatos, "Conversor de datos", width);
        setBotonMenu(botonSalir, "Salir", width);
        
        label = new JLabel("<html><center>Challenge ONE - Alura <br>Creado por Juan Albornoz<center></html>");
        label.setFont(font);
        Color color = new Color(255, 255, 255);
        label.setForeground(color);
        
        panel.add(Box.createVerticalStrut(700));
        panel.add(label);
        
    }

    public JPanel getPanel() {
        return panel;
    }
    
    public JButton getBotonConversorMoneda() {
    	return botonConversorMoneda;
    }
    
    public JButton getBotonConversorTemperatura() {
    	return botonConversorTemperatura;
    }
    
    public JButton getBotonConversorDatos() {
    	return botonConversorDatos;
    }
    
    public JButton getBotonSalir() {
    	return botonSalir;
    }

    public void setBotonMenu(JButton boton, String textoBoton, int width) {
        boton.setText(textoBoton);
        boton.setFocusable(false);
        boton.setContentAreaFilled(false);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Border bordeSuperior = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        Border bordeInferior = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
        Border bordePersonalizado = new CompoundBorder(bordeSuperior, bordeInferior);
        boton.setBorder(bordePersonalizado);
        boton.setFont(font);
        Color color = new Color(255, 255, 255);
        boton.setForeground(color);
        boton.setBackground(new Color(23, 41, 127));
        boton.setPreferredSize(new Dimension(width, 40));
        panel.add(boton);
    }
}