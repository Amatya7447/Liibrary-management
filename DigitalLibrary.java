package Array_codes;

import java.util.*;

class Book {
    String id, title, author;
    boolean isAvailable;

    public Book(String id, String title, String author, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(String id, String title, String author, boolean isAvailable) {
        for (Book book : books) {
            if (book.id.equals(id)) {
                System.out.println("Book ID must be unique!");
                return;
            }
        }
        books.add(new Book(id, title, author, isAvailable));
        System.out.println("Book added successfully.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBook(String query) {
        for (Book book : books) {
            if (book.id.equalsIgnoreCase(query) || book.title.equalsIgnoreCase(query)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void updateBook(String id, String newTitle, String newAuthor, boolean newAvailability) {
        for (Book book : books) {
            if (book.id.equals(id)) {
                book.title = newTitle;
                book.author = newAuthor;
                book.isAvailable = newAvailability;
                System.out.println("Book details updated.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void deleteBook(String id) {
        books.removeIf(book -> book.id.equals(id));
        System.out.println("Book deleted if it existed.");
    }
}

public class DigitalLibrary {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book\n2. View Books\n3. Search Book\n4. Update Book\n5. Delete Book\n6. Exit");
            System.out.print("Choose an option: ");
            
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next(); // Consume invalid input
                continue;
            }
            
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    boolean available = sc.nextBoolean();
                    sc.nextLine(); // Consume newline
                    library.addBook(id, title, author, available);
                    break;
                case 2:
                    library.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID or Title to search: ");
                    String query = sc.nextLine();
                    library.searchBook(query);
                    break;
                case 4:
                    System.out.print("Enter Book ID to update: ");
                    String updateId = sc.nextLine();
                    System.out.print("New Title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("New Author: ");
                    String newAuthor = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    boolean newAvailability = sc.nextBoolean();
                    sc.nextLine(); // Consume newline
                    library.updateBook(updateId, newTitle, newAuthor, newAvailability);
                    break;
                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    String deleteId = sc.nextLine();
                    library.deleteBook(deleteId);
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

