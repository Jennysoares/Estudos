package jenni;

public class Jogador {
	private String nome;
	private int soma = 0, qtdCartasMao = 0;
	private boolean parou, perdeu;
	public Carta mao[] = new Carta[15];
	
	
	public Jogador(String nome) {
		this.setNome(nome);
		this.setParou(false);
		this.setPerdeu(false);
		
		for(int i=0;i<15;i++) {
			this.mao[i] = null;
		}
	}
	
	public void pedirCarta(Carta carta) {		
		mao[qtdCartasMao] = carta;	
		qtdCartasMao++;
	}
	
	public String mostrarMao(boolean mostrarPrimeira) {
		if(mostrarPrimeira == true) {
			int i = 1;
			String maoCompleta = "";	
			
			for(int cont = 0; cont <qtdCartasMao; cont++) {
				maoCompleta+= i + " - " + mao[cont].mostrarCarta() + "\n";
				i++;
			}					
			return maoCompleta;
		}
		else {
			int i = 1;
			String maoCompleta = "";
			for(int cont = 0; cont <qtdCartasMao; cont++) {
				if(i == 1) {
					maoCompleta += "Escondida\n";
				}
				else {
					maoCompleta += i + " - "  + mao[cont].mostrarCarta() + "\n";
				}				
				i++;
			}
			return maoCompleta;
		}		
	}

	
	public int valorMao() {
		soma = 0;
		int aces = 0;
		for (int cont = 0; cont <qtdCartasMao; cont++){
			switch(mao[cont].getValor()) {
				case Dois: soma += 2; break;
				case Três: soma += 3; break;
				case Quatro: soma += 4; break;
				case Cinco: soma += 5; break;
				case Seis: soma += 6; break;
				case Sete: soma += 7; break;
				case Oito: soma += 8; break;
				case Nove: soma += 9; break;
				case Dez: soma += 10; break;
				case Valete: soma += 10; break;
				case Dama: soma += 10; break;
				case Rei: soma += 10; break;
				case Ás: aces += 1; break;
				default:break;
			}
		}
		if(aces > 0) {
			if(soma > 10) {
				soma += aces * 1;
			}
			else {
				soma += 11;
			}
		}		
		return soma;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSoma() {
		return soma;
	}
	public void setSoma(int soma) {
		this.soma = soma;
	}
	public boolean isParou() {
		return parou;
	}
	public void setParou(boolean parou) {
		this.parou = parou;
	}
	public boolean isPerdeu() {
		return perdeu;
	}
	public void setPerdeu(boolean perdeu) {
		this.perdeu = perdeu;
	}
}