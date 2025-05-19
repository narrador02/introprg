/*
 * Programa para usar un zoológico con base de datos.
 * Realiza operaciones de connexión, creación de tablas, inserción y 
 * consulta de categorías.
 */
 import java.sql.SQLException;
 public class UsaZoo {
     public static void main( String args[]) throws SQLException, IllegalArgumentException {
         Zoo zoo = new Zoo();
 
         System.out.print("Primer connectem amb la base de dades: ");
         zoo.connecta();
         zoo.eliminaTaulaCategories();
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
         System.out.println("Un cop inserides les categories queden:");
         System.out.println("\t"+ ocell);
         System.out.println("\t"+ mamifer);
 
         System.out.println();
         System.out.println("Mostrem les categories disponibles finalment");
         ZooUtils.mostraCategories(zoo.recuperaCategories());
 
         System.out.println();
         System.out.print("Finalment tanquem la connexió amb la base de dades: ");
         zoo.desconnecta();
         System.out.println("desconnectat");
     }
 }
