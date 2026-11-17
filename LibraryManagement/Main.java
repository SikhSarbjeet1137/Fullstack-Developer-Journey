
public class Main {

    public static void main(String[] args) {

        LibraryService library = new LibraryService();

        try {

            // Add books
            library.addBook(new Book(101, "Java Programming", "James Gosling"));
            library.addBook(new Book(102, "Python Basics", "Guido van Rossum"));
            library.addBook(new Book(103, "React Guide", "Dan Abramov"));
            library.addBook(new Book(104, "Spring Boot", "Rod Johnson"));

            // Display all books
            System.out.println("\n--- ALL BOOKS ---");
            library.displayBooks();

            // Search book
            System.out.println("\n--- SEARCH BOOK ---");

            Book searchedBook = library.searchBook(102);

            if (searchedBook != null) {
                searchedBook.displayBook();
            } else {
                System.out.println("Book not found.");
            }

            // Mark book as unavailable
            Book book = library.searchBook(102);

            if (book != null) {
                book.setAvailable(false);
            }

            // Sort books
            System.out.println("\n--- SORTED BOOKS ---");
            library.sortBooksByTitle();

            // Display available books
            System.out.println("\n--- AVAILABLE BOOKS ---");
            library.displayAvailableBooks();

            // Remove book
            System.out.println("\n--- REMOVE BOOK ---");

            if (library.removeBook(103)) {
                System.out.println("Book removed successfully!");
            } else {
                System.out.println("Book not found.");
            }

            // Display final records
            System.out.println("\n--- FINAL BOOK RECORDS ---");
            library.displayBooks();

        } catch (InvalidBookException e) {

            System.out.println("Error: " + e.getMessage());

        }
    }
}
