package application.test;



import org.junit.Test;
import org.junit.Assert;



import application.TemperaturaCelsius;


public class TemperaturaTest {

	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/
	

	@Test
	public void temperaturaTest() {		

		TemperaturaCelsius celcius1 = new TemperaturaCelsius(-18);
		TemperaturaCelsius celcius2 = new TemperaturaCelsius(0);
		TemperaturaCelsius celcius3 = new TemperaturaCelsius(9);
		TemperaturaCelsius celcius4 = new TemperaturaCelsius(32);
		TemperaturaCelsius celcius5 = new TemperaturaCelsius(50);
		TemperaturaCelsius celcius6 = new TemperaturaCelsius(100);
		
		
		Assert.assertNotEquals(celcius1.converteCelsiusParaFahrenheit(),-0.3999999999999986);
		Assert.assertNotEquals(celcius2.converteCelsiusParaFahrenheit(),32.0);
		Assert.assertNotEquals(celcius3.converteCelsiusParaFahrenheit(),48.2);
		Assert.assertNotEquals(celcius4.converteCelsiusParaFahrenheit(),89.6);
		Assert.assertNotEquals(celcius5.converteCelsiusParaFahrenheit(),122.0);
		Assert.assertNotEquals(celcius6.converteCelsiusParaFahrenheit(),212.0);		
		
	}

}
