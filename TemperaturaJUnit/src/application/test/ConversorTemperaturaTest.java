package application.test;
import org.junit.Test;

import application.ConversorTemperatura;

import org.junit.Assert;

public class ConversorTemperaturaTest {
	
	
	@Test
	public void conversorTemperaturaFahrenheitParaCelcius() {		
		
		Assert.assertEquals(ConversorTemperatura.converteFahrenheitParaCelsius(-18), -27.800000000000004,0.1);
		Assert.assertEquals(ConversorTemperatura.converteFahrenheitParaCelsius(0), -17.792,0.1);
		Assert.assertEquals(ConversorTemperatura.converteFahrenheitParaCelsius(9), -12.788,0.1);
		Assert.assertEquals(ConversorTemperatura.converteFahrenheitParaCelsius(32), 0.0,0.1);
		Assert.assertEquals(ConversorTemperatura.converteFahrenheitParaCelsius(50), 10.008000000000001,0.1);
		Assert.assertEquals(ConversorTemperatura.converteFahrenheitParaCelsius(100),37.80800000000001,0.1);
							
	}	
	
	@Test
	public void conversorTemperaturaCelciusFahrenheit() {
		
		Assert.assertEquals(ConversorTemperatura.converteCelsiusParaFahrenheit(-18),-0.3999999999999986,0.1);		
		Assert.assertEquals(ConversorTemperatura.converteCelsiusParaFahrenheit(0),32.0,0.1);
		Assert.assertEquals(ConversorTemperatura.converteCelsiusParaFahrenheit(9),48.2,0.1);		
		Assert.assertEquals(ConversorTemperatura.converteCelsiusParaFahrenheit(32),89.6,0.1);
		Assert.assertEquals(ConversorTemperatura.converteCelsiusParaFahrenheit(50),122.0,0.1);
		Assert.assertEquals(ConversorTemperatura.converteCelsiusParaFahrenheit(100),212.0,0.1);
		
			
	
	}
	

}
