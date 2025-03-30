/*
 * En este programa he de añadir la propiedad posición mediante
 * los constructores e inicializarla con el parámetro que se especifique.
 * En este caso, si la posición indicada es incorrecta se quedará "estirat".
 */

public class GatRenat {
    
    private int vides = 7;
    private String posicio = "estirat";
    private static GatRenat instancia;
    
    private GatRenat() {
    }

    private GatRenat(int vides) {
        setVides(vides);
    }

    private GatRenat(String posicio) {
        setPosicio(posicio);
    }

    private GatRenat(int vides, String posicio) {
        setVides(vides);
        setPosicio(posicio); 
    }

    public static GatRenat getInstancia() {
        if (instancia == null) {
            instancia = new GatRenat();
        }
        return instancia;
    }

    public static GatRenat getInstancia(int vides) {
        if (instancia == null) {
            instancia = new GatRenat(vides);
        }
        instancia.setVides(vides);
        return instancia;
    }

    public static GatRenat getInstancia(String posicio) {
        if (instancia == null) {
            instancia = new GatRenat(posicio);
        }
        instancia.setPosicio(posicio);
        return instancia;
    }

    public static GatRenat getInstancia(int vides, String posicio) {
        if (instancia == null) {
            instancia = new GatRenat(vides, posicio);
        }
        instancia.setVides(vides);
        instancia.setPosicio(posicio);
        return instancia;
    }

    public int getVides() { return vides; }
    public void setVides(int novesVides) {
        if (novesVides >= 0)  {
            vides = novesVides;
        }
    }
    public String getPosicio() { return posicio; }
    public void setPosicio(String posicio) {
        if (posicio.equals("estirat") || posicio.equals("assegut") || posicio.equals("dret")) {
            this.posicio = posicio;
        }
    }

    @Override
    public String toString() { return String.format("Vides: %d. Posició: %s", vides, posicio); }
    public void main(String[] args) {
        GatRenat[] renats = {
                new GatRenat(),
        new GatRenat(8),  
        new GatRenat("dret"),  
        new GatRenat(8, "dret") 
        };
        for (GatRenat renat: renats) {
            System.out.println(renat);
        }
    }
}
