import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApp {

    public static void main(String[] args) throws IOException {

        Book bookOne = new Book("Animal Farm", "George Orwell", 122);
        Book bookTwo = new Book("Alice in Wonderland", "Jane Carruth", 92);
        Book bookThree = new Book("And Then There Were None", "Agatha Christie", 264);
        Book bookFour = new Book("Cabbagetown", "Hugh Garner", 85);
        Book bookFive = new Book("Cadillac Desert", "Marc Reisner", 93);
        Book bookSix = new Book("Taken", "Edward Bloor", 154);
        Book bookSeven = new Book("Take Me Home", "Brian Leung", 173);

        Map<Box, List<Book>> catalog = new HashMap<>();
        MainApp boxMap = new MainApp();
        boxMap.putBooksToCatalog(catalog, bookOne, bookTwo, bookThree, bookFour, bookFive, bookSix, bookSeven);

        catalog.forEach((k, v) -> {
            System.out.println("Box letter " + k.getLetter() + " :" + v.toString());
        });

        boxMap.bufferedReaderRecall(catalog);
    }

    private void putBooksToCatalog(Map<Box, List<Book>> catalog, Book... books) {
        for (Book book : books) {
            char alphabetIndex = book.getAlphabetIndex();
            Box box = getBox(alphabetIndex);
            List<Book> bookList;
            if (catalog.containsKey(box)) {
                bookList = catalog.get(box);
                bookList.add(book);
            } else {
                bookList = new ArrayList<>();
                bookList.add(book);
                catalog.put(box, bookList);
            }
        }
    }

    private Box getBox(char letter) {
        return new Box(letter);
    }

    private void bufferedReaderRecall(Map<Box, List<Book>> catalog) throws IOException {

        System.out.println("Input letter : ");
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        String s = reader.readLine();
        String stop = "0";
        if (stop.equals(s)) {
            System.exit(0);
        } else {
            List<Book> bookList = catalog.get(new Box(s.charAt(0)));
            System.out.println(bookList);
            bufferedReaderRecall(catalog);
        }
    }
}



