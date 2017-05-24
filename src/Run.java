import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import base.Extensao;
import base.Veiculo;

public class Run {
	
	public static final Scanner scan = new Scanner(System.in);	
	private static String[] veiculos = {"M","A","O","T","B"};
	private static String[] terrenos = {"terra", "atoleiro", "asfalto", "grama"};
	private static String[] apostas = {"", ""};
	static ArrayList<Extensao> randomExtensoes = new ArrayList<Extensao>();
	static ArrayList<Veiculo> ObjVeiculos = new ArrayList<Veiculo>();
	private static Integer extensaoTotal = 0;
	private static Integer percursoMaximo = 10000; //10km	
	
	public static void main(String[] args) {
		start();
	}
	static void displayVeiculos(Integer opt) {
		System.out.println("Apostas");
		System.out.println("+----------------------+");
		System.out.println("|Selecione a opção " + opt + "   |");
	    System.out.println("+----------------------+");
	    System.out.println("|M - Motocicleta       |");
	    System.out.println("|A - Automóvel         |");	    
	    System.out.println("|O - Ônibus            |");
	    System.out.println("|T - Trator            |");	 
	    System.out.println("|B - Bicicleta         |");		    
	    System.out.println("+----------------------+");
	}
	
	static boolean veiculoExiste(String value) {
		return Arrays.asList(apostas).contains(value);
	}
	
	static void setVeiculo(String value, Integer index) {
		String strVeiculo = "";
		
	    switch (value) {
		case "M":
			strVeiculo = "Motocicleta";
			break;
		case "A":	
			strVeiculo = "Automóvel";			
			break;
		case "O":	
			strVeiculo = "Ônibus";			
			break;
		case "T":	
			strVeiculo = "Trator";			
			break;
		case "B":
			strVeiculo = "Bicicleta";			
			break;
    }	    	
		
		apostas[index] = strVeiculo;	
	}
	
	static void gerarDistancia() {
		while (extensaoTotal < percursoMaximo) {
			String name = terrenos[(int) (Math.random() * terrenos.length)];
			Integer distancia = randomInt(100, 500);
			Extensao objExtensao = new Extensao(name, distancia);
			randomExtensoes.add(objExtensao);
			extensaoTotal += distancia;
		}
	}
	
	static int randomInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;		
	}
	
	static void start() {	
		Integer option = 0;
		
		while (option < 2) {
	    	displayVeiculos(option+1);
	    	String choice = scan.next();	
	    	if (veiculoValido(choice) == false) {
	    		System.out.println("Opção informada é inválida.");
	    		continue;
	    	}
	    	
	    	if (veiculoExiste(choice)) {
	    		System.out.println("Opção informada já foi selecionada.");
	    		continue;	    		
	    	}
	    	setVeiculo(choice, option);
	    	option++;
		}
		
		gerarDistancia();
		try {
			correr();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static String leftPad(String str, int num) {
		return String.format("%1$" + num + "s", str);  		
	}

	static String rightPad(String str, int num) {
	    return String.format("%1$-" + num + "s", str);
	}
	
	static void correr() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> classDefinition;
		for (int c = 0; c < veiculos.length; c++) {
		    switch (veiculos[c]) {
	    		case "M":
	    			classDefinition = Class.forName("classes.Motocicleta");
	    			Veiculo objMoto = (Veiculo) classDefinition.newInstance();	    			
	    			ObjVeiculos.add( objMoto );
	    			break;
	    		case "A":	
	    			classDefinition = Class.forName("classes.Automovel");
	    			Veiculo objAuto = (Veiculo) classDefinition.newInstance();	    			
	    			ObjVeiculos.add( objAuto );
	    			break;
	    		case "O":	
	    			classDefinition = Class.forName("classes.Onibus");
	    			Veiculo objOnibus = (Veiculo) classDefinition.newInstance();	    			
	    			ObjVeiculos.add( objOnibus );
	    			break;
	    		case "T":	
	    			classDefinition = Class.forName("classes.Trator");
	    			Veiculo objTrator = (Veiculo) classDefinition.newInstance();	    			
	    			ObjVeiculos.add( objTrator );
	    			break;
	    		case "B":
	    			classDefinition = Class.forName("classes.Bicicleta");
	    			Veiculo objBic = (Veiculo) classDefinition.newInstance();	    			
	    			ObjVeiculos.add( objBic );	    			
	    			break;
		    }	    	
		}
		        
		for (Veiculo objVeiculo : ObjVeiculos) {
			objVeiculo.setTerrenosPercurso(randomExtensoes);
			objVeiculo.setApostas(apostas);
			objVeiculo.run();			
		}
		
	}
			
	static boolean veiculoValido(String value) {
		return Arrays.asList(veiculos).contains(value);
	}	    
}
