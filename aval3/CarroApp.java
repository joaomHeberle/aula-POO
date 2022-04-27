package aval3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarroApp {
	private static Scanner inp = new Scanner(System.in);
	private static Carro car;
	private static void printaMenu(String[] opcoes) {
		System.out.println("<-- Menu -->");
		for (int i = 0; i < opcoes.length; i++) {
			System.out.println("(" + i + ")" + opcoes[i]);
		}
		System.out.println("Digite a opcao desejada (de 0 a " + (opcoes.length - 1) + "):");
	}
	private static int montaTelaMenu(String... opcoes) {
		int ret = -1;
		while (ret < 0 || ret >= opcoes.length) {
			printaMenu(opcoes);
			ret = inp.nextInt();
		}
		return ret;
	}
	private static void iniciaCarro() {
		Scanner inp = new Scanner(System.in);
		System.out.println("Olá, bem-vindo ao software do seu carro!\n");
		System.out.print("Para começar, informe o modelo do seu carro:");
		car = new Carro(inp.nextLine());
	}
	static void telaAlteraVelocidade(boolean acelerar) throws CarroException {
		if (acelerar) {
			System.out.print("digite quantos km/h acelerar:");
			car.acelera(inp.nextInt());
		} else {
			System.out.print("digite quantos km/h frear:");
			car.freia(inp.nextInt());
		}
	}
	public static void main(String[] args) throws CarroException {
	
		iniciaCarro();
		int opcaoEscolhida = -1; //inicializa a variavel com qualquer valor diferente de zero
		while (opcaoEscolhida!=0) {
			try {
			opcaoEscolhida = montaTelaMenu("sair","acelerar o carro",
					"freiar o carro", "deligar", "ligar", "subir marcha",
					"descer marcha", "mostrar estado carro");
				switch (opcaoEscolhida) {
				case 1: telaAlteraVelocidade(true); break;
				case 2:	telaAlteraVelocidade(false); break;
				case 3:	car.desliga(); break;
				case 4:	car.liga(); break;
				case 5:	car.upMarcha(); break;
				case 6:	car.downMarcha(); break;
				case 7:	System.out.println(car+"\n"); break;
			}
			}catch (CarroException e) {
				System.out.println(e.getMensagem());
		}catch (InputMismatchException e) {
			System.out.println("Erro na entrada: digite um n�mero!");
			inp.next();
		}

	}
	
		//segunda parte

				Carro uno = new Carro("Uno");
				Carro uno2 = new Carro("Uno");
				
				uno2.liga();
				uno2.upMarcha();
				uno2.acelera(15);
				ArrayList<Carro> carros = new ArrayList<Carro>();
				carros.add(uno2);
				carros.add(uno);
				carros.add(car);
				
				
				System.out.println("ordenando carros...\nCarros desordenados:");
				System.out.println(carros);
				Collections.sort(carros);
				System.out.println("Carros ordenados:");
				System.out.println(carros);

				System.out.println("Tchau! Até mais!");
			}
		}