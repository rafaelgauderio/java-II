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
		
		
		Assert.assertEquals(celcius1.converteCelsiusParaFahrenheit(),-0.3999999999999986,0.1);
		Assert.assertEquals(celcius2.converteCelsiusParaFahrenheit(),32.0,0.1);
		Assert.assertEquals(celcius3.converteCelsiusParaFahrenheit(),48.2,0.1);
		Assert.assertEquals(celcius4.converteCelsiusParaFahrenheit(),89.6,0.1);
		Assert.assertEquals(celcius5.converteCelsiusParaFahrenheit(),122.0,0.1);
		Assert.assertEquals(celcius6.converteCelsiusParaFahrenheit(),212.0,0.1);		
		
	}

}
