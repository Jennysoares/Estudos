package jenni;

import java.util.Random;

public class Baralho{
	public Carta baralho[] = new Carta[52];
	protected int indiceBaralho = 0, tamanhoBaralho = 52;
	
	public Baralho() {		
		criarBaralho();
		embaralhar();
	}
	
	public void criarBaralho() {		
		for(NaipeCarta naipe : NaipeCarta.values() ) {
			for(ValorCarta valor : ValorCarta.values()) {
				baralho[indiceBaralho] = new Carta(valor, naipe);		
				indiceBaralho++;
			}
		}
	}		

	public void embaralhar() {
		Random aleatorio = new Random();
		Carta aux;
		
		for(int cont=0; cont<52;cont++) {
			int j = aleatorio.nextInt(52);
			int i = aleatorio.nextInt(52);
			
			aux = baralho[i];
			baralho[i] = baralho[j];
			baralho[j] = aux;
		}		
	}
	
	public Carta pegarCarta() {	
		tamanhoBaralho--;
		Carta pCarta = baralho[tamanhoBaralho];			
		return pCarta;
	}	
	
	
	public String mostrarBaralhoCompleto() {
		int i =1;
		String baralhoCompleto = "";
		for(Carta c : this.baralho) {
			baralhoCompleto += i + " - "  + c.mostrarCarta() + "\n";
			i++;
		}
		return baralhoCompleto;
	}
}