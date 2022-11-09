package jdbc.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.Guerra;
import jdbc.repositorio.GuerreroImpl;

public class UtilsFichero {
	
	private static final Logger logger = LogManager.getLogger(Guerra.class);
	private static final Logger logge = LogManager.getLogger(GuerreroImpl.class);
	public void crearArchivo(String nombre) throws IOException, SecurityException {
		
		FileOutputStream archivo;
		PrintStream p = null;
		try {
		      archivo = new FileOutputStream(nombre, false);
		      p = new PrintStream(archivo);
		      
		      p.println(logger.toString());
		      p.println(logge.toString());

		      p.flush();
		      p.close();
		      logger.info("Archivo generado con exito.");
		}catch(Exception e){

		}finally{
		      p.flush();
		      p.close();
		}
	}
}
