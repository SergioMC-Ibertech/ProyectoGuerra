package jdbc;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.modelo.Guerrero;
import jdbc.repositorio.GuerreroImpl;
import jdbc.repositorio.RepositorioGuerrero;
import jdbc.util.UtilsFichero;


public class Guerra {
	
	private static int GUERREROA=0;
	private static int GUERREROB=1;

	//Encargado de mostrar las trazas
	private static final Logger logger = LogManager.getLogger(Guerra.class);
		
	public static void main(String[] args) {
		logger.debug("Preparamos la guerra.");
		
		// Creamos el repositorio
		RepositorioGuerrero<Guerrero> repositorio = new GuerreroImpl();
		
		// Creamos a los guerreros
		logger.debug("Creamos a los guerrores");
		Guerrero guerreroA = new Guerrero("guerreroA", "marine", UtilsFichero.puntosAtaque(), UtilsFichero.puntosDefensa(), 100);
		Guerrero guerreroB = new Guerrero("guerreroB", "zombie", UtilsFichero.puntosAtaque(), UtilsFichero.puntosDefensa(), 100); 
		
		// Guardamos los guerreros en la base de datos
		logger.debug("Mostramos los guerreros por consola");
		List<Guerrero> guerreros = new ArrayList<Guerrero>();
		guerreros.add(guerreroA);
		guerreros.add(guerreroB);
		guerreros.forEach(guerrero -> repositorio.guardar(guerrero));
		
		// Mandamos a los guerreros a combatir
		int vidaGuerreroA = guerreros.get(GUERREROA).getPuntosVida();
		int vidaGuerreroB = guerreros.get(GUERREROB).getPuntosVida();
		int ataqueGuerreroA = guerreros.get(GUERREROA).getPuntosAtaque();
		int ataqueGuerreroB = guerreros.get(GUERREROB).getPuntosAtaque();
		int defensaGuerreroA = guerreros.get(GUERREROA).getPuntosDefensa();
		int defensaGuerreroB = guerreros.get(GUERREROB).getPuntosDefensa();
		do{
			
		}while(vidaGuerreroA <= 0 || vidaGuerreroB <= 0);
	}

}

