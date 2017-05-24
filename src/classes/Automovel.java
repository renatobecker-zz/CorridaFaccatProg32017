package classes;
import base.Veiculo;

public class Automovel extends Veiculo {

	@Override
	public Integer kmTerra() {
		return 60;
	}

	@Override
	public Integer kmAtoleiro() {
		return 10;
	}

	public Integer kmAsfalto() {
		return 100;
	}

	@Override
	public Integer kmGrama() {
		return 30;
	}
	
	public String descricao() {
		return "Automóvel";
	}
}
