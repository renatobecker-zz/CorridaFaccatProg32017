package classes;

import base.Veiculo;

public class Motocicleta extends Veiculo {

	@Override
	public Integer kmTerra() {
		return 40;
	}

	@Override
	public Integer kmAtoleiro() {
		return 30;
	}

	@Override
	public Integer kmAsfalto() {
		return 80;
	}

	@Override
	public Integer kmGrama() {
		return 50;
	}

}
