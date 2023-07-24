package logica;

import java.awt.event.ActionListener;  
import javax.swing.JOptionPane;
import interfaz.InterfazConversor;

/**
 * En esta clase se instancia cada conversor, asignando los datos de entrada como parámetros de contructor
 * Para instanciar al conversor se hace uso de addActionListener
 * Se obtiene el resultado de cada conversor para mostrarlo en la interfaz gráfica
 * Se tienen en cuenta excepciones para el valor de entrada como: valor nulo y valores no numéricos
 *  * @author jsalb
 *
 */
public class ControladorConversor {

	private	String[] datosConversorMoneda;
	private	String[] datosConversorTemperatura;
	private	String[] datosConversorDato;
	
	String[] datos;
	String valor;
	    
	/**
	 * 
	 * @param InterfazConversorMoneda
	 * @param InterfazConversorTemperatura
	 * @param InterfazConversorDatos
	 */
	public ControladorConversor(InterfazConversor InterfazConversorMoneda, 
		                        InterfazConversor InterfazConversorTemperatura, 
		                        InterfazConversor InterfazConversorDatos) {
		
		
	    InterfazConversorMoneda.getBotonConversion().addActionListener(excepcionValorInvalido(() -> {
	    
	        datosConversorMoneda = InterfazConversorMoneda.getDatosConversor();
	    	valor = datosConversorMoneda[0];
	    	
	    	if(Double.parseDouble(valor) > 0) {
        		ConversorMoneda conversorMoneda = new  ConversorMoneda(datosConversorMoneda);
    	        InterfazConversorMoneda.setResultado(conversorMoneda.getResultado());
        	} else {
        		InterfazConversorMoneda.setResultado("");
        		JOptionPane.showMessageDialog(null, "¡El valor de entrada no puede ser un número negativo!");	
        	}
	     
	    }));
	    
	    InterfazConversorTemperatura.getBotonConversion().addActionListener(excepcionValorInvalido(() -> {
	        
	    	datosConversorTemperatura = InterfazConversorTemperatura.getDatosConversor();
	    	ConversorTemperatura conversorTemperatura = new ConversorTemperatura(datosConversorTemperatura);
	    	InterfazConversorTemperatura.setResultado(conversorTemperatura.getResultado());
	    	
	    }));
	    
	    
	    InterfazConversorDatos.getBotonConversion().addActionListener(excepcionValorInvalido(() -> {
	    	
	    	datosConversorDato = InterfazConversorDatos.getDatosConversor();
	    	valor = datosConversorDato[0];
	    	
	    	if(Double.parseDouble(valor) >= 0) {
        		ConversorDatos conversorDatos = new ConversorDatos(datosConversorDato);
        		InterfazConversorDatos.setResultado(conversorDatos.getResultado());
        	} else {
        		JOptionPane.showMessageDialog(null, "¡El valor de entrada no puede ser un número negativo!");
        	}
	    }));
	}
	
	/**
	 * 
	 * @param action
	 * @return
	 */
	public ActionListener excepcionValorInvalido(Runnable action) {
	    return e -> {
	        try {
	            action.run();
	        } 
	        catch (NumberFormatException  ex) {
	        	JOptionPane.showMessageDialog(null, "¡Por favor ingresa un valor válido!");
	        }
	    };
	}	
}
	

	    
	    
    

