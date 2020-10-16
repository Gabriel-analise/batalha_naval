package menus;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.TabExpander;

public class main {
	/*
	 * X = altura, Y = comprimento
	 */
	static int tamanhoX, tamanhoY, quantidadeDeNavios, limiteMaximoDeNavios;
	static int tabuleiroJogador1[][], tabuleirojogador2[][];
	static Scanner obj = new Scanner(System.in);
	
	public static void obterTamanhoDsTabuleiros() {
	Scanner obj = null;
	
		//For infinito
		for(;;) {
			boolean tudoOk = false;
			try {
				obj = new Scanner(System.in);
				System.out.println("Digite a altura do tabuleiro: ");
				tamanhoX = obj.nextInt();
				System.out.println("Digite o tamanho do tabuleiro: ");
				tamanhoY = obj.nextInt();
				tudoOk = true;
			}catch (InputMismatchException erro) {
				System.out.println("Digite um valor num�rico");	
				}
			if(tudoOk) {
				break;
			}
			
				}
	}
	
	public static void calcularQuantidadeMaximaDeNaviosNoJogo() {
		limiteMaximoDeNavios = (tamanhoX * tamanhoY) / 3;
	}
	
	public static void iniciandoOsTamanhosDosTabuleiros() {
		tabuleiroJogador1 = retornarNovoTabuleiroVazio();
		tabuleirojogador2 = retornarNovoTabuleiroVazio();
		
	}
	
	public static int[][] retornarNovoTabuleiroVazio() {
		return new int[tamanhoX][tamanhoY];
	}
	
	public static void obterQuantidadeDeNaviosNoJogo() {
		System.out.println("Digite a quantidade de navios da partida");
		System.out.println("Max: " + limiteMaximoDeNavios + " navios");
		quantidadeDeNavios = obj.nextInt();
		
		if(quantidadeDeNavios < 1 || quantidadeDeNavios > limiteMaximoDeNavios) {
			quantidadeDeNavios = limiteMaximoDeNavios;
		}
	}
	
	public static int[][] retornarNovoTabuleiroComOsNavios() { 
		int novoTabuleiro[][] = retornarNovoTabuleiroVazio();
		int quantidadeRestanteDeNavios = quantidadeDeNavios;  
		Random numeroAleatorio = new Random();
		do {
			for(int[] linha : novoTabuleiro) {
				for(int coluna : linha) {
					if(numeroAleatorio.nextInt(100) <= 10) {
						if(coluna == 0) { 
							coluna = 1;
							quantidadeRestanteDeNavios--; 
							break;
						}
						if(quantidadeRestanteDeNavios <= 0) {
							break;
						}
					}
				}
				if(quantidadeRestanteDeNavios <= 0) {
					break;
				}
			}
	}while(quantidadeRestanteDeNavios > 0);
		return novoTabuleiro;
}
	
	public static void inserirOsNaviosNosTabuleirosDosJogadores() {
		tabuleiroJogador1 = retornarNovoTabuleiroComOsNavios();
		tabuleirojogador2 = retornarNovoTabuleiroComOsNavios();
	}

	
	public static void main(String[] args) {
		
		obterTamanhoDsTabuleiros();
		calcularQuantidadeMaximaDeNaviosNoJogo();
		iniciandoOsTamanhosDosTabuleiros();
		obterQuantidadeDeNaviosNoJogo();
		inserirOsNaviosNosTabuleirosDosJogadores();
		//
		
		System.out.println("|----- Jogador 1 -----");
		String linhaDoTabuleiro = "";
		boolean seuTabuleiro = true;
		int numeroDaLinha = 1;
		for(int[] linha : tabuleiroJogador1) {
			linhaDoTabuleiro = (numeroDaLinha++) +  " |";
			for(int coluna : linha) {
				switch (coluna) {
				case 0: //Vazio ou sem a��o
					linhaDoTabuleiro += " |"; 
					break;
				case 1: //Navio
					if(seuTabuleiro) {
					linhaDoTabuleiro += " N|"; 
					break;
					} else {
						linhaDoTabuleiro += " |"; 
						break;
					}
				case 2: //Erro
					linhaDoTabuleiro += "X|";
					break;
				case 3: //Acertou
					linhaDoTabuleiro += "D|";
						break;
				}
			}	
			System.out.println(linhaDoTabuleiro);
		}
		
		
		obj.close();

	}

	public static void menuPrincipal() {
		Scanner obj = new Scanner(System.in);
		
		
		int menu = 0;
		int escolha = 0;
		
		System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
		System.out.println("|                            BATALHA NAVAL                                  |");
		System.out.println("|                                                                           |");
		System.out.println("| [1] - Jogar                                                               |");
		System.out.println("| [2] - Sair                                                                |");
		System.out.println("|                                                                           |");
		System.out.println("| [3] - Ranking                                                             |");
		System.out.println("|                                                                           |");
		System.out.println("|                                                                           |");
		System.out.println("|                                                                           |");
		System.out.println("|                                                                           |");
		System.out.println("|                                                                           |");
		System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
		
		
		
		
		do {
			menu = obj.nextInt();
			switch (menu) {
			case 1: 
				menu1();
				
				break;
			case 2:
				escolha = 1;
				break;

			case 3:
				
			default: 
				System.out.println("Escolha um n�mero v�lido");
			}
			
		} while (escolha == 0);

	obj.close();	
	}
	
	public static void menu1() {
		Scanner obj = new Scanner(System.in);
		String jogador1;
		String jogador2;
		
		System.out.println("Digite o nome do jogador 1: ");
		jogador1 = obj.nextLine();
		System.out.println("Digite o nome do jogador 2: ");
		jogador2 = obj.nextLine();
		
	}

}