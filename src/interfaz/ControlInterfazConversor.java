package interfaz;

import javax.swing.*;    
import java.awt.CardLayout; 
import logica.ControladorConversor;
import static logica.Constantes.*;

/**
 * Esta clase instancia las interfaces de los conversores utilizando CardLayout
 * La creacion de cada interfaz se hace por medio de addActionListener de los botones del menú
 * Cada instancia recibe como parametros las dimesniones del panel del conversor, el nombre del conversor
 * y las opciones de conversión
 * @author jsalb
 *
 */
public class ControlInterfazConversor{
	
    private JPanel panel;
    private CardLayout cardLayout;
   
    public ControlInterfazConversor(int width, int height, JButton buttonM, JButton buttonT, JButton buttonD) {
       
    	panel = new JPanel();
        cardLayout = new CardLayout();
        panel.setLayout(cardLayout);
        
        InterfazConversor InterfazConversorMoneda = new InterfazConversor(width, height,
        									            "Moneda", opcionesMoneda);
        
        InterfazConversor InterfazConversorTemperatura = new InterfazConversor(width, height,
				                                             "Temperatura", opcionesTemperatura);
        
        InterfazConversor InterfazConversorDatos = new InterfazConversor(width, height,
				                                       "Datos", opcionesDatos);
  
        
        panel.add(InterfazConversorMoneda.getPanel(), "Conversor Moneda"); 
        panel.add(InterfazConversorTemperatura.getPanel(), "Conversor Temperatura");
        panel.add(InterfazConversorDatos.getPanel(), "Conversor Datos");

        buttonM.addActionListener(e -> cardLayout.show(panel, "Conversor Moneda"));
        buttonT.addActionListener(e -> cardLayout.show(panel, "Conversor Temperatura"));
        buttonD.addActionListener(e -> cardLayout.show(panel, "Conversor Datos"));
        
        new ControladorConversor(InterfazConversorMoneda, InterfazConversorTemperatura, InterfazConversorDatos);
    }

    /**
     * 
     * @return panel
     */
    public JPanel getPanel() {
        return panel;
    }
      
}
