package jenni;

public class Carta {
		protected ValorCarta valor;
		protected NaipeCarta  naipe;

		public Carta(ValorCarta valor, NaipeCarta naipe) {
			this.valor = valor;
			this.naipe = naipe;
		}

		public String mostrarCarta() {
			return this.valor + " de " + this.naipe;
		}
	 
		public ValorCarta getValor() {
			return this.valor;
		}
	

}
