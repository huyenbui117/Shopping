
public class CartItem {
    private Book book;
    private int quantity;
    // additional fields and methods
    
    public CartItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }
    
    public double getSubtotal() {
        return book.getPrice() * quantity;
    }
    
    // getters and setters for book and quantity

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    

}