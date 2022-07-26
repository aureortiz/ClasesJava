package julio_21.ReadWriteFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

public class LeerArchivo {
    public static String ReadFile(String path){
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8));
            String line;
            StringBuilder s = new StringBuilder();
            while((line = bf.readLine()) != null){
                s.append(line+"\n");
            }        
            bf.close();
            return s.toString();

        } catch (Exception e) {
            System.out.println("ERROR AL LEER EL ARCHIVO");
            return "ERROR";
        }
    }
}
