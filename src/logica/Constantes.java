package logica;

/**
 * Interfaz que posee las constantes a utilizar en el proyecto
 * @author jsalb
 *
 */
public interface Constantes {

	public static final String USD = "USD - Dólar estadounidense";
	public static final String EUR = "EUR - Euro";
	public static final String GBP = "GBP - Libra estarlina";
	public static final String JPY = "JPY - Yen japonés";
	public static final String KRW = "KRW - Won surcoreano";
	public static final String COP = "COP - Peso colombiano";
	
	public static final String C = "°C - Centígrados ";
	public static final String F = "°F - Fahrenheit ";
	public static final String K = "K - Kelvin ";
	public static final String R = "°R - Rankine ";
	public static final String RE = "°Re - Réaumur ";
	
	public static final String B = "B - Byte";
	public static final String KB = "KB - Kilobyte";
	public static final String MB = "MB - Megabyte";
	public static final String GB = "GB - Gigabyte";
	public static final String TB = "TB - Terabyte";
	public static final String PB = "PB - Petabyte";
	
	public String[] opcionesMoneda = {USD, EUR, GBP, JPY, KRW, COP};
	public String[] opcionesTemperatura = {C, F, K, R, RE};
	public String[] opcionesDatos = {B, KB, MB, GB, TB, PB};
}
