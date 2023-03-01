
public class Book {
    private String title;
    private String author;
    private double price;
    private int id;
    private int quantity=1;
    // additional fields and methods
    
    public Book(int id, String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.id = id;
        this.quantity = 1;

    }
    public Book(int id, String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.id = id;
        this.quantity = quantity;

    }
    
    // getters and setters for title, author, and price

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
