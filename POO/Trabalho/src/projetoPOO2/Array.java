package projetoPOO2;

public class Array implements Lista{	
	Object lista[] = new Object[1];
	
	@Override
	public void alocar(Object arrayAntigo[]) {
		int indice = 0;
		this.lista = new Object[(arrayAntigo.length)+1];
		for(Object p : arrayAntigo) {
			this.lista[indice] = p;
			indice++;
		}
	}
	
	/*public void alocar(Object classe) {
		int indice = 0;
		this.lista = new Object[(this.lista.length)+1];		
			this.lista[indice] = classe;
			indice++;
	}*/
	@Override
	public void add(Object obj){	
		boolean espaco = false;
		
		for(int i=0;i<this.size();i++) {
			if(this.lista[i] == null) {
				espaco = true;
				this.lista[i] = obj;
			}
		}
		if(espaco == false) {
			this.alocar(this.lista);
			this.lista[this.size()-1] = obj;
		}
	}	
	
	
	@Override
	public void remove(Object obj) {
		
		Object aux = null;
		
		for(int i=0;i<this.size();i++) {
			if(this.lista[i] == obj) {
				this.lista[i] = null;
				
				if(i < this.size()) {
					for(int k=i+1;k<this.size();k++) {
						if(lista[k] != null) {
							aux = this.lista[k];
							lista[k-1] = aux;
							lista[k] = null;
						}
					}
				}
			}
		}
	}		
	
	@Override
	public String listar() {	
		String list = "";
		if(!this.isEmpty()) {
			for(Object p : this.lista) {
				list += p.toString() + "\n";
			}
		}		
		return list;
	}
	
	@Override
	public int size() {
		return this.lista.length;		
	}

	@Override
	public boolean isEmpty() {		
		int cheia = 0;
		for(Object p : this.lista) {
			if(p != null) {
				cheia++;
			}
		}
		if(cheia > 0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void clear() {
		for(int i=0;i<this.size();i++) {
			this.lista[i]= null;
		}
	}
}
