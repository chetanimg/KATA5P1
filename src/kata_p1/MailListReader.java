package kata_p1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    
     public static List<String> read(String fileName){
        ArrayList<String> list = new ArrayList<>();
        try {
            String linea="";
            FileReader file = new FileReader(fileName);
            BufferedReader br = new BufferedReader(file);
            
            while((linea = br.readLine()) != null){
                if(linea.contains("@")){
                    list.add(linea);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Can't read file " + fileName);
        }
        return list;
    }
}