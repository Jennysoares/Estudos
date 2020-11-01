package projetoPOO2;

public class ExceptionProdutoExistente extends Exception{
	static String messageEstoqueExiste = "Não foi possivel cadastrar este produto por já existir em estoque!";
	static String messageProdutoInexis = "Não foi constatado nenhum produto com essa informação!";
	static String messageCarrinhoExiste= "Produto já está no seu carrinho, iremos aumentar a quantidade de acordo com o que foi informado!";
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
