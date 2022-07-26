package julio_22;

import java.util.Scanner;
import java.util.Random;

/*
 * CONSIGNA:
 * Generar un programa que funcione como un juego de adivinanzas, donde el usuario tenga que adivinar un numero entre 1 y 1000. 
 * Donde si adivina le damos un mensaje de "Adivinaste, campeon" y sino adivino que siga iterando hasta adivinar 
 * ESTRUCTURA DEL PROGRAMA:
 * Clase de usuario, clase principal, interfaz que implemente alguna variable y/o metodo que el programa utilice. 
 * Utilizando lambda. 
 * ENTREGABLES:
 * Codigo del programa
 */
public class Adivinanza extends lambda {

	public static void main(String[] args) {
		Random random = new Random();
		int rand = random.nextInt(1 + 1000);
		Scanner input = new Scanner(System.in);
		Usuario user = new Usuario();
		Comparar lambdaCompare = (n1, n2) -> n1 != n2;
		
		int n;
		do {
			System.out.println("Adivina el número del 1 al 1000");
			user.num = input.nextInt();
		} while(lambdaCompare.compare(user.num, rand));
		System.out.println("Adivinaste campeón");
	}
}

class Usuario {
	int num;
}

interface Comparar {
	boolean compare(int n1, int n2);
}