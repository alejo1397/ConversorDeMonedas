import com.google.gson.Gson;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Servicio service = new Servicio();

        String monedaBase;
        String monedaDestino;
        int cantidad;

            System.out.println("******************************************");

            System.out.println("Ingrese Tu Moneda Base: USD, EUR, COP... ");

            Scanner teclado = new Scanner(System.in);
            monedaBase = teclado.next();
            System.out.println("Tu Moneda Es : " + monedaBase);
            System.out.println("*******************************************");
            System.out.println("Ingrese moneda destino: USD, EUR, COP... ");
            monedaDestino = teclado.next();
            System.out.println("La Moneda a Convertir Es: " + monedaDestino);
            System.out.println("********************************************");
            System.out.println("Ingrese cantidad: ");



        try {
            cantidad = teclado.nextInt();
            System.out.println("cantidad ingresada : " + cantidad + " " + monedaBase);
            System.out.println("**********************************************");
        } catch (Exception e) {
            System.out.println("Error: La cantidad ingresada no es un número válido. Intente de nuevo. " );
            return;
        }

        try {
            CoversionResponse response = service.obtenerInformacionDeLaApi(monedaBase, monedaDestino, cantidad);
        System.out.println("Tasa de conversión: " + response.getBase_code());
        System.out.println("Valor convertido: " + (response.getConversion_result())+ "  " + monedaDestino );
        } catch (Exception e) {
            throw new RuntimeException("Se genero un error : "+e.getMessage());
        }

    }
}
