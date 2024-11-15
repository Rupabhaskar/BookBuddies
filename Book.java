package BookBuddies;
class Book {
    String bookName;
    double price;
    int bookID;
    String author;
    public Book(String bookName, double price, int bookID, String author) {
        this.bookName = bookName;
        this.price = price;
        this.bookID = bookID;
        this.author = author;
    }
    public void displayBookDetails() {
        System.out.println("Book ID: " + bookID);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }
}

