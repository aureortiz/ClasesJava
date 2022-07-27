package julio_27;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ComoEstas {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LocalDate fecha = LocalDate.now();
		List<String> chistes = new ArrayList<String>();
		
		chistes.add("¿En qué se parecen un plátano y un tomate?\nEn que los dos son rojos menos el plátano");
		chistes.add("Discutir con un DJ es imposible, siempre están cambiando de tema");
		chistes.add("¿Qué es verde y muy rápido?\nUna lechuga en moto");
		chistes.add("¿Qué le dijo una impresora a otra?\nEsa hoja es tuya o es impresión mía");
		chistes.add("¿Por qué los pescadores dan ordenadores a los peces?\nPara que entren en la red");
		
		
		System.out.println("Bienvenido al bot de los estados de ánimo, ¿cómo te llamas?");
		String nombre = input.next();
		
		System.out.println("¡Hola " + nombre + "! Hoy estamos a " + fecha + ", ¿cómo te encuentras? (1 triste, 2 alegre, 3 nervioso)");
		int estado = input.nextInt();
		
		switch (estado) {
			case 1:
				Random random = new Random();
				int rand = random.nextInt(0 + chistes.size());
				System.out.println(chistes.get(rand));
				break;
			case 2:
				System.out.println("Enhorabuena");
				break;
			case 3:
				System.out.println("Tranquilo, seguro que luego todo sale bien");
				break;
		}

	}

}
