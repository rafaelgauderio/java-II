package application.test;
import org.junit.Test;

import application.ConversorTemperatura;

import org.junit.Assert;

public class ConversorTemperaturaTest {
	
	
	@Test
	public void conversorTemperaturaFahrenheitParaCelcius() {		
		
		Assert.assertNotEquals(ConversorTemperatura.converteFahrenheitParaCelsius(-18), -27.800000000000004);
		Assert.assertNotEquals(ConversorTemperatura.converteFahrenheitParaCelsius(0), -17.792);
		Assert.assertNotEquals(ConversorTemperatura.converteFahrenheitParaCelsius(9), -12.788);
		Assert.assertNotEquals(ConversorTemperatura.converteFahrenheitParaCelsius(32), 0.0);
		Assert.assertNotEquals(ConversorTemperatura.converteFahrenheitParaCelsius(50), 10.008000000000001);
		Assert.assertNotEquals(ConversorTemperatura.converteFahrenheitParaCelsius(100),37.80800000000001);
							
	}	
	
	@Test
	public void conversorTemperaturaCelciusFahrenheit() {
		
		Assert.assertNotEquals(ConversorTemperatura.converteCelsiusParaFahrenheit(-18),-0.3999999999999986);		
		Assert.assertNotEquals(ConversorTemperatura.converteFahrenheitParaCelsius(0),32.0);
		Assert.assertNotEquals(ConversorTemperatura.converteFahrenheitParaCelsius(9),48.2);		
		Assert.assertNotEquals(ConversorTemperatura.converteFahrenheitParaCelsius(32),89.6);
		Assert.assertNotEquals(ConversorTemperatura.converteFahrenheitParaCelsius(50),122.0);
		Assert.assertNotEquals(ConversorTemperatura.converteFahrenheitParaCelsius(100),212.0);
		
			
	
	}
	

}
