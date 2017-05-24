package classes;
import base.Veiculo;

public class Onibus extends Veiculo {

	@Override
	public Integer kmTerra() {
		return 45;
	}

	@Override
	public Integer kmAtoleiro() {
		return 15;
	}

	@Override
	public Integer kmAsfalto() {
		return 80;
	}

	@Override
	public Integer kmGrama() {
		return 60;
	}

}
