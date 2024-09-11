package Taller1;

public class ManejadorDenominacion {
    private int denominacion;
    private ManejadorDenominacion siguienteManejador;

    public ManejadorDenominacion(int denominacion) {
        this.denominacion = denominacion;
    }

    public void setNextManejador(ManejadorDenominacion siguiente) {
        this.siguienteManejador = siguiente;
    }

    public void dispensar(int cantidad) {
        if (cantidad >= denominacion) {
            int num = cantidad / denominacion;
            int resto = cantidad % denominacion;
            System.out.println("Dispensando " + num + " billete(s) de $" + denominacion);

            if (resto != 0 && siguienteManejador != null) {
                siguienteManejador.dispensar(resto);
            }
        } else if (siguienteManejador != null) {
            siguienteManejador.dispensar(cantidad);
        }
    }
}