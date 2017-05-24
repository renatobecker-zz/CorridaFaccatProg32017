package base;

public class Extensao {
	private String terreno;
	private Integer distancia; 
	
	public Extensao(String _terreno, int _distancia) {
		this.terreno   = _terreno;
		this.distancia = _distancia;
	}
	
	public String getTerreno() {
		return this.terreno;
	}
	
	public Integer getDistancia() {
		return this.distancia;
	}
}
