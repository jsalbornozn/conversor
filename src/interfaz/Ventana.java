package interfaz;

import java.awt.event.ActionEvent;   
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

@SuppressWarnings("serial")

public class Ventana extends JFrame {
    
    private JPanel containerPanel;
    private InterfazMenu menu;
    private ControlInterfazConversor conversor;

    public Ventana() {
        setTitle("Conversor");
        setSize(900, 600);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 5, 5));
     
        containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.X_AXIS));

        menu = new InterfazMenu(270, getHeight());
        
        conversor = new ControlInterfazConversor(600, getHeight(), menu.getBotonConversorMoneda(), 
        		menu.getBotonConversorTemperatura(), menu.getBotonConversorDatos());

        containerPanel.add(menu.getPanel());
        containerPanel.add(conversor.getPanel());
        
        menu.getBotonSalir().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });
        
        setContentPane(containerPanel);
    }
    
    public static void main(String[] args) {
		
    	Ventana ventana = new Ventana();
    	ventana.setVisible(true);
	}
}



