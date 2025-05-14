/*
 * Programa que controla elos errores que pueden generar los codigos de entorno
 * y Botiga, por ello haremos uso de excepciones
 */
public class BotigaException extends Exception {
    public BotigaException() {
        super("Botiga plena");
    }
    
    public BotigaException(String missatge) {
        super(missatge);
    }
}
