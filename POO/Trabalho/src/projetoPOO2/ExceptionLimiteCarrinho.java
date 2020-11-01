package projetoPOO2;

public class ExceptionLimiteCarrinho extends Exception{
	public ExceptionLimiteCarrinho() {	
		super("Não é possível adicionar mais de 10 produtos no carrinho, finalize sua compra!");
	}
}
