package base;

import java.util.ArrayList;

public abstract class Veiculo {
	private ArrayList<Extensao> terrenosPercurso = new ArrayList<Extensao>();
	private String[] apostas = {"", ""};
	public abstract Integer kmTerra();
	public abstract Integer kmAtoleiro();
	public abstract Integer kmAsfalto();
	public abstract Integer kmGrama();
	public abstract String  descricao();
	public void setTerrenosPercurso(ArrayList<Extensao> lista) {
		this.terrenosPercurso = lista;
	}
	public void setApostas(String[] _apostas) {
		this.apostas = _apostas;
	}
	
	public ArrayList<Extensao> getTerrenosPercurso() {
		return this.terrenosPercurso;
	}
	public void run() {
		RunExtensao startRunning = new RunExtensao();
		startRunning.SetVeiculo(this);
		startRunning.SetApostas(this.apostas);
		
		Thread executar = new Thread(startRunning);		
		executar.start();
	}		
}
