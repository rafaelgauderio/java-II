package application;

public class ProgramTemperatura {

	
	public static void main(String [] args) {
		
		
		TemperaturaCelsius celcius1 = new TemperaturaCelsius(-18);
		TemperaturaCelsius celcius2 = new TemperaturaCelsius(0);
		TemperaturaCelsius celcius3 = new TemperaturaCelsius(9);
		TemperaturaCelsius celcius4 = new TemperaturaCelsius(32);
		TemperaturaCelsius celcius5 = new TemperaturaCelsius(50);
		TemperaturaCelsius celcius6 = new TemperaturaCelsius(100);		
		
		
		System.out.println(celcius1.converteCelsiusParaFahrenheit());
		System.out.println(celcius2.converteCelsiusParaFahrenheit());
		System.out.println(celcius3.converteCelsiusParaFahrenheit());
		System.out.println(celcius4.converteCelsiusParaFahrenheit());
		System.out.println(celcius5.converteCelsiusParaFahrenheit());
		System.out.println(celcius6.converteCelsiusParaFahrenheit());
		
		
		
		System.out.println("\nClasse Conversortemperatura\nCelcius para Fahrenheit");		
		ConversorTemperatura conversor1 = new ConversorTemperatura();				
		
		System.out.println(conversor1.converteCelsiusParaFahrenheit(-18));
		System.out.println(conversor1.converteCelsiusParaFahrenheit(0));
		System.out.println(conversor1.converteCelsiusParaFahrenheit(9));
		System.out.println(conversor1.converteCelsiusParaFahrenheit(32));
		System.out.println(conversor1.converteCelsiusParaFahrenheit(50));
		System.out.println(conversor1.converteCelsiusParaFahrenheit(100));
		
		
		System.out.println("\nClasse ConversorTemperatura\nFahrenheit para Celcius");
		System.out.println(ConversorTemperatura.converteFahrenheitParaCelsius(-18));
		System.out.println(ConversorTemperatura.converteFahrenheitParaCelsius(0));
		System.out.println(ConversorTemperatura.converteFahrenheitParaCelsius(9));		
		System.out.println(ConversorTemperatura.converteFahrenheitParaCelsius(32));
		System.out.println(ConversorTemperatura.converteFahrenheitParaCelsius(50.0));
		System.out.println(ConversorTemperatura.converteFahrenheitParaCelsius(100));
	
	
				
		
	}
	
	
	
}


