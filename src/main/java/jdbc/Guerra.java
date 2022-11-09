package jdbc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.modelo.Guerrero;
import jdbc.repositorio.GuerreroImpl;
import jdbc.repositorio.RepositorioGuerrero;
import jdbc.util.UtilsFichero;
import jdbc.util.UtilsGuerra;


public class Guerra {
	
	private static int GUERREROA=0;
	private static int GUERREROB=1;

	//Encargado de mostrar las trazas
	private static final Logger logger = LogManager.getLogger(Guerra.class);
	private static final Logger log = LogManager.getLogger("./recursos/");
		
	public static void main(String[] args) {
		logger.debug("Preparamos la guerra.");
		
		// Creamos el repositorio
		RepositorioGuerrero<Guerrero> repositorio = new GuerreroImpl();
		
		// Creamos a los guerreros
		logger.debug("Creamos a los guerrores");
		Guerrero guerreroA = new Guerrero("Guillermo", "marine", UtilsGuerra.puntosAtaque(), UtilsGuerra.puntosDefensa(), 100);
		Guerrero guerreroB = new Guerrero("Sergio", "zombie", UtilsGuerra.puntosAtaque(), UtilsGuerra.puntosDefensa(), 100); 
		
		// Guardamos los guerreros en la base de datos
		logger.debug("Mostramos los guerreros por consola");
		List<Guerrero> guerreros = new ArrayList<Guerrero>();
		guerreros.add(guerreroA);
		guerreros.add(guerreroB);
		guerreros.forEach(guerrero -> repositorio.guardar(guerrero));
		
		// Mandamos a los guerreros a combatir
		logger.debug("Comienza la batalla");
		int vidaGuerreroA = guerreros.get(GUERREROA).getPuntosVida();
		int ataqueGuerreroA = guerreros.get(GUERREROA).getPuntosAtaque();
		int defensaGuerreroA = guerreros.get(GUERREROA).getPuntosDefensa();
		logger.debug("Presentamos al guerrero A "+guerreros.get(GUERREROA));
		int vidaGuerreroB = guerreros.get(GUERREROB).getPuntosVida();
		int ataqueGuerreroB = guerreros.get(GUERREROB).getPuntosAtaque();
		int defensaGuerreroB = guerreros.get(GUERREROB).getPuntosDefensa();
		logger.debug("Presentamos al guerrero B "+guerreros.get(GUERREROB));
		boolean terminado = false;
				
		while(terminado==false) {
			logger.debug("Guerrero A ataca y el Guerrero B defiende");
			int ataqueA =repositorio.atacar(ataqueGuerreroA)-repositorio.defender(defensaGuerreroB);
			if (ataqueA>0) {
				vidaGuerreroB -= ataqueA;
				if(vidaGuerreroB <= 0) {
					terminado=true;
				}
			}
			logger.debug("Guerrero B ataca y el Guerrero A defiende");
			int ataqueB = repositorio.atacar(ataqueGuerreroB)-repositorio.defender(defensaGuerreroA);
			if (ataqueB>0) {
				vidaGuerreroA -= ataqueB;
				if(vidaGuerreroA <= 0) {
					terminado=true;
				}
			}
		}
		if (vidaGuerreroA > 0 && vidaGuerreroB < 0) {
			logger.info("El guerrero A "+guerreros.get(GUERREROA).getNombre()+" ha ganado la batalla "+vidaGuerreroA);
			logger.info("El guerrero B "+guerreros.get(GUERREROA).getNombre()+" ha perdido la batalla "+vidaGuerreroB);
		}
		else if (vidaGuerreroB > 0 && vidaGuerreroA < 0) {
			logger.info("El guerrero B "+guerreros.get(GUERREROB).getNombre()+" ha ganado la batalla "+vidaGuerreroB);
			logger.info("El guerrero A "+guerreros.get(GUERREROA).getNombre()+" ha perdido la batalla "+vidaGuerreroA);
		} else {
			logger.info("Los contendientes deben seguir luchando.");
		}
		// Generamos el archivo de trazabilidad
		String trazabilidad = "./recursos/trazabilidad.txt";
		UtilsFichero fs = new UtilsFichero();
		try {
			fs.crearArchivo(trazabilidad);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("Se termino la guerra.");
	}

}

