import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookManager {
    private HashMap<Integer, Book> books;
    // additional fields and methods
    // quantity of each book in the store
    public BookManager() {
        books = new HashMap<Integer, Book>();
    }

    // add a book to the store
    public void addBook(Book book) {
        if (books.containsKey(book.getId())) {
            books.get(book.getId()).setQuantity(books.get(book.getId()).getQuantity() + book.getQuantity());
        } else {
            books.put(book.getId(), book);
        }
    }
    public void addBook(int id, String title, String author, double price, int quantity) {
        if (books.containsKey(id)) {
            books.get(id).setQuantity(books.get(id).getQuantity() + quantity);
        } else {
            books.put(id, new Book(id, title, author, price, quantity));
        }
    }
    public void addBook(int id, String title, String author, double price) {
        if (books.containsKey(id)) {
            books.get(id).setQuantity(books.get(id).getQuantity() + 1);
        } else {
            books.put(id, new Book(id, title, author, price));
        }
    }
    public void addBook(Scanner scanner) {
        System.out.println("Enter book id: ");
        String idstr = scanner.nextLine();
        int id = Integer.parseInt(idstr);
        if (books.containsKey(id)) {
            System.out.println("Book already exists");
            System.out.println("Enter quantity to add: ");
            String quantitystr = scanner.nextLine();
            int quantity = Integer.parseInt(quantitystr);
            books.get(id).setQuantity(books.get(id).getQuantity() + quantity);
        } else {
            System.out.println("Enter book title: ");
            String title = scanner.nextLine();
            System.out.println("Enter book author: ");
            String author = scanner.nextLine();
            System.out.println("Enter book price: ");
            String pricestr = scanner.nextLine();
            double price = Double.parseDouble(pricestr);
            System.out.println("Enter book quantity: ");
            String quantitystr = scanner.nextLine();
            int quantity = Integer.parseInt(quantitystr);
            this.addBook(id, title, author, price, quantity);
        }
    }
    
    public Book getBookById(int id) {
        return books.get(id);
    }
    
    public ArrayList<Book> getAllBooks() {
        return new ArrayList<Book>(books.values());
    }
    
    // additional methods for updating and deleting books

    // update a book's title, author, price, and quantity
    public void updateBook(Book book) {
        books.put(book.getId(), book);
    }
    public void updateBook(int id, String title, String author, double price, int quantity) {
        if (books.containsKey(id)) {
            books.get(id).setTitle(title);
            books.get(id).setAuthor(author);
            books.get(id).setPrice(price);
        } else {
            System.out.println("Book does not exist");
        }
    }
    public void updateBook(int id, String title, String author, double price) {
        if (books.containsKey(id)) {
            books.get(id).setTitle(title);
            books.get(id).setAuthor(author);
            books.get(id).setPrice(price);
        } else {
            System.out.println("Book does not exist");
        }
    }
    public void updateBook(Scanner scanner){
        System.out.println("Enter book id: ");
        
        String idstr = scanner.nextLine();
        int id = Integer.parseInt(idstr);
        if (books.containsKey(id)) {
            System.out.println("Enter book title: ");
            String title = scanner.nextLine();
            System.out.println("Enter book author: ");
            String author = scanner.nextLine();
            System.out.println("Enter book price: ");
            double price = scanner.nextDouble();
            this.updateBook(id, title, author, price);
        } else {
            System.out.println("Book does not exist");
        }
    }

    // delete a book from the store
    public void deleteBook(int id) {
        if (books.containsKey(id)) {
            books.remove(id);
        } else {
            System.out.println("Book does not exist");
        }
    }
    public void deleteBook(Scanner scanner) {
        System.out.println("Enter book id: ");
        String idstr = scanner.nextLine();
        int id = Integer.parseInt(idstr);
        if (books.containsKey(id)) {
            books.remove(id);
        } else {
            System.out.println("Book does not exist");
        }
    }

}
