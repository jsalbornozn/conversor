package logica;

import java.math.BigDecimal;   
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;

public abstract class Conversor {

	protected double valorEntrada;		
	protected String opcion1; //Origen de conversión
	protected String opcion2; // Destino de conversión
	protected double valorSalida; 
	protected String valorSalidaFormat;
	protected Map<String, Map<String, MetodoConversion>> conversion;
	
	/**
	 * Constructor de la clase Conversor
	 * @param datos Los datos obtenidos de la interfaz gráfica.
	 */
	public Conversor(String[] datos) {
		
		this.valorEntrada = (Double.parseDouble(datos[0]));
	    this.opcion1 = (datos[1]);
	    this.opcion2 = (datos[2]);
	}	
	
	
	/*
	 * Este método retorna un String con el resultado (valorSalida).
	 */
	public  String getResultado() {
		
		BigDecimal valorRedondeadoEntrada = new BigDecimal(valorEntrada);
		BigDecimal valorRedondeadoSalida = new BigDecimal(valorSalida);
		
		 String numeroString = valorRedondeadoSalida.toString();
		 
	        if (numeroString.contains("E")) {
	            DecimalFormatSymbols exponecial = new DecimalFormatSymbols();
	            exponecial.setExponentSeparator("E");
	            DecimalFormat formato = new DecimalFormat("0.00E0", exponecial);
	            valorSalidaFormat = formato.format(valorRedondeadoSalida);
	        } else {
	            DecimalFormat formato = new DecimalFormat("#.#####");
	            valorSalidaFormat = formato.format(valorRedondeadoSalida);
	        }
	        
	        return ("<html><center>" + valorRedondeadoEntrada + " " + opcion1 + "<br/> "
	        		+ valorSalidaFormat + " " + opcion2 + "</center></html>");
	}
      
	
	/** 
	 * Este método permite que cada conversor posea su implementación de conversión
	 * @param valor El valor de entrada a convertir
	 * @param opcion1 Escala origen de conversión
	 * @param opcion2 Escala destino de conversion
	 */
	public abstract void convertir(double valor, String opcion1, String opcion2);
}
