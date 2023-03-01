import java.util.HashMap;
import java.util.Scanner;
public class CartManager {
    private HashMap<Integer, Cart> carts;
    private float shippingFee=0;
    // additional fields and methods
    
    public CartManager() {
        carts = new HashMap<Integer, Cart>();
    }
    
    public void addCart(Cart cart) {
        carts.put(cart.getCustomer().getId(), cart);
    }
    
    public Cart getCartByCustomerId(int id) {
        for (Cart cart : carts.values()) {
            if (cart.getCustomer().getId() == id) {
                return cart;
            }
        }
        return null;
    }

    // additional methods for updating and deleting carts
    
    public void addCart(CustomerManager customerManager, BookManager bookManager, Scanner scanner) {
        System.out.println("Enter customer id: ");
        String idstr = scanner.nextLine();
        int id = Integer.parseInt(idstr);
        Customer customer = customerManager.getCustomerById(id);
        if (customer == null) {
            System.out.println("Customer does not exist");
        } else {
            Cart cart = this.getCartByCustomerId(id);
            if (cart == null) {
                cart = new Cart(customer);
                this.addCart(cart);
            }
            System.out.println("Enter book id: ");
            String bookIdStr = scanner.nextLine();
            int bookId = Integer.parseInt(bookIdStr);
            Book book = bookManager.getBookById(bookId);
            if (book == null) {
                System.out.println("Book does not exist");
            } else {
                System.out.println("Enter quantity: ");
                String quantityStr = scanner.nextLine();
                int quantity = Integer.parseInt(quantityStr);
                cart.addItem(book, quantity);
            }
        }
    }

    public void removeCart(CustomerManager customerManager, BookManager bookManager, Scanner scanner) {
        System.out.println("Enter customer id: ");
        String idstr = scanner.nextLine();
        int id = Integer.parseInt(idstr);
        Customer customer = customerManager.getCustomerById(id);
        if (customer == null) {
            System.out.println("Customer does not exist");
            customerManager.addCustomer(scanner);
        } else {
            Cart cart = this.getCartByCustomerId(id);
            if (cart == null) {
                System.out.println("Cart does not exist");
            } else {
                carts.remove(id);
            }
        }
    }

    public float getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(float shippingFee) {
        this.shippingFee = shippingFee;
    }

    public void getCartInfo(CustomerManager customerManager, BookManager bookManager, Scanner scanner) {
        System.out.println("Enter customer id: ");
        String idstr = scanner.nextLine();
        int id = Integer.parseInt(idstr);
        Customer customer = customerManager.getCustomerById(id);
        if (customer == null) {
            System.out.println("Customer does not exist");
        } else {
            Cart cart = this.getCartByCustomerId(id);
            if (cart == null) {
                System.out.println("Cart does not exist");
            } else {
                System.out.println("Customer: " + customer.getName());
                System.out.println("Cart: ");
                for (CartItem item : cart.getItems()) {
                    System.out.println("Book: " + bookManager.getBookById(item.getBook().getId()).getTitle());
                    System.out.println("Quantity: " + item.getQuantity());
                    System.out.println("Price: " + item.getBook().getPrice());
                    System.out.println("Total: " + item.getSubtotal());
                }
                System.out.println("Shipping fee: " + this.getShippingFee());
                System.out.println("Total: " + cart.getTotal());
            }
        }
    }
}
