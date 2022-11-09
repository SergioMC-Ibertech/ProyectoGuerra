package jdbc.util;

public class UtilsGuerra {

	public static int puntosAtaque() {
		int ataque=0;
		ataque=(int)(Math.random()*100+1);
		return ataque;
	}
	
	public static int puntosDefensa() {
		int defensa=0;
		defensa=(int)(Math.random()*100+1);
		return defensa;
	}
	
	public static int aleatorio() {
		int aleatorio=0;
		aleatorio=(int)(Math.random()*10+1);
		return aleatorio;
	}
}
