package game;

import java.util.Scanner;

public class RUNNER {
	
	public static void main (String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numInput;
		String strInput;
		
		boolean killProgram = false;
// 		
//		
//		do {
//			
//			System.out.println("Hola Gamer, ¿quieres jugar un juego?");
//			
//			input = scanner.nextInt();
//			
//			if (input == 0) {
//				
//				endGame = true;
//				
//			} else if (input == 1) {
//				
//				System.out.println(
//						"=== MENU ===" + 
//						"1.- Iniciar Partida" +
//						"2.- Crear Personaje" +
//						"3.- Salir al Pantalla de Inicio"
//						);
//				
//				input = scanner.nextInt();
//				
//				do {
//					
//				} while (true);
//				
//			}
//			
//			
//		} while(!endGame);
//		
//		System.out.println("Gracias por Jugar :D");
		
		do {
			
			System.out.println(
					"Pantalla de Inicio\n" + 
					"Ingresa 1 para Iniciar\n" +
					"Ingresa 0 para Salir"
					);
			
			numInput = scanner.nextInt();
			
			if (numInput == 1) {
				boolean menuLoopBreaker = false;
				
				do {
					
					System.out.println(
							"========== MORTAL UNIVERSITY ========== \n" + 
							"1.- Iniciar Combate \n" + 
							"2.- Entrenamiento \n" +
							"3.- Creador de Personaje \n" + 
							"0.- Salir a Pantalla de Inicio"
							);
					
					numInput = scanner.nextInt();
					
					switch (numInput) {
					
					case 1:

						
					
						
						boolean combateLoopBreaker = false;
						do {
							
							System.out.println(
									"==== Area Combate === \n" +
									"1.- imprimir yei  \n" +
									"0.- Volver al Menu Principal  \n"
									);
							
							numInput = scanner.nextInt();
							
							if (numInput == 1) {
								System.out.println("Yeeeeei :D");
							} else if (numInput == 0) {
								combateLoopBreaker = true;
							}
							
						} while(!combateLoopBreaker);
						
						break;
						
					case 2:
						boolean entrenamientoLoopBreaker = false;
						do {
							
							System.out.println(
									"==== Area Entretenimiento === \n" +
									"1.- imprimir yei  \n" +
									"0.- Volver al Menu Principal  \n"
									);
							
							numInput = scanner.nextInt();
							
							if (numInput == 1) {
								System.out.println("Yeeeeei :D");
							} else if (numInput == 0) {
								entrenamientoLoopBreaker = true;
							}
							
						} while(!entrenamientoLoopBreaker);
						break;
						
					case 3:
						boolean creadorPersonajeLoopBreaker = false;
						do {
							
							System.out.println(
									"==== Area Creador de Personaje === \n" +
									"1.- imprimir yei  \n" +
									"0.- Volver al Menu Principal  \n"
									);
							
							numInput = scanner.nextInt();
							
							if (numInput == 1) {
								System.out.println("Yeeeeei :D");
							} else if (numInput == 0) {
								creadorPersonajeLoopBreaker = true;
							}
							
						} while(!creadorPersonajeLoopBreaker);
						break;
						
					case 0:
						menuLoopBreaker = true;
						break;
						
					default:
						break;
					
					}
					
				}while(!menuLoopBreaker);
				
			} else if (numInput == 0) {
				killProgram = true;
				
			} else {
				// Hacer que el Input aqui sea string para que cualquier tecla pueda ser recibida y procesada
				System.out.println("Input Invalido");
				
			}
			
		} while (!killProgram);
		
		scanner.close();		
		System.out.println("Gracias Por Jugar :D");
		
	}

}
