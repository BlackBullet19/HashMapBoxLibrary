import java.util.ArrayList;
import java.util.List;

public class Box {

    private List<Book> books;

    public Box() {
        this.books = new ArrayList<>();
    }

    public void pushBook(Book book) {
        books.add(book);
    }

    public void arrayListToString() {
        for (int i = 0; i < books.size(); i++)
            System.out.println(books.get(i));
    }

    public void arrayListToStringWithInt(int posCount) {
        for (int i = 0; i < posCount; i++)
            if (posCount > books.size()) {
                System.out.println("There are less elements in list than your number");
                break;
            } else {
                System.out.println(books.get(i));
            }
    }
}
