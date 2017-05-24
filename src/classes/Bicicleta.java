package classes;

import base.Veiculo;

public class Bicicleta extends Veiculo {

	@Override
	public Integer kmTerra() {
		return 55;
	}

	@Override
	public Integer kmAtoleiro() {
		return 25;
	}

	@Override
	public Integer kmAsfalto() {
		return 70;
	}

	@Override
	public Integer kmGrama() {
		return 50;
	}
	
	public String descricao() {
		return "Bicicleta";
	}	
}
