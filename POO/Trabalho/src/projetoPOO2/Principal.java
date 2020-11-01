package projetoPOO2;

import java.util.Scanner;
@SuppressWarnings("unused")

public class Principal {
	public static void main(String[] args) throws Exception {	
		Pedidos totalPedidos = new Pedidos();
		Estoque produtos = new Estoque();
		Carrinho carrinho = new Carrinho();		
		Scanner input = new Scanner(System.in);
		int parar = 0;
		int cod = produtos.size();
		int op = 0;
		String pausa = null, senha = null;
		
		
		System.out.println("\n\t\t============= Bem vindo! =============");
		do{
			System.out.println("\n\n\t\t-=--=--=--=--=--=- MENU -=--=--=--=--=--=-");
			System.out.println("\t\t1 - Cadastrar Produtos");
			System.out.println("\t\t2 - Listar Produtos");
			System.out.println("\t\t3 - Adicionar produto ao carrinho");
			System.out.println("\t\t4 - Visualizar o carrinho");
			System.out.println("\t\t5 - Excluir produto do carrinho");
			System.out.println("\t\t6 - Finalizar compra");
			System.out.println("\t\t7 - Consultar pedido");
			System.out.println("\t\t8 - Listar compras realizadas");
			System.out.println("\t\t9 - Controlar estoque");
			System.out.println("\t\t0 - Sair");
			System.out.println("\t\t-=--=--=--=--=--=--=--=--=--=--=--=--=--=-");
			System.out.print("\t\t=> ");			
			op = -1;
			while(op < 0 || op > 9) {
				try {
					op = Integer.parseInt(input.nextLine());
					if(op < 0 || op > 9) {
						System.err.println("\nOpção Inválida! Digite novamente.\n");
					}
				}catch(java.lang.NumberFormatException e) {
					System.err.println("\nOpção Inválida! Digite novamente.\n");
				}
			}
			
			switch(op) {	
				case 0:
					System.out.println("Obrigado(a), volte sempre!");
					parar = 1;
					break;
					
				case 1:
					System.out.println("\n:.ATENÇÂO: Após terceira tentativa inválida será retornado ao menu!");
					int continuar;
							
					for(int i = 1; i<=3;i++) {
						System.out.print("Senha(tentativa "+ (i) +"): ");
						senha = input.nextLine();
						if(senha.equals("123")) {
							System.out.println("\n\n-=--=--=--=--=--=- CADASTRAMENTO DE PRODUTOS-=--=--=--=--=--=-");							
									
							do {
								cod++;
								System.out.print("\nQual a categoria do produto que deseja cadastrar? [Livro(1)/CD(2)/DVD(3)/Cancelar(0)]   ");
								int categ = -1;
								while(categ< 0 || categ > 3) {
									try {
										categ = Integer.parseInt(input.nextLine());
										if(categ< 0 || categ > 3) {
											System.err.println("\nOpção Inválida de categoria! Digite novamente.\n");
										}
									}catch(java.lang.NumberFormatException e) {
										System.err.println("\nOpção Inválida de categoria! Digite novamente.\n");
									}
								}
								
								if(categ == 0) {
									break;
								}
								
								System.out.print("Nome: ");
								String nomeProd = input.nextLine();	
								System.out.print("Quantidade: ");
								int qtdProd = -1;
								while(qtdProd < 1) {
									try {
										qtdProd = Integer.parseInt(input.nextLine());
										if(qtdProd < 1) {
											System.err.println("É preciso ter quantidade maior que zero para poder cadastrar! Digite novamente.");
										}
									}catch(java.lang.NumberFormatException e) {										
											System.err.println("\nValor inválido! Digite novamente.\n");
									}
								}
								double valorProd = -1;
								System.out.print("Valor: ");
								while(valorProd < 1) {
									try {
										valorProd = Double.parseDouble(input.nextLine());
										if(valorProd < 1) {
											System.err.println("O valor do produto precisa ser maior que 0! Digite novamente.");
										}
									}catch(java.lang.NumberFormatException e) {										
											System.err.println("\nValor inválido! Digite novamente.\n");
									}
								}									
								
								try {
									if(categ == 1) {
										Produto prod = new Produto(cod, nomeProd, "Livro", qtdProd, valorProd); 
										produtos.addEstoque(prod);
									}
									else if(categ == 2){
										Produto prod = new Produto(cod, nomeProd, "DVD", qtdProd, valorProd); 
										produtos.addEstoque(prod);
									}	
									else if(categ == 3){
										Produto prod = new Produto(cod, nomeProd, "CD", qtdProd, valorProd); 
										produtos.addEstoque(prod);
									}
									
									System.out.println("Produto cadastrado com sucesso!");
								}catch(ExceptionProdutoExistente pe) {
									System.err.println(pe.getMessage());
									pausa = input.nextLine();

								}
								
								System.out.print("  ==> Deseja cadastrar outro produto? Sim[1]/Não[2]  ");
								continuar = -1;
								while(continuar < 1 || continuar > 2) {
									try {
										continuar = Integer.parseInt(input.nextLine());
										if(continuar < 1 || continuar > 2) {
											System.err.println("\nOpção Inválida! Digite novamente.\n");
										}
									}catch(java.lang.NumberFormatException e) {
										System.err.println("\nOpção Inválida! Digite novamente.\n");
									}
								}
							}while(continuar != 2);
							break;					
							}
						else {
							if(i<3) {
								System.err.println("Senha inválida! Tente novamente.\n");
								pausa = input.nextLine();

							}
							else {
								System.err.println("Número de tentativas excedido!\n");
								pausa = input.nextLine();

								break;
							}
						}
					}
					break;
					
				case 2:
					System.out.println("\n\n-=--=--=--=--=--=- PRODUTOS QUE FORNECEMOS -=--=--=--=--=--=-");	
					System.out.println("\n1 - Todos produtos");
					System.out.println("2 - Por categoria");
					System.out.println("0 - Cancelar");
					System.out.print("=> ");
					
					int listagem = -1;					
					while(listagem < 0 || listagem > 2) {
						try {
							listagem = Integer.parseInt(input.nextLine());						
							if(listagem < 0 || listagem > 2) {
								System.err.println("\nOpção Inválida! Digite novamente.\n");
							}
						}catch(java.lang.NumberFormatException e) {
							System.err.println("\nOpção Inválida! Digite novamente.\n");
						}						
					}
					if(listagem == 0) {
						break;
					}
					else if(listagem == 1) {
						System.out.println(produtos.listar());
					}else {
						System.out.println("\n\n-=--=--=--=- CATEGORIAS -=--=--=--=-");	
						System.out.println("1 - Livro");
						System.out.println("2 - CD");
						System.out.println("3 - DVD");
						System.out.print("=> ");

						int categoria = 0;
						while(categoria < 1 || categoria > 3) {
							try {
								categoria = Integer.parseInt(input.nextLine());								
								if(categoria < 1 || categoria > 3) {
									System.err.println("\nOpção Inválida! Digite novamente.\n");
								}
							}catch(java.lang.NumberFormatException e) {
								System.err.println("\nOpção Inválida! Digite novamente.\n");
							}
						}
						if(categoria == 1) {
							System.out.println("\n" + produtos.listarCategoria("Livro"));
						}
						else if(categoria == 2) {
							System.out.println("\n" + produtos.listarCategoria("CD"));
						}
						else {
							System.out.println("\n" + produtos.listarCategoria("DVD"));
						}
					}
					System.out.println("\nAperte 'Enter' para retornar ao menu...");
					pausa = input.nextLine();
					break;
					
				case 3:	
					System.out.println("\n\n-=--=--=--=- PRODUTOS -=--=--=--=--=");
					System.out.println("\n1 - Todos produtos");
					System.out.println("2 - Por categoria");
					System.out.println("0 - Cancelar");
					System.out.print("=> ");

					listagem = -1;
					while(listagem < 0 || listagem > 2) {
						try {
							listagem = Integer.parseInt(input.nextLine());						
							if(listagem < 0 || listagem > 2) {
								System.err.println("\nOpção Inválida! Digite novamente.\n");
							}
						}catch(java.lang.NumberFormatException e) {
							System.err.println("\nOpção Inválida! Digite novamente.\n");
						}						
					}
					if(listagem == 0) {
						break;
					}
					else if(listagem == 1) {
						System.out.println(produtos.listar());
					}else {
						System.out.println("\n\n-=--=--=--=- CATEGORIAS -=--=--=--=-");	
						System.out.println("1 - Livro");
						System.out.println("2 - CD");
						System.out.println("3 - DVD");
						System.out.print("=> ");

						int categoria = 0;
						while(categoria < 1 || categoria > 3) {
							try {
								categoria = Integer.parseInt(input.nextLine());								
								if(categoria < 1 || categoria > 3) {
									System.err.println("\nOpção Inválida! Digite novamente.\n");
								}
							}catch(java.lang.NumberFormatException e) {
								System.err.println("\nOpção Inválida! Digite novamente.\n");
							}
						}
						if(categoria == 1) {
							System.out.println("\n" + produtos.listarCategoria("Livro"));
						}
						else if(categoria == 2) {
							System.out.println("\n" + produtos.listarCategoria("CD"));
						}
						else {
							System.out.println("\n" + produtos.listarCategoria("DVD"));
						}
					}
					
					if(!produtos.isEmpty()) {
						System.out.println("\n-=--=--=--=--=--=- ENCHENDO O CARRINHO -=--=--=--=--=--=-");
						continuar = -1;

						do {							
							System.out.println("=============================================");
							System.out.print("Digite o código do produto que deseja inserir no seu carrinho: (Cancelar[0])  ");
							int codCarrinho = -1;
							while(codCarrinho < 0) {
								try {
									codCarrinho = Integer.parseInt(input.nextLine());	
									if(codCarrinho < 0) {
										System.err.println("\nCódigo inválido, são valores maior que 0! Digite novamente.");
									}
								}catch(java.lang.NumberFormatException e) {										
									System.err.println("\nCódigo inválido! Digite novamente.\n");
								}
							}
							if(codCarrinho == 0) {
								break;
							}
							System.out.print("Digite a quantidade do produto que deseja: ");
							int qtdCarrinho = -1;
							while(qtdCarrinho < 1) {
								try {
									qtdCarrinho = Integer.parseInt(input.nextLine());
									if(qtdCarrinho < 1) {
										System.err.println("É preciso ter quantidade maior que zero para poder adicionar no carrinho! Digite novamente.");
									}
								}catch(java.lang.NumberFormatException e) {										
									System.err.println("\nValor inválido! Digite novamente.\n");
								}
							}
							 
							try {								
								carrinho.add(codCarrinho, qtdCarrinho, produtos);								
								System.out.println("Produto adicionado no carrinho!");
								
							}catch(ExceptionProdutoExistente pe) {
								System.err.println("\n" + pe.getMessage());
								
							}catch(ExceptionLimiteCarrinho lc) {
								System.err.println("\n" + lc.getMessage());
								continuar = 2;
							}catch(ExceptionProdutoEstoque pest) {
								System.err.println("\n" + pest.getMessage());
								pausa = input.nextLine();

							}
							
							if(continuar != 2) {
								continuar = -1;
								System.out.print("  ==> Deseja adicionar outro produto? Sim[1]/Não[2]  ");
								while(continuar < 1 || continuar > 2) {
									try {
										continuar = Integer.parseInt(input.nextLine());
										if(continuar < 1 || continuar > 2) {
											System.err.println("\nOpção Inválida! Digite novamente.\n");
										}
									}catch(java.lang.NumberFormatException e) {
										System.err.println("\nOpção Inválida! Digite novamente.\n");
									}
								}
							}					
							
							System.out.println("\n");
						}while(continuar != 2);
					}	
					break;
						
				case 4:
					System.out.println("\n\n-=--=--=--=--=--=- CARRINHO -=--=--=--=--=--=-");	
					System.out.println(carrinho.listar());
					if(!carrinho.isEmpty()) {
						carrinho.totalPagar();
					}
					System.out.println("\nAperte 'Enter' para retornar ao menu...");
					pausa = input.nextLine();
					break;
						
				case 5:
					
					System.out.println("\n\n-=--=--=--=--=--=- REMOÇÃO DE PRODUTOS NO CARRINHO -=--=--=--=--=--=-");
					System.out.println(carrinho.listar());
					
					if(!carrinho.isEmpty()) {
						do {
							System.out.println("=============================================");
							System.out.print("Digite o código do produto que deseja remover: (Cancelar[0])  ");		
							int codRem = -1;
							while(codRem < 0) {
								try {
									codRem = Integer.parseInt(input.nextLine());		
									if(codRem < 0) {
										System.err.println("\nCódigo inválido, são valores maior que 0! Digite novamente.");

									}
								}catch(java.lang.NumberFormatException e) {										
										System.err.println("\nCódigo inválido! Digite novamente.\n");
								}
							}
							if(codRem == 0) {
								break;
							}
							System.out.print("Digite a quantidade que deseja remover: ");
							int qtdRem =  -1;
							
							while(qtdRem < 1) {
								try {
									qtdRem = Integer.parseInt(input.nextLine());
									if(qtdRem < 1) {
										System.err.println("É preciso ter quantidade maior que zero para poder remover produtos do carrinho! Digite novamente.");
									}
								}catch(java.lang.NumberFormatException e) {										
										System.err.println("\nValor inválido! Digite novamente.\n");
								}
							}
							
							try {
								carrinho.remove(codRem,qtdRem);

							}catch(ExceptionProdutoExistente pe) {
								System.err.println(pe.getMessage());
								pausa = input.nextLine();
							}
							
							continuar = -1;
							System.out.print("\n  ==> Deseja remover outro produto? Sim[1]/Não[2]  ");
							while(continuar < 1 || continuar > 2) {
								try {
									continuar = Integer.parseInt(input.nextLine());
									if(continuar < 1 || continuar > 2) {
										System.err.println("\nOpção Inválida! Digite novamente.\n");
									}
								}catch(java.lang.NumberFormatException e) {
									System.err.println("\nOpção Inválida! Digite novamente.\n");
								}
							}
						}while(continuar != 2);						
					}						
					break;	
					
				case 6:
					System.out.println("\n\n-=--=--=--=--=--=- FINALIZAR COMPRA -=--=--=--=--=--=-");
					System.out.println(carrinho.listar());	
					if(!carrinho.isEmpty()) {
						carrinho.totalPagar();						
						System.out.println("\n=============================================");
						System.out.println("Deseja finalizar a compra? Sim[1]/Não[2]  ");
						int finalizar = 0;
						while(finalizar < 1 || finalizar > 2) {
							try {
								finalizar = Integer.parseInt(input.nextLine());
								if(finalizar < 1 || finalizar > 2) {
									System.err.println("\nOpção Inválida! Digite novamente.\n");
								}
							}catch(java.lang.NumberFormatException e) {
								System.err.println("\nOpção Inválida! Digite novamente.\n");
							}
						}
						
						if(finalizar == 1) {
							carrinho.finalizar(produtos);
							totalPedidos.add(carrinho);
							carrinho = new Carrinho();	
							break;
						}
						else {
							System.out.println("\nRetornando ao menu...");
							break;
						}
					}
					break;											
				
				case 7:
					System.out.println("\n\n-=--=--=--=--=--=- CONSULTAR PEDIDOS -=--=--=--=--=--=-");
					System.out.println("Digite o código do pedido que deseja consultar: ");
					int codPedido = 0;
					while(codPedido < 1 ) {
						try {
							codPedido = Integer.parseInt(input.nextLine());
							if(codPedido < 1 ) {
								System.err.println("\nCódigo inválido, são maiores que 0! Digite novamente.\n");
							}
						}catch(java.lang.NumberFormatException e) {
							System.err.println("\nCódigo Inválido! Digite novamente.\n");
						}
					}
					
					System.out.println("=============================================");
					totalPedidos.pedidoEspecifico(codPedido);
				break;
				
				case 8:
					System.out.println(":.ATENÇÂO: Após terceira tentativa inválida será retornado ao menu!");
						
					for(int i = 1; i<=3;i++) {
						System.out.print("Senha(tentativa "+ (i) +"): ");
						senha = input.nextLine();
						if(senha.equals("123")) {
							System.out.println("\n\n-=--=--=--=--=--=- PEDIDOS REALIZADOS -=--=--=--=--=--=-");
							System.out.println(totalPedidos.toStringPedidos());						
							break;
						}
						else {
							if(i<3) {
								System.err.println("Senha inválida! Tente novamente.\n");
								pausa = input.nextLine();

							}
							else {
								System.err.println("Número de tentativas excedido!\n");
								pausa = input.nextLine();

								break;
							}
						}
					}
					break;
					
				case 9:
					boolean concedido = false;
					System.out.println(":.ATENÇÂO: Após terceira tentativa inválida será retornado ao menu!");
					
					for(int i = 1; i<=3;i++) {
						System.out.print("Senha(tentativa "+ (i) +"): ");
						senha = input.nextLine();
						if(senha.equals("123")) {
							concedido = true;
							i=3;
						}else {
							if(i<3) {
								System.err.println("Senha inválida! Tente novamente.\n");
								pausa = input.nextLine();
							}
							else {
								System.err.println("Número de tentativas excedido!\n");
								pausa = input.nextLine();

								break;
							}
						  }
						}
					if(concedido == true) {
						int opEstoque = 0;
						
						do {
							System.out.println("\n\n-=--=--=--=--=--=- CONTROLE DE ESTOQUE -=--=--=--=--=--=-");
							System.out.println("1 - Visualizar estoque");
							System.out.println("2 - Reabastecer");
							System.out.println("3 - Remover produtos");
							System.out.println("4 - Retornar ao menu");
							
							opEstoque = 0;
							while(opEstoque < 1 || opEstoque > 4) {
								try {
									opEstoque = Integer.parseInt(input.nextLine());
									if(opEstoque < 1 || opEstoque > 4) {
										System.err.println("\nOpção Inválida! Digite novamente.\n");
									}
								}catch(java.lang.NumberFormatException e) {
									System.err.println("\nOpção Inválida! Digite novamente.\n");
								}
							}
							
							switch(opEstoque) {
							case 1:
								System.out.println("\n\n-=--=--=--=--=--=- ESTOQUE -=--=--=--=--=--=-");
								System.out.println(produtos.listarEstoque());
								System.out.println("\nAperte 'Enter' para retornar...");
								pausa = input.nextLine();	
								opEstoque = 0;
								break;
								
							case 2:
								System.out.println("\n\n-=--=--=--=--=--=- REPOSIÇÃO DE ESTOQUE -=--=--=--=--=--=-");
								System.out.println(produtos.listarEstoque());
								if(!produtos.isEmpty()) {
									int opEstoq = 1;
									do {
										System.out.println("=============================================");	
										System.out.println("Digite o código do produto: (Cancelar[0])");
										int codEstoq = -1;
										while(codEstoq < 0 ) {
											try {
												codEstoq = Integer.parseInt(input.nextLine());
												if(codEstoq < 0 ) {
													System.err.println("\nCódigo inválido, são maiores que 0! Digite novamente.\n");
												}
											}catch(java.lang.NumberFormatException e) {
												System.err.println("\nCódigo Inválido! Digite novamente.\n");
											}
										}
										if(codEstoq == 0) {
											break;
										}
										System.out.println("Digite a quantidade que deseja inserir: ");
										int qtdEstoq= 0;
										while(qtdEstoq < 1 ) {
											try {
												qtdEstoq = Integer.parseInt(input.nextLine());
												if(qtdEstoq < 1 ) {
													System.err.println("\nÉ necessário quantidade maior que 0! Digite novamente.\n");
												}
											}catch(java.lang.NumberFormatException e) {
												System.err.println("\nValor Inválido! Digite novamente.\n");
											}
										}
										try {
											produtos.reabastecerEstoque(codEstoq, qtdEstoq);
											System.out.println("Reposição do produto feito com sucesso!\n");

										}catch(ExceptionProdutoExistente pe) {
											System.err.println(pe.getMessage());
											pausa = input.nextLine();
										}
										continuar = -1;
										System.out.print("\n  ==> Deseja continuar reabastecendo? Sim[1]/Não[2]  ");
										while(continuar < 1 || continuar > 2) {
											try {
												continuar = Integer.parseInt(input.nextLine());
												if(continuar < 1 || continuar > 2) {
													System.err.println("\nOpção Inválida! Digite novamente.\n");
												}
											}catch(java.lang.NumberFormatException e) {
												System.err.println("\nOpção Inválida! Digite novamente.\n");
											}
										}
									}while(continuar == 1);							
								}
								break;						
								
							case 3:							
								System.out.println("\n\n-=--=--=--=--=--=- REMOÇÃO DE PRODUTOS -=--=--=--=--=--=-");
								System.out.println(produtos.listarEstoque());
								continuar = -1;
								do {
									int qtdRemov = 0;
									if(!produtos.isEmpty()) {
										System.out.println("=============================================");	
										System.out.println("Deseja remover o produto[1] ou apenas sua quantidade[2]?");
										int tipoRem = 0;
										while(tipoRem < 1 || tipoRem > 2 ) {
											try {
												tipoRem = Integer.parseInt(input.nextLine());
												if(tipoRem < 1 || tipoRem > 2) {
													System.err.println("\nOpção inválida! Digite novamente.\n");
												}
											}catch(java.lang.NumberFormatException e) {
												System.err.println("\nOpção Inválida! Digite novamente.\n");
											}
										}
										
										System.out.print("Digite o código do produto: (Cancelar[0])  ");
										int codRemov = -1;
										while(codRemov < 0 ) {
											try {
												codRemov = Integer.parseInt(input.nextLine());
												if(codRemov < 0 ) {
													System.err.println("\nCódigo inválido, são maiores que 0! Digite novamente.\n");
												}
											}catch(java.lang.NumberFormatException e) {
												System.err.println("\nCódigo Inválido! Digite novamente.\n");
											}
										}
										
										if(tipoRem == 2) {
											System.out.print("Digite a quantidade: ");
											qtdRemov = 0;
											while(qtdRemov < 1 ) {
												try {
													qtdRemov = Integer.parseInt(input.nextLine());
													if(qtdRemov < 1 ) {
														System.err.println("\nPara remover é necessário quantidade maior que 0! Digite novamente.\n");
													}
												}catch(java.lang.NumberFormatException e) {
													System.err.println("\nValor Inválido! Digite novamente.\n");
												}
											}
										}
										
										try{
											if(tipoRem == 1) {
												qtdRemov = 0;
												produtos.remove(codRemov, qtdRemov, 1);

											}else {
												produtos.remove(codRemov, qtdRemov, 2);

											}
											System.out.println("Removido com sucesso!");
										}catch(ExceptionProdutoExistente pe) {
											System.err.println(pe.getMessage());
											pausa = input.nextLine();
										}
																				
										System.out.print("\nDeseja continuar removendo? Sim[1]/Não[2]   ");
										continuar = -1;
										while(continuar < 1 || continuar > 2) {
											try {
												continuar = Integer.parseInt(input.nextLine());
												if(continuar < 1 || continuar > 2) {
													System.err.println("\nOpção Inválida! Digite novamente.\n");
												}
											}catch(java.lang.NumberFormatException e) {
												System.err.println("\nOpção Inválida! Digite novamente.\n");
											}
										}
									}									
								}while(continuar != 2);
								break;
								
							case 4:
								concedido = false;
								break;
							}			
						}while(opEstoque != 4);				
					}
					break;								
			}			
		}while(parar != 1);		
			input.close();
	}		
}