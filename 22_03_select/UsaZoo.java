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

        System.out.println("Creem la taula CATEGORIES");
        zoo.creaTaulaCategories();

        System.out.println();
        System.out.println("Mostrem les categories disponibles inicialment");
        ZooUtils.mostraCategories(zoo.recuperaCategories());

        Categoria ocell = new Categoria("ocell");
        Categoria mamifer = new Categoria("mamífer");
        System.out.println();
        System.out.println("Inserim les categories: ");
        System.out.println("\t"+ ocell);
        System.out.println("\t"+ mamifer);
        zoo.afegeixCategoria(ocell);
        zoo.afegeixCategoria(mamifer);

        System.out.println();
        System.out.println("Mostrem les categories disponibles ara");
        ZooUtils.mostraCategories(zoo.recuperaCategories());

        System.out.println();
        System.out.println("Consultem algunes categories");
        System.out.println("En consultar per la categoria ocell obtenim " + zoo.obteCategoriaPerNom("ocell"));
        System.out.println("En consultar per la categoria mamífer obtenim " + zoo.obteCategoriaPerNom("mamífer"));
        System.out.println("En consultar per la categoria peix obtenim " + zoo.obteCategoriaPerNom("peix"));

        System.out.print("Finalment tanquem la connexió amb la base de dades: ");
        zoo.desconnecta();
        System.out.println("desconnectat");
    }
}
