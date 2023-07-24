package logica;

import java.util.HashMap;    
import java.util.Map;

/**
 * Esta clase permite realizar la conversion entre diferentes unidades de medidas de datos
 * Los resultados se almacenan en Hashmap utilizando las constantes de la interfaz Constantes para
 * realizar las comparaciones con las opciones de entrada (valorEntrada, opcion1, opcion2)
 * Se hace uso de la interfaz funcional para implemetar las operaciones de cada conversión
 * @author jsalb
 *
 */
import static logica.Constantes.*;
public class ConversorTemperatura extends Conversor {
	
	public ConversorTemperatura(String[] datos) {
		super(datos);
		
		conversion = new HashMap<>();

        Map<String, MetodoConversion> conversionCelsius = new HashMap<>();
        conversionCelsius.put(F, (valor) -> (valor * 1.8) + 32);
        conversionCelsius.put(K, (valor) -> valor + 273.15);
        conversionCelsius.put(R, (valor) -> (valor * 1.8) + 491.67);
        conversionCelsius.put(RE, (valor) -> valor * 0.8);
        conversion.put(C, conversionCelsius);
        
        Map<String, MetodoConversion> conversionFahrenheit = new HashMap<>();
        conversionFahrenheit.put(C, (valor) -> ((valor - 32) / 1.8));
        conversionFahrenheit.put(K, (valor) -> (((valor - 32) / 1.8) + 273.15));
        conversionFahrenheit.put(R, (valor) -> valor + 459.67);
        conversionFahrenheit.put(RE, (valor) -> (valor - 32) * 4/9);
        conversion.put(F, conversionFahrenheit);
        
        Map<String, MetodoConversion> conversionKelvin = new HashMap<>();
        conversionKelvin.put(C, (valor) -> valor - 273.15);
        conversionKelvin.put(F, (valor) -> (valor * 1.8) - 459.67 );
        conversionKelvin.put(R, (valor) -> valor * 1.8);			
        conversionKelvin.put(RE, (valor) -> (valor - 273.15) * 0.8);
        conversion.put(K, conversionKelvin);
        
        Map<String, MetodoConversion> conversionRankine = new HashMap<>();
        conversionRankine.put(C, (valor) -> (valor - 491.67) * 5/9);
        conversionRankine.put(F, (valor) -> valor - 459.67);
        conversionRankine.put(K, (valor) -> valor * 5/9);
        conversionRankine.put(RE, (valor) -> (valor - 491.67) * 4/9);
        conversion.put(R, conversionRankine);
      
        Map<String, MetodoConversion> conversionReaumur = new HashMap<>();
        conversionReaumur.put(C, (valor) -> valor * 1.25);
        conversionReaumur.put(F, (valor) -> (valor * 2.25) + 32);
        conversionReaumur.put(K, (valor) -> (valor / 0.8) + 273.15);
        conversionReaumur.put(R, (valor) -> (valor * 2.25) + 491.67);
        conversion.put(RE, conversionReaumur);
        
        try {
            convertir(valorEntrada, opcion1, opcion2);
            }
            catch(NullPointerException ex){
            	valorSalida = valorEntrada;
            }
	}
	
	@Override
	public void convertir(double valor, String escalaOrigen, String escalaDestino) {
        MetodoConversion funcionConversion = conversion.get(escalaOrigen).get(escalaDestino);
        valorSalida = funcionConversion.convertir(valor);       
	}

	
	
	
}

 