package projetoPOO2;

public class ExceptionLimiteCarrinho extends Exception{
	public ExceptionLimiteCarrinho() {	
		super("N�o � poss�vel adicionar mais de 10 produtos no carrinho, finalize sua compra!");
	}
}
