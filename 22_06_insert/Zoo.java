/*
 * Programa principal para gestionar un zoológico con base de datos.
 * Realiza operaciones de connexión, creación de tablas, inserción y 
 * consulta de categorías.
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
public class Zoo {
    private static final String NOM_BASE_DE_DADES = "animals.bd";
    private static final String CADENA_DE_CONNEXIO = "jdbc:sqlite:" +
                                                     NOM_BASE_DE_DADES;
    private Connection conn = null;

    public void connecta() throws SQLException {
        if (conn != null) return;  
        conn = DriverManager.getConnection(CADENA_DE_CONNEXIO);
    }

    public void desconnecta() throws SQLException {
        if (conn == null) return; 
        conn.close();
        conn = null;
    }

    public void creaTaulaCategories() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS CATEGORIES (" +
                     "       id        INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "       nom       VARCHAR(40))";
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public void afegeixCategoria(Categoria categoria) throws SQLException {
        if (!categoria.idIndefinit()) return;
        String sql = String.format("INSERT INTO CATEGORIES (nom) VALUES ('%s')", categoria.getNom());
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            categoria.setId(rs.getInt(1));
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public void afegeixAnimal(Animal animal) throws SQLException { 
        if (!animal.idIndefinit()) return; 
        if (obteCategoriaPerNom(animal.getCategoria().getNom()) == null) {
            afegeixCategoria(animal.getCategoria());
        } else { 
            animal.setCategoria(obteCategoriaPerNom(animal.getCategoria().getNom()));
        }
        String sql = String.format(
                "INSERT INTO ANIMALS (nom, categoria) VALUES ('%s', '%d')",
                animal.getNom(),
                animal.getCategoria().getId());
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            animal.setId(rs.getInt(1));
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public List<Categoria> recuperaCategories() throws SQLException {
        String sql = "SELECT * FROM CATEGORIES ORDER BY nom";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Categoria> categories = new LinkedList<>();
            while (rs.next()) {
                int bdId = rs.getInt("id");
                String nom = rs.getString("nom");
                Categoria categoria = new Categoria(bdId, nom);
                categories.add(categoria);
            }
            rs.close();
            if (categories.isEmpty()) {
                System.out.println("Cap categoria");
            } else {
                System.out.println("Nombre de categories: " + categories.size());
            }
            return categories;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public Categoria obteCategoriaPerNom(String p_nom) throws SQLException {
        String sql = String.format(
                "SELECT * FROM CATEGORIES WHERE nom = '%s' ORDER BY id LIMIT 1;",
                p_nom);
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.getString("nom") == null || rs.getString("nom").isEmpty()) {
                return null;
            }
            int bdId = rs.getInt("id");
            String nom = rs.getString("nom");
            rs.close();
            return new Categoria(bdId, nom);
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public void eliminaTaulaCategories() throws SQLException {
        eliminaTaulaAnimals();
        String sql = "DROP TABLE IF EXISTS CATEGORIES";
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }
 
    public String getNomTaules() throws SQLException {
        String sql = "SELECT name FROM sqlite_schema " +
                    "WHERE name NOT LIKE 'sqlite%' " +
                    "ORDER BY name";
        List<String> taules = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) { taules.add(rs.getString("name")); }
            rs.close();
        }
        return taules.size() > 0 ? String.join(", ", taules) : "cap";
    }
    
    public void creaTaulaAnimals() throws SQLException {
        creaTaulaCategories();
        String sql = "CREATE TABLE IF NOT EXISTS ANIMALS (" +
                     "       id         INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "       nom        VARCHAR(40)," +
                     "       categoria  INTEGER)";
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) st.close();
        }
    }

    public void eliminaTaulaAnimals() throws SQLException {
        String sql = "DROP TABLE IF EXISTS ANIMALS";
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } finally {
            if (st != null) st.close();
        }
    }
}
