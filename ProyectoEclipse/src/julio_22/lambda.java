package julio_22;

import java.util.Scanner;

/*
 * Crear un programa que implemente una funcion lambda, una interfaz y una clase 
 * donde se pase por consola los resultados de 1 suma. Se deben pedir 2 valores por consola. 
 */
public class lambda {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		Suma suma_lambda =  (t1, t2) ->  t1 + t2;
		Scanner input = new Scanner(System.in);
		
		int n1, n2;
		
		System.out.println("Introduce dos números para ser sumados:\nn1:");
		n1 = input.nextInt();
		System.out.println("n2:");
		n2 = input.nextInt();
			
		sumar(n1, n2, suma_lambda);
	}
	
	public static void sumar(int n1, int n2, Suma formato) {
		int resultado = formato.ejecutar(n1, n2);
		System.out.println("La suma es: " + resultado);
	}

}


interface Suma {
	int ejecutar(int n1, int n2);
}