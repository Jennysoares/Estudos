package projetoPOO2;

public class ExceptionProdutoExistente extends Exception{
	static String messageEstoqueExiste = "N�o foi possivel cadastrar este produto por j� existir em estoque!";
	static String messageProdutoInexis = "N�o foi constatado nenhum produto com essa informa��o!";
	static String messageCarrinhoExiste= "Produto j� est� no seu carrinho, iremos aumentar a quantidade de acordo com o que foi informado!";
	static String mensagem;
	
	public ExceptionProdutoExistente(int tipo) {	
		super(getMensagem(tipo));
	}

	public static String getMensagem(int tipo) {
		if(tipo == 1) {
			mensagem = getMessageEstoque();
		}
		else if(tipo == 2){
			mensagem = getMessageCarrinho();
		}
		else if(tipo == 3){
			mensagem = getMessageProdutoInexis();
		}
		return mensagem;
	}

	public static String getMessageEstoque() {
		return messageEstoqueExiste;
	}

	public static String getMessageCarrinho() {
		return messageCarrinhoExiste;
	}

	public static String getMessageProdutoInexis() {
		return messageProdutoInexis;
	}		
}
