package julio_28;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;


public class PaellaValenciana {

	public static void main(String[] args) throws IOException {        
        Ingredientes ingredientes = new Ingredientes();
        ingredientes.generaSalida();
        
        Preparacion preparacion = new Preparacion();
        preparacion.generaSalida();
	}

}

class Ingredientes implements GenerarSalida {
	List<String> lista_ingredientes = Arrays.asList("Arroz bomba: 1500 g", "Pollo de corral: 1", "Conejo: 0.5", "Judía verde plana: 500 g", 
    		"Garrofón: 500 g", "Alcachofa (opcional): 500 g", "Aceite de oliva virgen extra", "Pimentón dulce", "Tomate triturado",
    		"Azafrán", "Romero fresco", "Sal");

	@Override
	public void generaSalida() throws IOException {
		String nombreFichero = "src/julio_28/ingredientes.txt";
        Path file = Paths.get(nombreFichero);
        
        Files.writeString(file, "Ingredientes\n\n",  StandardCharsets.UTF_8);
        for(String i:this.lista_ingredientes) {
        	Files.writeString(file, i + "\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
		}
		
	}
}

class Preparacion implements GenerarSalida {
	List<String> listaPreparacion = Arrays.asList("Dificultad: Media", "Tiempo total 1 h 25 m", "Elaboración 10 m", "Cocción 1 h 15 m", "Reposo 5 m");

	@Override
	public void generaSalida() throws IOException {
		String nombreFichero = "src/julio_28/preparacion.txt";
        Path file = Paths.get(nombreFichero);
        
        Files.writeString(file, "Preparación\n\n",  StandardCharsets.UTF_8);
        for(String i:this.listaPreparacion) {
        	Files.writeString(file, i + "\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
		}
		
	}
}

interface GenerarSalida {
	void generaSalida() throws IOException ;
}



