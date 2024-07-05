import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, User> users; // Map of usernames to User objects
    private List<Book> books; // List of books in the library

    public Library() {
        users = new HashMap<>();
        books = new ArrayList<>();
    }

    // Method to add a new user to the library
    public void addUser(String username, String password) {
        users.put(username, new User(username, password));
    }

    // Method to add a new book to the library
    public void addBook(String title, String author, String isbn) {
        books.add(new Book(title, author, isbn));
    }

    // Method to check out a book
    public boolean borrowBook(String isbn, String username) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                book.setAvailable(false);
                return true;
            }
        }
        return false; // Book not found or not available
    }

    // Method to return a book
    public boolean returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && !book.isAvailable()) {
                book.setAvailable(true);
                return true;
            }
        }
        return false; // Book not found or already available
    }

    // Method to categorize books by author
    public List<Book> getBooksByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }
}