public class Main {
    public static void main(String[] args) {
        UtilString util = new UtilString();

        String[] paraules = {"Pera", "Poma", "Pera i poma", "i o a!", "Die Äpfel sind lecker", " Un  amor  romà ", "Matrícula    1234BCD!"};

        for (String paraula : paraules) {
            if (UtilString.esCreixent(paraula, false)) {
                System.out.println("\"" + paraula + "\" és creixent.");
            } else if (UtilString.esDecreixent(paraula, false)) {
                System.out.println("\"" + paraula + "\" és decreixent.");
            } else if (UtilString.esCreixiDecri(paraula, false)) {
                System.out.println("\"" + paraula + "\" és creixidecri.");
            } else if (UtilString.esDecriCreixi(paraula, false)) {
                System.out.println("\"" + paraula + "\" és decricreixi.");
            } else {
                System.out.println("\"" + paraula + "\" és normaleta.");
            }
        }
    }
}
