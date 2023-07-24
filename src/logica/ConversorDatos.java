package logica;

import java.util.HashMap;      
import java.util.Map;


import static logica.Constantes.*;

/**
 * Esta clase permite realizar la conversion entre diferentes escalas de temperatura
 * Los resultados se almacenan en Hashmap utilizando las constantes de la interfaz Constantes para
 * realizar las comparaciones con las opciones de entrada (valorEntrada, opcion1, opcion2)
 * Se hace uso de la interfaz funcional para implemetar las operaciones de cada conversión
 * @author jsalb
 *
 */
public class ConversorDatos extends Conversor{
	
	public ConversorDatos(String[] datos) {
		super(datos);
	
		conversion = new HashMap<>();

        Map<String, MetodoConversion> conversionByte = new HashMap<>();
        conversionByte.put(KB, (valor) -> valor / 1024);
        conversionByte.put(MB, (valor) -> valor / Math.pow(1024, 2));
        conversionByte.put(GB, (valor) -> valor / Math.pow(1024, 3));
        conversionByte.put(TB, (valor) -> valor / Math.pow(1024, 4));
        conversionByte.put(PB, (valor) -> valor / Math.pow(1024, 5));
        conversion.put(B, conversionByte);
        
        Map<String, MetodoConversion> conversionKilobyte = new HashMap<>();
        conversionKilobyte.put(B, (valor) -> valor * 1024);
        conversionKilobyte.put(MB, (valor) -> valor / 1024);
        conversionKilobyte.put(GB, (valor) -> valor / Math.pow(1024, 2));
        conversionKilobyte.put(TB, (valor) -> valor / Math.pow(1024, 3));
        conversionKilobyte.put(PB, (valor) -> valor / Math.pow(1024, 4));
        conversion.put(KB, conversionKilobyte);
        
        Map<String, MetodoConversion> conversionMegabyte = new HashMap<>();
        conversionMegabyte.put(B, (valor) -> valor * Math.pow(1024, 2));
        conversionMegabyte.put(KB, (valor) -> valor * 1024);
        conversionMegabyte.put(GB, (valor) -> valor / 1024);//
        conversionMegabyte.put(TB, (valor) -> valor / Math.pow(1024, 2));
        conversionMegabyte.put(PB, (valor) -> valor / Math.pow(1024, 3));
        conversion.put(MB, conversionMegabyte);
        
        Map<String, MetodoConversion> conversionGigabyte = new HashMap<>();
        conversionGigabyte.put(B, (valor) -> valor * Math.pow(1024, 3));
        conversionGigabyte.put(KB, (valor) -> valor * Math.pow(1024, 2));
        conversionGigabyte.put(MB, (valor) -> valor * 1024);
        conversionGigabyte.put(TB, (valor) -> valor / 1024);
        conversionGigabyte.put(PB, (valor) -> valor / Math.pow(1024, 2));
        conversion.put(GB, conversionGigabyte);
        
        Map<String, MetodoConversion> conversionTerabyte = new HashMap<>();
        conversionTerabyte.put(B, (valor) -> valor * Math.pow(1024, 4));
        conversionTerabyte.put(KB, (valor) -> valor * Math.pow(1024, 3));
        conversionTerabyte.put(MB, (valor) -> valor * Math.pow(1024, 2));
        conversionTerabyte.put(GB, (valor) -> valor * 1024);
        conversionTerabyte.put(PB, (valor) -> valor / 1024);
        conversion.put(TB, conversionTerabyte);
        
        Map<String, MetodoConversion> conversionPetabyte = new HashMap<>();
        conversionPetabyte.put(B, (valor) -> valor * Math.pow(1024, 5));
        conversionPetabyte.put(KB, (valor) -> valor * Math.pow(1024, 4));
        conversionPetabyte.put(MB, (valor) -> valor * Math.pow(1024, 3));
        conversionPetabyte.put(GB, (valor) -> valor * Math.pow(1024, 2));
        conversionPetabyte.put(TB, (valor) -> valor * 1024);
        conversion.put(PB, conversionPetabyte);
        
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
