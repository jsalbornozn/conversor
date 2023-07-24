package interfaz;
 
import java.awt.Color; 
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;

public class InterfazConversor{

	private JPanel panel;
	private JPanel panelTitulo;
	private JPanel panelDatoEntrada;
	private JPanel panelComboBox;
	private JPanel panelContenedorComboBox;
	private JPanel panelBotonCoversion;
	private JPanel panelResultado;
	
	private JLabel labelTitulo;
	private JLabel labelEntradaDato;
	private JLabel labelConversion;
	private JLabel labelResultado;
	
	private JTextField textField;
	
	private JComboBox<String> comboBox1;
	private JComboBox<String> comboBox2;
	
	private JButton botonConversion;
	
	private Font fontGeneral = new Font("Roboto", Font.BOLD, 15);
	
    public InterfazConversor(int width, int height, String conversor, String[] opciones) {
    	
    	panel = new JPanel();
    	panelTitulo = new JPanel();
    	panelDatoEntrada = new JPanel();
    	panelComboBox = new JPanel();
    	panelContenedorComboBox = new JPanel();
		panelBotonCoversion = new JPanel();
		panelResultado = new JPanel();
		
		JPanel[] paneles = {panel, panelTitulo, panelDatoEntrada, panelComboBox, panelContenedorComboBox, 
							panelBotonCoversion, panelResultado};
		
		 for (JPanel panel : paneles) {
	            panel.setBackground(new Color(241, 243, 247 ));
	        }
    	
        panel.setPreferredSize(new Dimension(width, height));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        labelTitulo = new JLabel();
		labelTitulo.setText("Conversor de " + conversor);
		labelTitulo.setFont(fontGeneral);
		labelTitulo.setFont(labelTitulo.getFont().deriveFont(40f));
		labelTitulo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		panelTitulo.add(labelTitulo);

		labelEntradaDato = new JLabel("Ingrese el valor:  ");
		labelEntradaDato.setFont(fontGeneral);
		labelEntradaDato.setFont(labelEntradaDato.getFont().deriveFont(18f));
		
		textField = new JTextField();
        textField.setPreferredSize(new Dimension(150, 30));
        textField.setBackground(new Color(241, 243, 247));
        textField.setFont(fontGeneral);
        textField.setFont(textField.getFont().deriveFont(15f));
        Border bordeInferior = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
        textField.setBorder(bordeInferior);
        panelDatoEntrada.add(labelEntradaDato);
        panelDatoEntrada.add(textField);
        
        panelComboBox.setLayout(new BoxLayout (panelComboBox, BoxLayout.Y_AXIS));
        
		panelContenedorComboBox.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        
		labelConversion = new JLabel("a");
		labelConversion.setFont(fontGeneral);
		
		comboBox1 = new JComboBox<>(opciones);
		propiedadesComboBox(comboBox1);
		comboBox2 = new JComboBox<>(opciones);
		propiedadesComboBox(comboBox2);
		
		panelContenedorComboBox.add(comboBox1);
        panelContenedorComboBox.add(labelConversion);
		panelContenedorComboBox.add(comboBox2);
        panelComboBox.add(panelContenedorComboBox);
        
        botonConversion = new JButton("Convertir");
        botonConversion.setBackground(new Color(21, 71, 193));
        botonConversion.setPreferredSize(new Dimension(200, 40));
        botonConversion.setFont(fontGeneral);
        botonConversion.setFocusable(false);
       
        botonConversion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botonConversion.setForeground(Color.white);
     
		panelBotonCoversion.add(botonConversion);
        
		labelResultado = new JLabel ();
		
        labelResultado.setFont(fontGeneral);
        labelResultado.setFont(textField.getFont().deriveFont(18f));
        panelResultado.add(labelResultado);
        
        panel.add(Box.createVerticalStrut(50));
        panel.add(panelTitulo);
        panel.add(Box.createVerticalStrut(20)); 
        panel.add(panelDatoEntrada);
        panel.add(panelComboBox);
        panel.add(Box.createVerticalStrut(20)); 
        panel.add(panelBotonCoversion);
        panel.add(panelResultado);
        
	}
    
    public void propiedadesComboBox(JComboBox<String> comboBox) {
    	comboBox.setPreferredSize(new Dimension(240,30));
    	comboBox.setBackground(new Color(241, 243, 247));
        comboBox.setFont(fontGeneral);
    }
    
    public JPanel getPanel() {
    	return panel;
    }
    
    public JButton getBotonConversion() {
    	return botonConversion;
    }
    
    public String[] getDatosConversor() {
    	String[] datos = {textField.getText(), (String) comboBox1.getSelectedItem(), 
    			         (String) comboBox2.getSelectedItem()};
    	return datos;
    }
    
    
    
 
    public void setResultado(String resultado) {
    	labelResultado.setText(resultado);
    	
    }
     
}