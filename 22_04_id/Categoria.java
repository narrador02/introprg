/*
 * Clase Categoria para gestionar identificadores y nombres de categorías.
 * Proporciona constructores para crear instancias con o sin 
 * identificador y métodos de acceso.
 */
public class Categoria {
    private int id = -1; 
    private String nom;

    public Categoria(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("El nom no pot ser null ni blanc");
        }
        this.nom = nom;
    }

    public Categoria(int id, String nom) {
        this(nom);
        if (id < 0) {
            throw new IllegalArgumentException("L'identificador ha de ser positiu");
        }
        this.id = id;
    }

    public boolean idIndefinit() { return id < 0; }
    public int getId() {
        if (idIndefinit()) {
            throw new UnsupportedOperationException("L'identificador no està disponible");
        }
        return id;
    }
    public String getNom() { return nom; }

    public void setId(int id) {
        if (id >= 0) this.id = id;
        else throw new IllegalArgumentException("L'identificador ha de ser positiu");
    }

    @Override
    public String toString() {
        return "Categoria(id:" +
            (id < 0 ? "indefinit" : id) +
            ", " + nom + ")";
    }
}
