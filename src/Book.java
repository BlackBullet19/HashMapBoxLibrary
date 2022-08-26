public class Book {

    private String name;
    private String author;
    private int pageCount;

    public Book(String name, String author, int pageCount) {
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
    }

    public char getAlphabetIndex () {
        char alphabetIndex=name.toLowerCase().charAt(0);
        return alphabetIndex;
    }

    @Override
    public String toString() {
        return "Book name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pageCount=" + pageCount;
    }
}
