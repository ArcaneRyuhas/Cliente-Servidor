import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args){
        //Establece el puerto a utilizar
        int puerto = 8080;
        try {
            //Cuando un cliente se conecta se abre el puerto a escuchar conexiones de cliente
            //Si el servidor responde, AQUI SE CREA EL SOCKET EN EL SO
            Socket cs = new Socket("localhost", puerto);

            //Establece el stream de salida
            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
            //Establece el stream de entrada
            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            //Variables para leer los datos
            String linearecibida;

            //Iniciamos la comunicación
            //Leemos linea por linea hasta recibir adios
            while (!(linearecibida = in.readLine()).equalsIgnoreCase("Adios")) {
                System.out.println("Servidor: " + linearecibida);
            }

            out.println("Recepción de datos correcta...");

            out.close();
            in.close();
            cs.close();
        
        
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}