package com.rafaeldeluca;

public abstract class ControleAbstrato {
	
	//Na classe abstrata pode ter m�todos abstratos e posso ter m�todos concretos (m�todos com implementa��o)
	
	int x;
	int a;
	int b;
	int y;
	
	public abstract void setBotaoX();
	
	
	public int getBotaoX() {
		return this.x;
	}
	

}
