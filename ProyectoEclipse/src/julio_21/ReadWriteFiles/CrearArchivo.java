package julio_21.ReadWriteFiles;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

public class CrearArchivo {
    public static void main(String args[]) throws IOException{
        Collection<Empleado> lista_emp = new ArrayList<Empleado>();
        lista_emp.add(Empleado.setPersona("Aurelio", "Ortiz", 21, "S", LocalDate.of(2000, 8, 21), "San Juan de Alicante", "aure.ortizperis@gmail.com"));
        lista_emp.add(Empleado.setPersona("Carlos", "Martínez", 22, "S", LocalDate.of(2000, 5, 5), "Valencia", "camacar36@gmail.com"));
        lista_emp.add(Empleado.setPersona("María", "García", 22, "S", LocalDate.of(2000, 5, 15), "Valencia", "maria.gagu16@gmail.com"));
        lista_emp.add(Empleado.setPersona("Belén", "Aroca", 23, "S", LocalDate.of(1999, 3, 31), "Aranjuez", "megustanlostatuajesyaranjuez@gmail.com"));
        lista_emp.add(Empleado.setPersona("Naila", "Gatita", 1, "S", LocalDate.of(2022, 1, 5), "Aranjuez", "soyNaila@gato.com"));
         
        String nombreFichero = "fichero.txt";
        Path file = Paths.get(nombreFichero);

        Files.writeString(file, "ARCHIVO GENERADO EL " + LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY/MM/d")) +  "\n\n",  StandardCharsets.UTF_8);
        for (Empleado i:lista_emp){
            Files.writeString(file, "Nombre: " + i.getName() + "\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            Files.writeString(file, "Apellido: " + i.getLastname() + "\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            Files.writeString(file, "Ciudad: " + i.getOrigin() + "\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            Files.writeString(file, "Edad: " + Integer.toString(i.getAge()) + "\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            Files.writeString(file, "Estado civil: " + i.getCivilState() + "\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            Files.writeString(file, "Fecha de nacimiento: " + i.getBirth() + "\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            Files.writeString(file, "Email: " + i.getEmail() + "\n\n",  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }

        String s = LeerArchivo.ReadFile("fichero.txt");
        System.out.println(s);
        
    }
}

class Empleado {
    private String nombre;
    private String apellido;
    private int edad;
    private LocalDate fechaDeNacimiento;
    private String estadoCivil;
    private String lugarOrigen;
    private String email; 

    public static Empleado setPersona(String name, String lastname, int age, String civilState, LocalDate birth, String origin, String mail){
        Empleado emp = new Empleado();
        emp.nombre = name;
        emp.apellido = lastname;
        emp.edad = age;
        emp.estadoCivil = civilState;
        emp.fechaDeNacimiento = birth;
        emp.lugarOrigen = origin;
        emp.email = mail;
        return emp;
    }

    public String getName(){
        return nombre; 
    }
    public String getLastname(){
        return apellido; 
    }
    public int getAge(){
        return edad; 
    }
    public String getCivilState(){
        return estadoCivil; 
    }
    public LocalDate getBirth(){
        return fechaDeNacimiento; 
    }
    public String getOrigin(){
        return lugarOrigen; 
    }
    public String getEmail(){
        return email; 
    }
}