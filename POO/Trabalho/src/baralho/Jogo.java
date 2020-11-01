package jenni;

import java.util.Scanner;

public class Jogo {
	public static void main(String args[]) {
		int qtdTotalJogadores = 0, qtdJogadParou = 0, qtdJogJogou = 0, qtdJogJogando = 0, rodada = 1;
		int parar = 0, l = 0;		
		int maior = 0, valorEmpate = 0, jogadEmpatados = 1, Indiceganhador = -1;
		int empate[] = new int[20];
		
		Baralho ba = new Baralho();
		Scanner input = new Scanner(System.in);	
		
		//System.out.println(ba.mostrarBaralhoCompleto());		
		
		System.out.println("----------------------- BLACKJACK ---------------------");
		System.out.print("Bem-vindo, por gentileza, digite a quantidade de jogadores: ");
		qtdTotalJogadores = Integer.parseInt(input.nextLine());
		
		do {
			if(qtdTotalJogadores > 5) {
				System.out.print("O máximo de jogadores é 5. Digite novamente: ");
				qtdTotalJogadores = Integer.parseInt(input.nextLine());
			}
			
			if(qtdTotalJogadores <= 0) {			
				if(qtdTotalJogadores == 0) {
					System.out.print("É necessário pelo menos um jogador para iniciar a rodada. Digite novamente: ");
					qtdTotalJogadores = Integer.parseInt(input.nextLine());
				}
				else {
					System.out.print("Número de jogadores inválido. Digite novamente: ");
					qtdTotalJogadores = Integer.parseInt(input.nextLine());
				}
			}
		}while(qtdTotalJogadores <= 0 || qtdTotalJogadores > 5);
		
		
		Jogador j[] = new Jogador[qtdTotalJogadores+1];
		
		j[0] = new Jogador("Dealer");
		
		for(int i=1;i<=qtdTotalJogadores;i++) {
			j[i] = new Jogador("Jogador " + i);
		}
		
		System.out.println("\n\n\n-------------------------------------------------------");	
		System.out.println("                INICIANDO JOGO                         ");
		System.out.println("-------------------------------------------------------");	
		
		qtdTotalJogadores++;
		qtdJogJogando = qtdTotalJogadores;		
		
		do {
			if(j[l].isParou() == false) {
				System.out.println("\n......................... " +j[l].getNome() + ".........................");			
					
				if(l == 0) {
					//É o DEALER.
					j[l].pedirCarta(ba.pegarCarta());
					System.out.println("\nDEALER PEGOU CARTA!\n");
					System.out.println(j[0].mostrarMao(false));
					//System.out.println("\n|| Valor da mão: " + j[l].valorMao() + " ||");
							
					if(j[l].valorMao() > 21) {
						System.out.println(j[0].mostrarMao(true));
						System.out.println("\nDEALER PERDEU!");
						j[l].setParou(true);
						j[l].setPerdeu(true);
						qtdJogadParou++;
					}							
					else if(j[l].valorMao() == 21) {
						System.out.println(j[0].mostrarMao(true));
						System.out.println("\nDEALER GANHOU!");	
						j[l].setParou(true);
						Indiceganhador = l;
						qtdJogadParou++;
						parar = 1;								
						break;
					}
					else if(j[l].valorMao() > 18 && j[l].valorMao() < 21){						
						System.out.println("\nDEALER PAROU!");	
						j[l].setParou(true);
						qtdJogadParou++;
					}												
				}				
				else {			
					System.out.println("\n\t\t|| Valor da mão: " + j[l].valorMao() + " ||");
					System.out.println("\n1 - Pedir carta.");
					System.out.print("2 - Ficar.\n=> ");
					int opJogo = Integer.parseInt(input.nextLine());
					System.out.println("\n");
							
					switch(opJogo) {
						case 1:
							j[l].pedirCarta(ba.pegarCarta());
							System.out.println("====== CARTAS ======");
							System.out.println(j[l].mostrarMao(true));
							System.out.println("|| Valor da mão: " + j[l].valorMao() + " ||");
									
							if(j[l].valorMao() > 21) {
								System.out.println("\n\n" + j[l].getNome() + " PERDEU!\n");
								j[l].setParou(true);
								j[l].setPerdeu(true);
								qtdJogadParou++;
							}
							else if(j[l].valorMao() == 21) {
								System.out.println("\n\n" + j[l].getNome() + " GANHOU!\n");
								j[l].setParou(true);
								Indiceganhador = l;
								qtdJogadParou++;
								parar = 1;
								break;
							}
							break;
						case 2:
							j[l].setParou(true);
							qtdJogadParou++;
							break;				
					}
				}					
					qtdJogJogou++;
					l++;
			}
			else {
				l++;
			}
					
			if( qtdJogadParou == qtdTotalJogadores) {
				parar = 1;
				break;
			}
				
			if(qtdJogJogou == qtdJogJogando) {
				rodada++;
				l = 0;
				qtdJogJogando = qtdTotalJogadores - qtdJogadParou;
				qtdJogJogou = 0;
				System.out.println("\n-------------------------------RODADA " + rodada + "----------------------------------------");
			}				
		}while(parar != 1);	
		
		input.close();
		
		if(Indiceganhador == -1) {
			for(int k=0;k<qtdTotalJogadores;k++) {			
				int valor = j[k].valorMao();
			
				if(j[k].isPerdeu() == false) {
					if(valor > maior) {
						maior = valor;
						Indiceganhador = k;
					}
					else if(valor == maior) {
						empate[0] = Indiceganhador;	
						empate[jogadEmpatados] = k;
						jogadEmpatados++;
						valorEmpate = valor;
					}
				}
			}
		}
		
		System.out.println("\n\n......................... RESULTADO FINAL .........................");
		if(maior == valorEmpate && maior != 0) {
			
			System.out.println("\n\tHouve empate entre: \n");
			for(int i= 0;i<jogadEmpatados;i++) {
				int jogador = empate[i];
				System.out.println(j[jogador].getNome());
			}			
		}
		else if(maior != 0 || Indiceganhador != -1) {				
			System.out.println("\n\tGANHADOR: " + j[Indiceganhador].getNome()+ "\n");
			System.out.print(j[Indiceganhador].mostrarMao(true) + "  = " +j[Indiceganhador].valorMao());						
		}
		else {
			System.out.println("\n\tNÃO HOUVE GANHADOR!");
		}
	}
}
