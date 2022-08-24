import java.util.HashMap;

public class MainApp {

    public static void main(String[] args) {

        HashMap<Character, Box> catalog = new HashMap<>();
        MainApp mainApp = new MainApp();
        Book bookOne = new Book("Animal Farm", "George Orwell", 122);
        Book bookTwo = new Book("Alice in Wonderland", "Jane Carruth", 92);
        Book bookThree = new Book("And Then There Were None", "Agatha Christie", 264);
        Book bookFour = new Book("Cabbagetown", "Hugh Garner", 85);
        Book bookFive = new Book("Cadillac Desert", "Marc Reisner", 93);
        Book bookSix = new Book("Taken", "Edward Bloor", 154);
        Book bookSeven = new Book("Take Me Home", "Brian Leung", 173);
        Book[] books = new Book[]{bookOne, bookTwo, bookThree, bookFour, bookFive, bookSix, bookSeven};
        mainApp.putBookToBox(books, catalog);
        mainApp.printLetterLibrary('a', catalog);
        mainApp.printLetterLibraryWithPosCount(3, 'a', catalog);

    }

    private void putBookToBox(Book[] books, HashMap<Character, Box> catalog) {

        for (Book book : books) {
            char alphabetIndex = book.getAlphabetIndex();
            Box box = createBox(alphabetIndex, catalog);
            box.pushBook(book);
            if (!catalog.containsKey(alphabetIndex)) {
                catalog.put(alphabetIndex, box);
            }
        }
    }

    private Box createBox(char alphabetIndex, HashMap<Character, Box> catalog) {
        if (catalog.containsKey(alphabetIndex)) {
            return catalog.get(alphabetIndex);
        }
        return new Box();
    }

    private void printLetterLibrary(char index, HashMap<Character, Box> catalog) {
        Box box = catalog.get(index);
        if (!(box == null)) {
            box.arrayListToString();
        } else {
        System.out.println("No records for this letter");
        }
    }

    private void printLetterLibraryWithPosCount(int posCount, char index, HashMap<Character, Box> catalog) {
        Box box = catalog.get(index);
        if (!(box == null)) {
            box.arrayListToStringWithInt(posCount);
        } else {
            System.out.println("No records for this letter");
        }
    }
}



