package projetoPOO2;

public class ExceptionProdutoEstoque extends Exception{
	public ExceptionProdutoEstoque() {
		super("Estamos sem este produto em estoque, sentimos muito!");
	}

}
