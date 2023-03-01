import java.util.ArrayList;
public class Cart {
   private Customer customer;
   private ArrayList<CartItem> items;
   // additional fields and methods
   
   public Cart(Customer customer) {
       this.customer = customer;
       items = new ArrayList<CartItem>();
   }

   public Cart(int id, Customer customer) {
       this.customer = customer;
       items = new ArrayList<CartItem>();
   }
   
   public void addItem(Book book, int quantity) {
       items.add(new CartItem(book, quantity));
   }
   
   public void removeItem(CartItem item) {
       items.remove(item);
   }
   
   public double getTotal() {
       double total = 0;
       for (CartItem item : items) {
           total += item.getSubtotal();
       }
       return total;
   }
   
   // getters and setters for customer and items

   public Customer getCustomer() {
       return customer;
   }

   public void setCustomer(Customer customer) {
       this.customer = customer;
   }

   public ArrayList<CartItem> getItems() {
       return items;
   }

   public void setItems(ArrayList<CartItem> items) {
       this.items = items;
   }

   
}
