package logica;

import java.io.IOException; 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Esta clase establece la conexión con la API ExchageRate para realizar las conversiones de moneda
 * @author jsalb
 */
public class ConexionExchageRateAPI {

	private String respuestaApi; //respuesta obtenida de la conexión con ExchageRate
	
	@SuppressWarnings("deprecation")
	
	/**
	 * @param valor
	 * @param monedaOrigen
	 * @param monedaDestino
	 */
	public ConexionExchageRateAPI(double valor, String monedaOrigen, String monedaDestino) {
		
		try {
			//URL 
	    	String url_str = "https://v6.exchangerate-api.com/v6/132e3d7963e958f83df4d2dd/pair/"
			+ monedaOrigen + "/" + monedaDestino + "/" + valor;

	    	// Conexión
	    	URL url = new URL(url_str);
	    	HttpURLConnection request = (HttpURLConnection) url.openConnection();
	    	request.connect();

	    	// Conversion a JSON
	    	JsonParser jp = new JsonParser();
	    	JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
	    	JsonObject jsonobj = root.getAsJsonObject();

	    	// Respuesta de conexión
	    	respuestaApi = jsonobj.get("conversion_result").getAsString();
		}
		catch(IOException ex) {
			JOptionPane.showMessageDialog(null, "Problema de conexión");
		}
	}
	
	/**
	 * @return respuestaApi 
	 */
	public String getResultadoAPI() {
		return respuestaApi;
	}
	
}
