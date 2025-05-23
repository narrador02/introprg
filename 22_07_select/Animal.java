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

    public Categoria getCategoria() {return categoria;}
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}
    public int getIdCategoria() {
        if (categoria == null || categoria.idIndefinit()) {
            return -1;
        }
        return categoria.getId();
    }

    public void setId(int id) {
        if (idIndefinit()) this.id = id;
        else throw new IllegalArgumentException("L'identificador ha de ser positiu");
    }
    
    @Override
    public String toString() {
        String id = "indefinit";
        if (idIndefinit() && categoria.idIndefinit()) {
            return String.format("Animal(id:%s, %s, Categoria(id:%s, %s))", id, getNom(), id, categoria.getNom());
        }
        if (idIndefinit()) {
            return String.format("Animal(id:%s, %s, Categoria(id:%d, %s))", id, getNom(), categoria.getId(), categoria.getNom());
        }
        if (categoria.idIndefinit()) {
            return String.format("Animal(id:%d, %s, Categoria(id:%s, %s))", getId(), getNom(), id, categoria.getNom());
        }
        return String.format("Animal(id:%d, %s, Categoria(id:%d, %s))", getId(), getNom(), categoria.getId(), categoria.getNom());
    }
}
