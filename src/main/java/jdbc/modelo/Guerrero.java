package jdbc.modelo;

public class Guerrero {

	private long id;
	private String nombre;
	private String tipo;
	private int puntosAtaque;
	private int puntosDefensa;
	private int puntosVida;
	
	public Guerrero() {
		super();
	}

	public Guerrero(String nombre, String tipo, int puntosAtaque, int puntosDefensa, int puntosVida) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.puntosAtaque = puntosAtaque;
		this.puntosDefensa = puntosDefensa;
		this.puntosVida = puntosVida;
	}

	public Guerrero(long id, String nombre, String tipo, int puntosAtaque, int puntosDefensa, int puntosVida) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.puntosAtaque = puntosAtaque;
		this.puntosDefensa = puntosDefensa;
		this.puntosVida = puntosVida;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPuntosAtaque() {
		return puntosAtaque;
	}

	public void setPuntosAtaque(int puntosAtaque) {
		this.puntosAtaque = puntosAtaque;
	}

	public int getPuntosDefensa() {
		return puntosDefensa;
	}

	public void setPuntosDefensa(int puntosDefensa) {
		this.puntosDefensa = puntosDefensa;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	@Override
	public String toString() {
		return "Guerrero [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", puntosAtaque=" + puntosAtaque
				+ ", puntosDefensa=" + puntosDefensa + ", puntosVida=" + puntosVida + "]";
	}
	
}
