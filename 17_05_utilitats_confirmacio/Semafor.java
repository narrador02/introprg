/* Programa que simula un semáforo y antes de dar consejo se asegura que eres mayor de edad */
public class Semafor {
    public static void main(String[] args) {
        System.out.println("Ets major d'edat?");
        String resposta = Entrada.readLine();
        boolean confirma = UtilitatsConfirmacio.respostaABoolean(resposta);
        if (confirma) {
            System.out.println("Color?");
            String color = Entrada.readLine();
            colorSemaforo(color);
        } else {
            System.out.println("No pots fer servir aquest programa sense supervisió");
        }
    }
    public static void colorSemaforo(String color) {
        if (color.equals("verd")) {
            System.out.println("passa");
        } else if (color.equals("groc")) {
            System.out.println("corre!");
        } else if (color.equals("vermell")) {
            System.out.println("espera");
        } else if (color.equals("magenta")) {
            System.out.println("ves a l'oculista");
        }
    }
}
