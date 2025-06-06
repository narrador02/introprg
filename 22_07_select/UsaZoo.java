/*
 * Programa para usar un zoológico con base de datos.
 * Realiza operaciones de connexión, creación de tablas, inserción y 
 * consulta de categorías.
 */
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
public class UsaZoo {
    public static void main(String[] args) throws SQLException {
       Zoo zoo = new Zoo();

       System.out.print("Primer connectem amb la base de dades: ");
       zoo.connecta();
       zoo.eliminaTaulaCategories();
       System.out.println("connectat");

       System.out.println();
       System.out.println("Creem les taules");
       zoo.creaTaulaAnimals();
       System.out.println("Taules resultants: " + zoo.getNomTaules());

       System.out.println();
       System.out.println("Introduïm categories amb una de repetida");
       Categoria peix = new Categoria("peix");
       zoo.afegeixCategoria(new Categoria("ocell"));
       zoo.afegeixCategoria(peix);
       zoo.afegeixCategoria(new Categoria("ocell"));
       ZooUtils.mostraCategories(zoo.recuperaCategories());

       List<Animal> animals = Arrays.asList(
           new Animal("pardal", new Categoria("ocell")),
           new Animal("gat", new Categoria("mamífer")),
           new Animal("guppy", new Categoria("peix")),
           new Animal("gat", new Categoria("mamífer"))
           );

       System.out.println();
       System.out.println("Considerem els següents animals");
       ZooUtils.mostraAnimals(animals);

       for (Animal animal: animals) {
           zoo.afegeixAnimal(animal);
       }

       System.out.println();
       System.out.println("Un cop afegits, els animals queden:");
       ZooUtils.mostraAnimals(animals);

       System.out.println();
       System.out.println("A la base de dades, els animals són:");
       ZooUtils.mostraAnimals(zoo.recuperaAnimals());

       System.out.println();
       System.out.println("A la base de dades, les categories són:");
       ZooUtils.mostraCategories(zoo.recuperaCategories());

       System.out.println();
       System.out.println("Recuperem ara alguns animals per nom");
       System.out.println("El guppy: " + zoo.obteAnimalPerNom("guppy"));
       System.out.println("El gat: " + zoo.obteAnimalPerNom("gat"));
       System.out.println("El gat Renat: " + zoo.obteAnimalPerNom("Renat"));

       System.out.println();
       System.out.print("Finalment tanquem la connexió amb la base de dades: ");
       zoo.desconnecta();
       System.out.println("desconnectat");
    }
}
