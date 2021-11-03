package application;


public class TemperaturaCelsius {

	private double celsius;
	
	
	
	public double getCelsius() {
		return celsius;
	}
	public void setCelsius(double celsius) {
		this.celsius = celsius;
		
	}
	
	public TemperaturaCelsius (double celsius) {
		this.celsius = celsius;
	}
	public double converteCelsiusParaFahrenheit() {
		double fahrenheit = 1.8*celsius+32; 
		return fahrenheit;
	}
	@Override
	public String toString() {
		return "TemperaturaCelsius [celsius=" + String.format("%.2f",celsius) + "]";
	}
	
	
	
	

}
