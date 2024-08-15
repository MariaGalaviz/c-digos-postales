import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

                String archivo = "src/codigos_postales.csv";
                int urbanos = 0;
                int rurales = 0;

                try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        String[] partes = linea.split(",");

                        if (partes.length >= 3) {
                            String tipo = partes[2].trim();

                            // Contar según el tipo de asentamiento
                            if (tipo.equalsIgnoreCase("Urbano")) {
                                urbanos++;
                            } else if (tipo.equalsIgnoreCase("Rural")) {
                                rurales++;
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Asentamientos Urbanos: " + urbanos);
                System.out.println("Asentamientos Rurales: " + rurales);

        }

    }
