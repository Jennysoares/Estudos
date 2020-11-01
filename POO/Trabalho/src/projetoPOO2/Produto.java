package projetoPOO2;

public class Produto {
	private String nome, categoria;
	private int quantidade, cod, qtdCompra;
	private double valor;
	
	public Produto(int cod, String nome, String categoria, int quantidade, double valor) {
		this.setCod(cod);
		this.setNome(nome);
		this.setCategoria(categoria);
		this.setQuantidade(quantidade);
		this.setValor(valor);
		this.setQtdCompra(0);
	}	
	
	public String toString() {
		return "Cod: "+ this.getCod() +"\nProduto: "+ this.getNome()+ "\nCategoria: "+ this.getCategoria()+ "\nValor: R$ "+ this.getValor() + "\n";
	}	
	public String toStringCodCompl() {
		return "Cod: "+ this.getCod() +"\nProduto: "+ this.getNome()+ "\nCategoria: "+ this.getCategoria() + "\nValor: R$ "+ this.getValor() + "\nQuantidade: "+ this.getQuantidade()+ "\n";
	}	
	public String toStringCompra() {
		return "Cod: "+ this.getCod() +"\nProduto: "+ this.getNome()+ "\nCategoria: "+ this.getCategoria() + "\nValor: R$ "+ this.getValor() + "\nQuantidade: "+ this.getQtdCompra()+ "\n";
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getQtdCompra() {
		return qtdCompra;
	}

	public void setQtdCompra(int qtdCompra) {
		this.qtdCompra = qtdCompra;
	}
	
}
