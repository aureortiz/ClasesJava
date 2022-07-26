package julio_21;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import julio_21.ReadWriteFiles.*;
/*
 * Generar un programa que contenga 3 clases y 1 interfaz. 
 * Se dio inicio a La liga y la empresa que se encarga de la misma necesita contar con un programa que pueda informar
 * las transferencias de jugadore a otros equipos. Para ello, cuentan con un TXT que tiene la lista de equipos 
 * y sus respectivos jugadores. En este mercado de pases surgieron las siguientes modificaciones:
 * David Villa del Barcelona al Real Madrid
 * Leo Messi del Barcelona al Valencia
 * Cristiano Ronaldo del Real Madrid al Betis
 * Generar un TXT de salida que informe las modificaciones correspondientes y reemplazarlos en el archivo de salida. 
 * El formato del TXT debera ser el siguiente:
 * nombreEquipo1:
 * nombreJugador1 
 * nombreJugador2
 * nombreJugador3
 *
 * Crear una clase que contenga atributos del jugador
 * Crear una clase que contenga atributos del equipo
 * Crear una clase que contenga atributos de main, donde se debe ejecutar el metodo abstracto heredado de la interfaz
 * Crear una interfaz que contenga un metodo abstracto que se llame asignaJugador
 * ENTREGABLE:
 * TXT
 * El proyecto
 * 
 */

public class Furbol {

	public static void main(String[] args) throws IOException {
		String file = LeerArchivo.ReadFile("C:/Users/aosalazar/Desktop/Curso Java/ProyectoEclipse/src/julio_21/fichero.txt");

		String[] todosEquipos = file.split("\n\n");
		
		List<Equipo> listaEquipos = new ArrayList<Equipo>();
		
		for(String i:todosEquipos) {
			String[] equipos = i.split("\n");
			Equipo eq = new Equipo();
			eq.nombre = equipos[0].replace(":", "");
			for(int j = 1; j < equipos.length; j++) {
				Jugador jug = new Jugador();
				//System.out.println(equipos[j]);
				jug.crearJugador(equipos[j]);
				eq.asignarJugador(jug);
			}
			listaEquipos.add(eq);
		}
		
		Equipo barcelona = listaEquipos.get(0);		
		Equipo realMadrid = listaEquipos.get(1);		
		Equipo betis = listaEquipos.get(2);		
		Equipo valencia = listaEquipos.get(3);		

		Jugador j1 = new Jugador();
		j1 = barcelona.getJugador("David Villa");
		barcelona.eliminarJugador("David Villa");
		realMadrid.asignarJugador(j1);
		
		j1 = barcelona.getJugador("Leo Messi");
		barcelona.eliminarJugador("Leo Messi");
		valencia.asignarJugador(j1);
		
		j1 = realMadrid.getJugador("Cristiano Ronaldo");
		realMadrid.eliminarJugador("Cristiano Ronaldo");
		betis.asignarJugador(j1);
		
		
		
		String nombreFichero = "C:/Users/aosalazar/Desktop/Curso Java/ProyectoEclipse/src/julio_21/fichero.txt";
        Path file2 = Paths.get(nombreFichero);
		Files.writeString(file2, "",  StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
		int contador = 0;
		for (Equipo eq:listaEquipos) {
			Files.writeString(file2, eq.nombre + ":\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			int contador2 = 0;
			for(Jugador j:eq.plantilla) {
				Files.writeString(file2, j.nombre,  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
				if(contador != listaEquipos.size()-1 || contador2 != eq.plantilla.size()-1) {
					Files.writeString(file2, "\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);	
				}
				contador2++;
				
			}
			if(contador != listaEquipos.size()-1) {
				Files.writeString(file2, "\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);	
			}
			contador++;
		}
	}

}

class Equipo implements asignaJugador {
	String nombre;
	String abreviatura;
	List<Jugador> plantilla = new ArrayList<Jugador>();
	
	@Override
	public void asignarJugador(Jugador jug) {
		this.plantilla.add(jug);
	}
	
	public void eliminarJugador(String nombre) {
		int contador = 0;
		for(Jugador j:this.plantilla) {
			if(j.nombre.equals(nombre)) {
				this.plantilla.remove(contador);
				break;
			}
			contador++;
		}
	}
	
	public Jugador getJugador(String nombre) {
		Jugador jug = new Jugador();
		for(Jugador j:this.plantilla) {
			if(j.nombre.equals(nombre)) {
				jug = j;
				break;
			}
		}
		return jug;
	}
}

class Jugador {
	String nombre;
	String equipo;
	
	public void crearJugador(String nombre) {
		this.nombre = nombre;
	}
}

interface asignaJugador {
	void asignarJugador(Jugador jug);
}






