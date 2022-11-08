package jdbc.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.modelo.Guerrero;
import jdbc.util.ConexionBaseDeDatos;

public class GuerreroImpl implements RepositorioGuerrero<Guerrero>{
	
	private static final Logger logger = LogManager.getLogger(GuerreroImpl.class);
	private Connection getConnection() throws SQLException{
		return ConexionBaseDeDatos.getInstance();
	}

	@Override
	public List<Guerrero> listar() {
		Guerrero guerrero=null;
		logger.debug("Entrando en el listado de guerreros");
		
		List<Guerrero> guerreros = new ArrayList<>();
		
		
		try {
			Statement stmt = ConexionBaseDeDatos.getInstance().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM guerrero");
			while(rs.next()) {
				guerrero = crearGuerrero(rs);
				guerreros.add(guerrero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(guerreros.size()!=0) {
			logger.info("Encontrados "+guerreros.size()+" guerreros");
		}else {
			logger.warn("No se han encontrado guerreros");
		}
		logger.debug("Sale");
		return guerreros;
	}

	@Override
	public int atacar(int guerreroA, int guerreroB) {
		int vida=0;
		return vida;
	}

	@Override
	public int defender(int guerreroA, int guerreroB) {
		int vida=0;
		return vida;
	}	
	
	private Guerrero crearGuerrero(ResultSet rs) throws SQLException{
		Guerrero guerrero = new Guerrero();
		guerrero.setId(rs.getLong("id"));
		guerrero.setNombre(rs.getString("nombre"));
		guerrero.setTipo(rs.getString("tipo"));
		guerrero.setPuntosAtaque(rs.getInt("puntosAtaque"));
		guerrero.setPuntosDefensa(rs.getInt("puntosDefensa"));
		guerrero.setPuntosVida(rs.getInt("puntosVida"));

        return guerrero;
	}

	// Metodo para insertar guerreros en la BBDD
	public void guardar(Guerrero guerrero) {
		logger.debug("Insertando guerrero"+guerrero);
		String sql;
		sql = "INSERT INTO guerrero(nombre, tipo, puntosAtaque, puntosDefensa, puntosVida) VALUES(?,?,?,?,?)";
		try (PreparedStatement pstmt = ConexionBaseDeDatos.getInstance().prepareStatement(sql)){
			pstmt.setString(1, guerrero.getNombre());
			pstmt.setString(2, guerrero.getTipo());
			pstmt.setInt(3, guerrero.getPuntosAtaque());
			pstmt.setInt(4, guerrero.getPuntosDefensa());
			pstmt.setInt(5, guerrero.getPuntosVida());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error al insertar el guerrero"+ guerrero.getNombre());
			e.printStackTrace();
		}
		logger.debug("Finaliza insercion guerrero");
	}
	
}
