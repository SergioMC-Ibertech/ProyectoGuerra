package jdbc.repositorio;

import java.util.List;

public interface RepositorioGuerrero<T> {

	List<T> listar();
	
	void guardar(T t);
	
	int atacar(int t, int r);
	
	int defender(int t, int r);
}
