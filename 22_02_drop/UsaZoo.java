/*
 * Programa para usar un zoológico con base de datos.
 * Realiza operaciones de connexión, creación de tablas, inserción y 
 * consulta de categorías.
 */
import java.sql.SQLException;

public class UsaZoo {
    public static void main( String args[]) throws SQLException {
        Zoo zoo = new Zoo();

        System.out.print("Primer connectem amb la base de dades: ");
        zoo.connecta();
        System.out.println("connectat");

        System.out.println("Eliminem la taula CATEGORIES per si existia");
        zoo.eliminaTaulaCategories();

        System.out.println("Creem la taula CATEGORIES (primer cop)");
        zoo.creaTaulaCategories();

        System.out.println("Eliminem la taula CATEGORIES");
        zoo.eliminaTaulaCategories();

        System.out.println("Creem la taula CATEGORIES (segon cop)");
        zoo.creaTaulaCategories();

        System.out.println("Creem la taula CATEGORIES (tercer cop)");
        zoo.creaTaulaCategories();

        System.out.print("Finalment tanquem la connexió amb la base de dades: ");
        zoo.desconnecta();
        System.out.println("desconnectat");
    }
}
