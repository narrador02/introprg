/*
 * Clase Animal para gestionar los animales del zoo.
 * Proporciona constructores para crear instáncias con o sin 
 * identificador y métodos de acceso.
 */
 public class Animal {
    private int id = -1;  
    private String nom;
    private Categoria categoria;

    public Animal(String nom, Categoria categoria) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("El nom no pot ser null ni blanc");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("La categoria no pot ser null");
        }
        this.nom = nom;
        this.categoria = categoria;
    }

    public Animal(int id, String nom, Categoria categoria) {
        this(nom, categoria);
        setId(id);
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
        if (!idIndefinit()) this.id = id;
        else throw new IllegalArgumentException("L'identificador ha de ser positiu");
    }
}
