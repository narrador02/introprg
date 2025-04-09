/*
 * Programa el cual contiene los valores de posición y vidas de Renat
 * que se usarán en otro programa
 */
 public class GatRenat {
     private int vides = 7;
     private String posicio = "estirat";
     
     public boolean esViu() {
         if (vides > 0) {
             return true;
         }
         return false;
     }
    
    public boolean esDret() {
         if (posicio.equals("dret")) {
             return true;
         }
        return false;
     }
    
    public boolean esAssegut() {
         if (posicio.equals("assegut")) {
             return true;
         }
        return false;
     }
    
    public boolean esEstirat() {
         if (posicio.equals("estirat")) {
             return true;
         }
        return false;
     }
     
    public int getVides() {
         return vides;
     }

    public String getPosicio() {
         return posicio;
     }

    public void setVides(int num) {
         vides = num;
     }

    public void setPosicio(String text) {
         //posicio = text;
         if (text.equals("estirat") || text.equals("assegut") || text.equals("dret")) {
             posicio = text;
         }
     }
 }
