package julio_27;

import java.io.BufferedReader;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Accidentes {
	
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws IOException {
		List<List<String>> csv = new ArrayList<>();
		csv = Reader.read("C:/Users/aosalazar/git/ClasesJava/ProyectoEclipse/Marcas_y_modelos.csv");

		List<Marca> marcas = new ArrayList<Marca>();
		
		
		Marca marca = null;
		String marcaAnterior = "";
		for (List<String> i:csv) {
			if (!marcaAnterior.equals(i.get(0))) {
				marcaAnterior = i.get(0);
				marca = new Marca();
				marcas.add(marca);
				marca.nombreMarca = i.get(0);
				System.out.println(i.get(0));
				
			}
			Coche car = new Coche();
			car.modelo = i.get(1);
			car.velMaxima = Integer.parseInt(i.get(2));
			marca.coches.add(car);
			
		}
		
		String nombreFichero = "fichero.txt";
        Path file = Paths.get(nombreFichero);

        Files.writeString(file, "ARCHIVO GENERADO EL " + LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY/MM/d")) + "\n",  StandardCharsets.UTF_8);
        
		for(Marca j:marcas) {
			Files.writeString(file, "\nMarca: " + j.nombreMarca + "\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			for(Coche c:j.coches) {
				Files.writeString(file, "Modelo: " + c.modelo + " Velocidad: " + c.velMaxima + "\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			}
		}
		
	}
	
}


class Reader {
	public static List<List<String>> read(String path) throws IOException {
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    int contador = 0;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(";");
		        if (contador != 0) {
		        	records.add(Arrays.asList(values));
		        }
		        contador++;
		    }
		} catch (Exception e) {
			System.out.println(e);
		}
		return records;
	}
}

class Marca { 
	String nombreMarca;
	List<Coche> coches = new ArrayList<>();
	
}

class Coche { 
	String modelo;
	int velMaxima;
}



