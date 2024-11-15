package BookBuddies;
import java.util.ArrayList;
import java.util.Scanner;

public class BookShop {
    private ArrayList<Book> bookList = new ArrayList<>(); // List to store books
    private Scanner sc = new Scanner(System.in);
    public void uploadBook() {
        System.out.println("Enter Book Name: ");
        String bookName = sc.nextLine();

        System.out.println("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.println("Enter Book Price: ");
        double price = sc.nextDouble();

        System.out.println("Enter Book ID: ");
        int bookID = sc.nextInt();
        sc.nextLine(); 
        // Create a new book and add it to the list
        Book newBook = new Book(bookName, price, bookID, author);
        bookList.add(newBook);

        System.out.println("Book uploaded successfully!\n");
    }
    public void displayBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books available in the shop.\n");
        } else {
            System.out.println("List of Available Books:\n");
            for (Book book : bookList) {
                book.displayBookDetails();
                System.out.println("-------------------------------");
            }
        }
    }
    public void buyBook() {
        System.out.println("Enter the Book ID to buy: ");
        int bookID = sc.nextInt();

        // Search for the book by ID
        Book bookToBuy = null;
        for (Book book : bookList) {
            if (book.bookID == bookID) {
                bookToBuy = book;
                break;
            }
        }

        if (bookToBuy != null) {
            System.out.println("You have selected the book: " + bookToBuy.bookName);
            System.out.println("Price: ₹" + bookToBuy.price);
            System.out.println("Do you want to buy this book? (yes/no): ");
            sc.nextLine();
            String response = sc.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                System.out.println("You have successfully bought the book: " + bookToBuy.bookName);
                bookList.remove(bookToBuy);
            } else {
                System.out.println("You decided not to buy the book.\n");
            }
        } else {
            System.out.println("Book with ID " + bookID + " not found!\n");
        }
    }

    public static void main(String[] args) {
        BookShop bookShop = new BookShop();
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Book Shop!");
            System.out.println("1. Upload a Book");
            System.out.println("2. Display Available Books");
            System.out.println("3. Buy a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bookShop.uploadBook();
                    break;
                case 2:
                    bookShop.displayBooks();
                    break;
                case 3:
                    bookShop.buyBook();
                    break;
                case 4:
                    System.out.println("Thank you for visiting the Book Shop!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }
}
