package menus;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.TabExpander;

public class main {
	/*
	 * X = altura, Y = comprimento
	 */
	static String nomeJogador1, nomeJogador2;
	static int tamanhoX, tamanhoY, quantidadeDeNavios, limiteMaximoDeNavios;
	static int tabuleiroJogador1[][], tabuleirojogador2[][];
	static Scanner obj = new Scanner(System.in);
	
	public static void obterTamanhoDosTabuleiros() {
	Scanner obj = null;
	
		//For infinito
		for(;;) {
			boolean tudoOk = false;
			try {
				obj = new Scanner(System.in);
				System.out.println("Digite a altura do tabuleiro: ");
				tamanhoX = obj.nextInt();
				System.out.println("Digite o comprimento do tabuleiro: ");
				tamanhoY = obj.nextInt();
				tudoOk = true;
			}catch (InputMismatchException erro) {
				System.out.println("Digite um valor numérico");	
				}
			if(tudoOk) {
				break;
			}
			
				}
	}
	
	public static void obterNomesDosJogadores() {
		System.out.println("Digite o nome do jogador 1: ");
		nomeJogador1 = obj.next();
		System.out.println("Digite o nome do jogador 2: ");
		nomeJogador2 = obj.next();
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
		int x = 0, y = 0;
		Random numeroAleatorio = new Random();
		do {
			x = 0;
			y = 0;
			for(int[] linha : novoTabuleiro) {
				for(int coluna : linha) {
					if(numeroAleatorio.nextInt(100) <= 10) {
						if(coluna == 0) { 
							novoTabuleiro[x][y] = 1;
							
							quantidadeRestanteDeNavios--; 
							break;
						}
						if(quantidadeRestanteDeNavios <= 0) {
							break;
						}
					}
					y++;
				}
				y = 0;
				x++;
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
	
	public static void exibirLetrasDasColunasDoTabuleiro() {
		char letraDaColuna = 65;
		String letrasDoTabuleiro = "   ";			
		for(int i = 0; i < tamanhoY; i++) {
			letrasDoTabuleiro += (letraDaColuna++) + " ";
		}
		System.out.println(letrasDoTabuleiro);
	}
	
	public static void exibirTabuleiro(String nomeDoJogador, int[][] tabuleiro, boolean seuTabuleiro) {
		System.out.println("|----- " + nomeDoJogador +  " -----|");
		String linhaDoTabuleiro = "";
		exibirLetrasDasColunasDoTabuleiro();
		int numeroDaLinha = 1;
		for(int[] linha : tabuleiro) {
			if(numeroDaLinha < 10) {
				linhaDoTabuleiro = (numeroDaLinha++) +  " |";	
			}else {
				linhaDoTabuleiro = (numeroDaLinha++) +  "|";
			}
			
			for(int coluna : linha) {
				switch (coluna) {
				case 0: //Vazio ou sem ação
					linhaDoTabuleiro += " |"; 
					break;
				case 1: //Navio
					if(seuTabuleiro) {
					linhaDoTabuleiro += "N|"; 
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
	}
	
	public static void exibirTabuleirosDosJogadores() {
		exibirTabuleiro(nomeJogador1, tabuleiroJogador1, true);
		exibirTabuleiro(nomeJogador2, tabuleirojogador2, false);
		
	}

	
	public static void main(String[] args) {
		//TODO
		obterNomesDosJogadores();
		obterTamanhoDosTabuleiros();
		calcularQuantidadeMaximaDeNaviosNoJogo();
		iniciandoOsTamanhosDosTabuleiros();
		obterQuantidadeDeNaviosNoJogo();
		inserirOsNaviosNosTabuleirosDosJogadores();
		exibirTabuleirosDosJogadores();
		
		System.out.println("Digite a posição do seu tiro: ");
		String tiroDoJogador = obj.next();
		//Verificações
		int quantidadeDeNumeros = (tamanhoY > 10) ? 2 : 1;
		String expressaoDeVerificacao = "^[A-Za-z]{1}[0-9]{"
				+ quantidadeDeNumeros + "}$";
		if(tiroDoJogador.matches(expressaoDeVerificacao)) {
			String tiro = tiroDoJogador.toLowerCase();
			char posicaoX = tiro.charAt(0);
			int posicaoY = Integer.parseInt(tiro.substring(1));
			
		}else {
			System.out.println("ERRO");
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
				System.out.println("Escolha um número válido");
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