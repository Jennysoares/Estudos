package projetoPOO2;

import java.util.Random;


public class Carrinho extends Array{
	
	private String[] tipoStatus = {"Em análise", "Em trânsito", "Cancelado", "Concluido"};
	private int numPedido;
	private double total = 0;
	private String status;
	
	public boolean ExisteciaProduto(Object obj) {
		boolean existe = false;
		String nome = ((Produto) obj).getNome().toUpperCase();
		String categoria = ((Produto) obj).getCategoria();
		
		if(!this.isEmpty()) {
			for(Object p : this.lista) {
				if(((Produto) p).getNome().toUpperCase().equals(nome) && ((Produto) p).getCategoria().equals(categoria)) {
					existe = true;
					break;
				}	
			}
		}
		return existe;
	}
	
	
	public void add(int indice, int qtdProd, Array arrayRef) throws ExceptionProdutoExistente, ExceptionLimiteCarrinho, ExceptionProdutoEstoque{
		if(this.isEmpty() || this.size()<10) {
			boolean espaco = false;
			Produto obj = null;
			int quantidadeEstoque = 0;
			
			for(Object p : arrayRef.lista) {
				if(((Produto) p).getCod() == indice) {
					obj = ((Produto) p);
					quantidadeEstoque = ((Produto) p).getQuantidade();
				}
			}				
			
			if(obj != null) {				
				if(!ExisteciaProduto(obj)) {
					if(quantidadeEstoque >= qtdProd) {
						for(int i=0;i<this.size();i++) {
							if(lista[i] == null) {
								espaco = true;
								lista[i] = obj;
								if(qtdProd != 0) {
									((Produto) lista[i]).setQtdCompra((qtdProd));;
								}
							}
						}
						if(espaco == false) {
							this.alocar(this.lista);
							this.lista[this.size()-1] = obj;
							if(qtdProd != 0) {
								((Produto) lista[this.size()-1]).setQtdCompra((qtdProd));
							}
						}
					}else {
						throw new ExceptionProdutoEstoque();
					}					
				}
				else {
					for(Object prod : this.lista) {
						if(((Produto) prod) == obj){
							((Produto) prod).setQtdCompra(((Produto) prod).getQtdCompra() + qtdProd);
						}
					}
					throw new ExceptionProdutoExistente(2);
				}
			}
			else {
				throw new ExceptionProdutoExistente(3);
			}
		}
		else {
			throw new ExceptionLimiteCarrinho();
		}
	}
		
	public void remove(int indice, int qtdRem) throws ExceptionProdutoExistente {
		Produto aux = null;
		boolean produtoExiste = false;
			
		for(int i=0;i<this.size();i++) {
			if(((Produto)this.lista[i]) != null){
				if(((Produto)this.lista[i]).getCod() == indice) {
					produtoExiste = true;
					
					if(((Produto) this.lista[i]).getQtdCompra() == qtdRem) {
						this.lista[i] = null;
						
						if(i < this.size()) {
							for(int k=i+1;k<this.size();k++) {
								if(lista[k] != null) {
									aux = (Produto) this.lista[k];
									lista[k-1] = aux;
									lista[k] = null;
								}
							}
						}
					}
					else {
						((Produto) this.lista[i]).setQtdCompra(((Produto) this.lista[i]).getQtdCompra() - qtdRem);
					}				
				}
			}			
		}
		if(produtoExiste == false) {
			throw new ExceptionProdutoExistente(3);
		}
	}
	
	public void finalizar(Estoque meuEstoque) {
		Random gerador = new Random();
		status = (tipoStatus[new Random().nextInt(tipoStatus.length)]);
		
		for (int i = 0; i <99999; i++) {
        	this.numPedido = (gerador.nextInt(999999));
        }		
		
		for(Object estoque: meuEstoque.lista) {
			for(Object carrinho : this.lista) {
				if(((Produto) estoque).getCod() == ((Produto) carrinho).getCod()) {
					((Produto) estoque).setQuantidade(((Produto) estoque).getQuantidade() - ((Produto) carrinho).getQtdCompra());
					((Produto) estoque).setQtdCompra(0);
				}
			}
		}	
		
		System.out.println("\nPedido finalizado com sucesso!");
		System.out.println("Código do pedido: "+ this.getNumPedido());
	}
	
	public String listar() {
		String retorno = "";
		
		if(this.isEmpty()) {
			retorno = "\nSeu carrinho está vazio!";
		}
		else {
			for(Object p : this.lista) {
				if(p != null) {
					retorno += ((Produto) p).toStringCompra() + "\n";		
				}				
			}
		}			
		return retorno;
	}
	public void totalPagar() {
		for(Object p : this.lista) {
			if(p != null) {
				total += ((Produto) p).getQtdCompra() * ((Produto)p).getValor();
			}
		}		
		System.out.println("===> TOTAL: R$ " + total);;
	}
	
	public String toStringCarrinho(){			
		String retorno = "Número do pedido: " + this.getNumPedido() + "\nStatus: " + this.getStatus() + "\n\n\tCARRINHO:\n"+ this.listar() + "\n";
		return retorno;		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}	
}
