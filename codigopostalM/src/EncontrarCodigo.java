import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EncontrarCodigo {
    public static void main (String[] args){
        if (args.length == 0){
            System.out.println("Por favor, proporcione al menos un còdigo postal");
            return;
        }
        String archivo = "codigos_postales.csv";
        Map<String, String> codigoPostalAsentamientos = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine()) !=null){
                String[] partes = linea.split(",");

                if (partes.length >= 3) {
                    String codigoPostal  = partes[0].trim();
                    String asentamiento  = partes[1].trim();

                    codigoPostalAsentamientos.put(codigoPostal, asentamiento);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String codigoPostal : args){
            String asentamiento = codigoPostalAsentamientos.get(codigoPostal);
            if (asentamiento != null){
                System.out.println("Còdigo postal:" + codigoPostal + "-> " +
                        "Asentamiento:" + asentamiento);
            } else {
                System.out.println("Còdigo postal:" + codigoPostal + " no encontrado ");
            }
        }
    }
}
