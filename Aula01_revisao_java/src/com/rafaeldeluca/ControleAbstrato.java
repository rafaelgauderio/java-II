package com.rafaeldeluca;

public abstract class ControleAbstrato {
	
	//Na classe abstrata pode ter métodos abstratos e posso ter métodos concretos (métodos com implementação)
	
	int x;
	int a;
	int b;
	int y;
	
	public abstract void setBotaoX();
	
	
	public int getBotaoX() {
		return this.x;
	}
	

}
