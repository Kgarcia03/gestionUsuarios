package Taller1;


import java.util.Scanner;


public class CajeroAutomatico {
    private ManejadorDenominacion manejadorInicial;

    public CajeroAutomatico() {
        // manejadores para cada denominación y luego se configura la cadena
        ManejadorDenominacion manejador100000 = new ManejadorDenominacion(100000);
        ManejadorDenominacion manejador50000 = new ManejadorDenominacion(50000);
        ManejadorDenominacion manejador20000 = new ManejadorDenominacion(20000);
        ManejadorDenominacion manejador10000 = new ManejadorDenominacion(10000);
        ManejadorDenominacion manejador5000 = new ManejadorDenominacion(5000);

        // Configución de la cadena de responsabilidad comenzando con la denominación $100.000
        manejador100000.setNextManejador(manejador50000);
        manejador50000.setNextManejador(manejador20000);
        manejador20000.setNextManejador(manejador10000);
        manejador10000.setNextManejador(manejador5000);

        this.manejadorInicial = manejador100000;
    }

    public void dispensarDinero(int cantidad) {
        if (cantidad % 5000 != 0) {
            throw new IllegalArgumentException("La cantidad a ingresar debe ser múltiplo de 5.000");
        }

        manejadorInicial.dispensar(cantidad);
    }

    public static void main(String[] args) {
        CajeroAutomatico cajero = new CajeroAutomatico();
        Scanner leer = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de dinero a retirar: ");
        int cantidad = leer.nextInt();

        // Para controlar la excepción cuando no es un valor múltiplo de $5000
        try {
            cajero.dispensarDinero(cantidad);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
