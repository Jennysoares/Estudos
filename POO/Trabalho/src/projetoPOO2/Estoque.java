package projetoPOO2;

import java.util.Random;

public class Estoque extends Array{
	
	public Estoque() throws ExceptionProdutoExistente{	
		preencherEstoque();
	}
	
	public void preencherEstoque() throws ExceptionProdutoExistente {
		String[] DVD = {"Mogli: O Menino Lobo", "007: Contra Spectre", "Perdido em Marte", "Jogos Vorazes: A Esperança – O Final", "O Bom Dinossauro", 
						"Capitão América: Guerra Civil", "Batman vs Superman: A Origem da Justiça", "Deadpool", "Zootopia: Essa Cidade é o Bicho",
						"Star Wars: O Despertar da Força", "Capitã Marvel", "Aladdin", "Toy Story 4", "Hellboy","John Wick 3 - Parabellum", 
						"Batman Silêncio", "Pantera Negra", "Aquaman", "The Beatles Anthology - The Beatles", "Galinha Pintadinha 4", 
						"Moana: Um Mar de Aventuras"};
		
		String[] CD = {"1 - The Beatles ", "The Immaculate Collection - Madonna ", "Abbey Road - The Beatles", "Brothers in Arms - Dire Straits", 
					   "Nevermind - Nirvana", "Appetite for Destruction - Guns N' Roses", "Slippery When Wet - Bon Jovi", "Hybrid Theory - Linkin Park", 
					   "The Eminem Show - Eminem", "Greatest Hits - Queen", "(What's the Story) Morning Glory? - Oasis", "The Wall - Pink Floyd"};
		
		String[] livros = {"O diário perdido de Gravity Falls", "Mais esperto que o diabo", "Escravidão", "A garota do lago",
						   "As aventuras de Mike", "O Senhor dos Anéis", "O Pequeno Príncipe", "Harry Potter e a Pedra Filosofal", "Don Quixote",
						   "O Hobbit", "O alquimista", "O Código Da Vinci"};
			
		int cod = 1;
		int valor = 0, qtd = 0;
		
		for(String produto : DVD) {
			valor = new Random().nextInt((100 - 10) + 1) + 10;
			qtd = new Random().nextInt((150 - 1) + 1) + 1;

			
			Produto prod = new Produto(cod, produto, "DVD", qtd, valor); 
			this.addEstoque(prod);
			cod++;
		}
		for(String produto : CD) {
			valor = new Random().nextInt((120 - 10) + 1) + 10;
			qtd = new Random().nextInt((150 - 1) + 1) + 1;
			
			Produto prod = new Produto(cod, produto, "CD", qtd, valor); 
			this.addEstoque(prod);
			cod++;
		}
		for(String produto : livros) {
			valor = new Random().nextInt((150 - 10) + 1) + 10;
			qtd = new Random().nextInt((150 - 1) + 1) + 1;

			Produto prod = new Produto(cod, produto, "Livro", qtd, valor); 
			this.addEstoque(prod);
			cod++;
		}		
	}
	
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
	
	public void addEstoque(Object obj) throws ExceptionProdutoExistente{
		if(this.ExisteciaProduto(obj)) {
			throw new ExceptionProdutoExistente(1);
		}
		else {
			this.add(obj);
		}		
	}
	
	public void reabastecerEstoque(int codProd, int quantidade) throws ExceptionProdutoExistente {
		boolean produtoExiste = false;
		for(Object p : this.lista) {
			if(((Produto) p).getCod() == codProd) {
				produtoExiste = true;
				((Produto) p).setQuantidade(((Produto) p).getQuantidade() + quantidade);
			}
		}
		if(produtoExiste == false) {
			throw new ExceptionProdutoExistente(3);
		}
	}
	
	public void remove(int indice, int qtdRem, int tipoRemocao) throws ExceptionProdutoExistente {	
		boolean produtoExiste = false;
					
		for(int i=0;i<this.size();i++) {
			if(((Produto)this.lista[i]) != null){
				if(((Produto)this.lista[i]).getCod() == indice) {
					produtoExiste = true;
								
					if(tipoRemocao == 1) {
						this.lista[i] = null;
					}
					else {
						((Produto) this.lista[i]).setQuantidade(((Produto) this.lista[i]).getQuantidade() - qtdRem);
					}
				}
			}
		}
		
		if(produtoExiste == false) {
			throw new ExceptionProdutoExistente(3);
		}
	}
	
	public String listar() {	
		String list = "";
		if(!this.isEmpty()) {
			for(Object p : this.lista) {
				if(p != null) {
					list += p.toString() + "\n";
				}
			}
		}	
		else {
			list = "Sinto muito, estamos sem produtos em estoque!";
		}
		return list;
	}
	
	public String listarCategoria(String categoria) {
		String list = "";
		
		if(!this.isEmpty()) {
			for(Object p : this.lista) {
				if(p != null) {
					if(((Produto) p).getCategoria().equals(categoria)) {
						list += ((Produto) p).toString() + "\n";				
					}
				}				
			}
		}
		else {
			list = "Sinto muito, estamos sem produtos em estoque!";
		}		
		return list;
	}
	
	public String listarEstoque() {
		String list = "";
		
		if(!this.isEmpty()) {
			for(Object p : this.lista) {
				if(p != null) {
					list += ((Produto) p).toStringCodCompl() + "\n";	
				}
			}
		}
		else {
			list = "Não há produtos em estoque!";
		}		
		return list;
	}
	
}
