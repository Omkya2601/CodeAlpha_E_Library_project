import java.util.*;

public class LibrarySystem {

    public static void main(String[] args) {
        Library library = new Library();

        // Adding users (authentication)
        library.addUser("user1", "password1");
        library.addUser("user2", "password2");

        // Adding books to the library
        library.addBook("Java Programming", "John Doe", "1234567890");
        library.addBook("Python Basics", "Jane Smith", "0987654321");

        Scanner scanner = new Scanner(System.in);

        // Simulating borrowing and returning
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        // Basic authentication check
        if (library.getUsers().containsKey(username) && library.getUsers().get(username).getPassword().equals(password)) {
            System.out.println("Authentication successful.");
            System.out.println("Available operations: 1 - Borrow a book, 2 - Return a book, 3 - Search books by author");
            int operation = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (operation) {
                case 1:
                    System.out.println("Enter ISBN of the book you want to borrow:");
                    String isbnToBorrow = scanner.nextLine();
                    if (library.borrowBook(isbnToBorrow, username)) {
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book not available or not found.");
                    }
                    break;
                case 2:
                    System.out.println("Enter ISBN of the book you want to return:");
                    String isbnToReturn = scanner.nextLine();
                    if (library.returnBook(isbnToReturn)) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Book not found or already available.");
                    }
                    break;
                case 3:
                    System.out.println("Enter author's name to search for books:");
                    String authorToSearch = scanner.nextLine();
                    List<Book> booksByAuthor = library.getBooksByAuthor(authorToSearch);
                    if (booksByAuthor.isEmpty()) {
                        System.out.println("No books found for author: " + authorToSearch);
                    } else {
                        System.out.println("Books by " + authorToSearch + ":");
                        for (Book book : booksByAuthor) {
                            System.out.println(book.getTitle() + " - " + book.getIsbn());
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid operation.");
            }
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }
    }
}