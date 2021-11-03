package application;

public class ConversorTemperatura {
	
	public static double converteCelsiusParaFahrenheit(double celsius) {
		double fahrenheit = 1.8*celsius+32; 
		return fahrenheit;		
		}
	
		public static double converteFahrenheitParaCelsius(double fahrenheit) {
		double fator = 0.556;
		double celsius = fator*(fahrenheit-32); 
		return celsius;
		}

	
		
		
	

}
