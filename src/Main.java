import it.epicode.classes.Product;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Book1", "Books", 34.6));
        products.add(new Product(2, "Boys1", "Boys", 12.7));
        products.add(new Product(3, "Baby1", "Baby", 25.1));
        products.add(new Product(4, "Boys2", "Boys", 78.82));
        products.add(new Product(5, "Baby2", "Baby", 190.37));
        products.add(new Product(6, "Book2", "Books", 100.8));
        products.add(new Product(7, "Book3", "Books", 124.32));
        products.add(new Product(8, "Boys3", "Boys", 150.89));
        products.add(new Product(9, "Book4", "Books", 94.96));
        products.add(new Product(10, "Baby3", "Baby", 92.10));

        // Esercizio 1

        // se voglio fare la lista:
        System.out.println("List -----------------------");
        List<Product> books = products.stream()
                .filter(product -> product.getCategory()
                        .equals("Books") && product.getPrice() > 100)
                .toList();
        System.out.println(books);

        // se voglio usare il forEach sullo stream:

        System.out.println("forEach -----------------------");

        Stream<Product> books2 = products.stream()
                .filter(product -> product.getCategory()
                       .equals("Books") && product.getPrice() > 100);

        books2.forEach(product -> System.out.println("Name: " + product.getName() + ", " +
                "Price: " + product.getPrice() + " €"));

        System.out.println("-----------------------");

        // Esercizio 2

        Stream<Product> baby = products.stream().filter(product -> product.getCategory().equals("Baby"));
        // baby.forEach(product -> System.out.println(product));
        baby.forEach(product -> System.out.println("Name: " + product.getName() + ", " +
                "Category: " + product.getCategory() + ", " + "Price: " + product.getPrice() + " €"));

        System.out.println("-----------------------");

        // Esercizio 3

        var boys = products.stream()
                .filter(product -> product
                .getCategory().equals("Boys"))
                .map(product -> { double discountedPrice = product.getPrice() * 0.10;
                product.setPrice(discountedPrice);
                    return product; });
        boys.forEach(product -> System.out.println("Name: " + product.getName() + ", "
                + "Discounted price: " + product.getPrice() + " €"));

        System.out.println("-----------------------");

        // Esercizio 4

        LocalDate startDate = LocalDate.of(2021, 2,1);
        LocalDate endDate = LocalDate.of(2021, 4, 1);

    }




}
