package projetoPOO2;

public interface Lista {
	void alocar(Object arrayAntigo[]);
	void add(Object obj);
	void remove(Object obj);
	String listar();	
	int size();
	boolean isEmpty();
	void clear();
}
