
import java.util.*;

public class LibraryService {

    private ArrayList<Book> books = new ArrayList<>();

    private HashMap<Integer, Book> bookMap = new HashMap<>();

    public void addBook(Book book) throws InvalidBookException {

        if (book.getId() <= 0) {
            throw new InvalidBookException("Invalid Book ID");
        }

        if (book.getTitle() == null || book.getTitle().isBlank()) {
            throw new InvalidBookException("Book title cannot be empty");
        }

        if (book.getAuthor() == null || book.getAuthor().isBlank()) {
            throw new InvalidBookException("Author name cannot be empty");
        }

        if (bookMap.containsKey(book.getId())) {
            throw new InvalidBookException("Book ID already exists");
        }

        books.add(book);
        bookMap.put(book.getId(), book);

        System.out.println("Book added successfully!");
        
    }
    public Book searchBook(int id) {

    return bookMap.get(id);
}
public boolean removeBook(int id) {

    Book book = bookMap.remove(id);

    if (book == null) {
        return false;
    }

    books.remove(book);

    return true;
}
public void displayBooks() {

    if (books.isEmpty()) {
        System.out.println("No books available.");
        return;
    }

    for (Book book : books) {
        book.displayBook();
    }
}
public void sortBooksByTitle() {

    List<Book> sortedBooks = books.stream()
            .sorted(Comparator.comparing(
                Book::getTitle,
                String.CASE_INSENSITIVE_ORDER
            ))
            .toList();

    System.out.println("Books sorted by title:");

    sortedBooks.forEach(Book::displayBook);
}
public void displayAvailableBooks() {

    System.out.println("Available Books:");

    books.stream()
            .filter(Book::isAvailable)
            .forEach(Book::displayBook);
}
}
