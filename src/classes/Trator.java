package classes;
import base.Veiculo;


public class Trator extends Veiculo {

	@Override
	public Integer kmTerra() {
		return 55;
	}

	@Override
	public Integer kmAtoleiro() {
		return 30;
	}

	@Override
	public Integer kmAsfalto() {
		return 60;
	}

	@Override
	public Integer kmGrama() {
		return 55;
	}
	
	public String descricao() {
		return "Trator";
	}	
}
