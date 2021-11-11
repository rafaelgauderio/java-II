package calculadora_grafica;

public class MetodosCalculo {

	private double num1;
	private double num2;


	public MetodosCalculo() {

	}


	public MetodosCalculo(double num1, double num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}



	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}


	public double soma() {

		return this.getNum1()+ this.getNum2();
	}

	public double sub() {

		return this.getNum1() - this.getNum2();
	}

	public double mult() {

		return this.getNum1() * this.getNum2();
	}

	public double div() {

		return this.getNum1() / this.getNum2();
	}
	


}
