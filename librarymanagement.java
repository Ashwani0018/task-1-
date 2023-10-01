import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Book {
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
}
class Library {
    private List<Book> books;
    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }
    public List<Book> getAllBooks() {
        return books;
    }
}
public class librarymanagement {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a book");
            System.out.println("2. Search for books");
            System.out.println("3. List all books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book: ");
                    String title = sc.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = sc.nextLine();
                    Book newBook = new Book(title, author);
                    library.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.print("Enter a search query: ");
                    String query = sc.nextLine();
                    List<Book> searchResults = library.searchBooks(query);
                    if (searchResults.isEmpty()) {
                        System.out.println("No books found matching the query.");
                    } else {
                        System.out.println("Search results:");
                        for (Book book : searchResults) {
                            System.out.println(book.getTitle() + " by " + book.getAuthor());
                        }
                    }
                    break;
                case 3:
                    List<Book> allBooks = library.getAllBooks();
                    if (allBooks.isEmpty()) {
                        System.out.println("The library is empty.");
                    } else {
                        System.out.println("All books in the library:");
                        for (Book book : allBooks) {
                            System.out.println(book.getTitle() + " by " + book.getAuthor());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting the library management system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
