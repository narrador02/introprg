/*
 * Programa principal para tener utilitades
 * del zoológico para la clase Zoo
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.LinkedList;
public class ZooUtils {
    public static void mostraCategories(List<Categoria> categories) {
        if (categories == null) {
            System.out.printf("Cap categoria");
        }
        for (Categoria cat: categories) {
            System.out.println("\t" + cat.toString());
            System.out.println();
        }
    }
    
    public static void mostraAnimals(List<Animal> animals) {
        if (animals == null) {
            System.out.printf("Cap animal");
        }
        System.out.println("Nombre d'animals: " + animals.size());
        for (Animal animal: animals) {
            System.out.println("\t" + animal.toString());
            System.out.println();
        }
    }
}
