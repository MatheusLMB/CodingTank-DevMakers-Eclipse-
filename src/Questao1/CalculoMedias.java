package Questao1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class CalculoMedias {

	static ArrayList<Double> listaNotas = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static Long pegaLong;
	static String verificaEntrada;
	static DecimalFormat DecimalFormatter = new DecimalFormat("#.##");
	
	public static void main(String[] args) {
		
		System.out.print("Digite a quantidade de notas a serem inseridas (Favor inserir apenas números inteiros!) : ");
		verificaEntrada = scan.next();
		
		while (!verificaEntrada.matches("\\d+")) {
			System.out.println("\nQuantidade inválida!\n");
			System.out.print("Digite novamente a quantidade de notas a serem inseridas (Favor inserir apenas números inteiros!) : ");
			verificaEntrada = scan.next();
		} 
		
		pegaLong = Long.parseLong(verificaEntrada);
		
		System.out.println("\n****** OBS: A seguir, deve-se inserir as notas - exemplo: 5.5 ou 5 ou -5 ou -5.5\n");
		
		for (int i = 1; i <= pegaLong; i++) {
			System.out.print("Digite a " + i + "ª nota: ");
			verificaEntrada = scan.next();
			while(!verificaEntrada.matches("^[+-]?(([0-9]\\d*)|0)(\\.\\d+)?")) {
				System.out.println("Nota inválida!\n");
				System.out.print("Digite a " + i + "ª nota novamente: ");
				verificaEntrada = scan.next();
			}
			listaNotas.add(Double.parseDouble(verificaEntrada));
		}
		
		System.out.println("\nQual média deseja realizar: - ARITMETICA ou HARMONICA\n");
		System.out.print("Opção: ");
		verificaEntrada = scan.next().toUpperCase();
		
		while(!verificaEntrada.equals("ARITMETICA") && !verificaEntrada.equals("HARMONICA")) {
			System.out.print("Opção inválida\n");
			System.out.print("Digite a Opção novamente: ");
			verificaEntrada = scan.next().toUpperCase();
		}
		
		if(verificaEntrada.equals("ARITMETICA")) {
			System.out.println("\nNúmeros Digitados: " + listaNotas);
			System.out.println("Média Escolhida: " + verificaEntrada);
			System.out.println("Média: " + MediaAritimetica(listaNotas));
		} else if(verificaEntrada.equals("HARMONICA")) {
			System.out.println("\nNúmeros Digitados: " + listaNotas);
			System.out.println("Média Escolhida: " + verificaEntrada);
			System.out.println("Média: " + MediaHarmonica(listaNotas));
		}
		
	}
	
	
	public static String MediaAritimetica(ArrayList<Double> listaNotas) {
		double media = 0;
		for (int i = 0; i < listaNotas.size(); i++) {
			media += listaNotas.get(i);
		}
		return DecimalFormatter.format(media / listaNotas.size());
	}
	
	public static String MediaHarmonica(ArrayList<Double> listaNotas) {
		double media = 0;
		for(int i = 0; i < listaNotas.size(); i++) {
			media += 1 / listaNotas.get(i);
		}
		return DecimalFormatter.format(listaNotas.size() / media);
	}

}
