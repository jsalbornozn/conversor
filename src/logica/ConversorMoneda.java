package logica;

import static logica.Constantes.*;
public class ConversorMoneda extends Conversor{
	
	private String codigoMoneda; 
	private String monedaOrigen;
	private String monedaDestino;
	
	private ConexionExchageRateAPI conexion;
	
	public ConversorMoneda(String[] datos){
		
		super(datos);
		monedaOrigen = getCodigoMoneda(opcion1);
		monedaDestino = getCodigoMoneda(opcion2);
		convertir(valorEntrada, monedaOrigen, monedaDestino);
		
	}
	
	/**
	 * 
	 * @param opcion Opción seleccionada en ComboBox de interfaz gráfica
	 * @return codigoMoneda Código ISO de la moneda
	 */
	public String getCodigoMoneda(String opcion) {
		
		for(String valor : opcionesMoneda) {
			if(valor == opcion) {
				codigoMoneda = valor.substring(0, 3);
				break;
			}
		}
		return codigoMoneda;
	}

	@Override
	public void convertir(double valor, String opcion1, String opcion2) {
		conexion = new ConexionExchageRateAPI(valor, opcion1, opcion2);
		valorSalida = Double.parseDouble(conexion.getResultadoAPI());	
	}

}



