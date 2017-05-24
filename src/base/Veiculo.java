package base;

public abstract class Veiculo {
	private Integer percurso = 0;
	
	public abstract Integer kmTerra();
	public abstract Integer kmAtoleiro();
	public abstract Integer kmAsfalto();
	public abstract Integer kmGrama();
	public Integer getPercurso() {
		return this.percurso;
	}
	public void SumPercurso(Integer value) {
		this.percurso += value;
	}
	
}
