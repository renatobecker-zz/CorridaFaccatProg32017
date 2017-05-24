package base;

import java.util.ArrayList;

class RunExtensao implements Runnable {
	private Veiculo objVeiculo;
	private double mtsSegundo = 0.28;
	private String[] apostas = {"", ""};
	
	public void SetVeiculo(Veiculo obj) {
		this.objVeiculo = obj;
	}
	
	public void SetApostas(String[] _apostas) {
		this.apostas = _apostas;
	}
	
	private int getMtsSegundo(String terreno) {
		int kmHora;
		switch (terreno) {
		case "terra":
			kmHora = objVeiculo.kmTerra();
			break;
		case "asfalto":
			kmHora = objVeiculo.kmAsfalto();
			break;
		case "grama":
			kmHora = objVeiculo.kmGrama();
			break;
		case "atoleiro":
			kmHora = objVeiculo.kmAtoleiro();
			break;
		default:
			kmHora = 0;
			break;
		}
		return (int) (kmHora * mtsSegundo);	
	}
	
	public void run() {
		ArrayList<Extensao> terrenos = objVeiculo.getTerrenosPercurso();		
		int extensao_terreno = 0;
		int terrenos_percorridos = 0;
		int qtde_terrenos = terrenos.size();
		int percent_terrenos = 0;
		String line = "";
		for (Extensao ext : terrenos) {
			extensao_terreno = ext.getDistancia();
			int metrosSegundo = getMtsSegundo(ext.getTerreno());
			int extensao_local = 0;
			try {
				while (extensao_local < extensao_terreno) {
					extensao_local += metrosSegundo;
					//System.out.println("Veículo: " + objVeiculo.descricao() + " Terreno atual: " + ext.getTerreno() +  " Metros Seg. Terreno: " + metrosSegundo + " Distância atual: " + ext.getDistancia() + " Percorrido: " + extensao_local + " Restando: " + (ext.getDistancia() - extensao_local) + " Percorridos: " + terrenos_percorridos);
					System.out.println(objVeiculo.descricao() + " (" + ext.getTerreno() + "):" + line + " - (" + percent_terrenos + "%)");
					Thread.sleep(100);
				}				
				terrenos_percorridos++;
				percent_terrenos = (int) ( ( terrenos_percorridos * 100 ) / qtde_terrenos );
				line += "*";
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}    
		System.out.println("Percurso concluído pelo veículo: " + objVeiculo.descricao());
		if (apostas[0].equals(objVeiculo.descricao())) {
				System.out.println("O 1º apostador venceu!");			
		} else if (apostas[1].equals(objVeiculo.descricao())) {
			System.out.println("O 2º apostador venceu!");			
		} else {
			System.out.println("Nenhum apostador acertou!");
		}
		System.exit(0);		
	}

}
