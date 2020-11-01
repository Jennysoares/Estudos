package projetoPOO2;

public class Pedidos extends Carrinho{
	
	public Pedidos() throws ExceptionProdutoExistente {
		super();
		// TODO Auto-generated constructor stub
	}

	public String toStringPedidos() {
		String list = "";
		if(!this.isEmpty()) {
			for(Object p : this.lista) {
				list += "\n" + ((Carrinho) p).toStringCarrinho();
				list += "Total: R$" + ((Carrinho) p).getTotal();
				list += "\n=====================================================\n";
			}			
		}
		else {
			list = "\nNão houve pedidos!\n";
		}		
		return list;
	}
	
	public void pedidoEspecifico(int pedido) {
		boolean pedidoEncontrado = false;
		String list = "";
		
		if(!this.isEmpty()) {
			for(Object p : this.lista) {
				if(((Carrinho)p).getNumPedido() == pedido){
					list += (((Carrinho) p).toStringCarrinho());
					list += "Total: R$" + ((Carrinho) p).getTotal();
					list += "\n=====================================================\n";
					pedidoEncontrado = true;
				}
			}
		}
		if(pedidoEncontrado == false) {
			System.out.println("\nPedido não encontrado!");
		}
		else {
			System.out.println(list);
		}
	}	
	
	
}
