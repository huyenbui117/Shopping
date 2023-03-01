import java.util.Scanner;
public class App {
    // test BookManager class function
    public static void testBookManager() {
        BookManager bookManager = new BookManager();
        bookManager.addBook(new Book(1, "Java for Dummies", "Barry Burd", 19.99));
        bookManager.addBook(new Book(2, "Java for More Dummies", "Barry Burd", 29.99));
        bookManager.addBook(new Book(3, "More Java for More Dummies", "Barry Burd", 39.99));
        bookManager.addBook(new Book(4, "A Guide to Java Certification", "Kathy Sierra", 49.99));
        bookManager.addBook(new Book(5, "Head First Java", "Kathy Sierra", 59.99));
        
        System.out.println("All books:");
        for (Book book : bookManager.getAllBooks()) {
            System.out.println(book.getTitle());
        }
        
        System.out.println("Book with id 3:");
        System.out.println(bookManager.getBookById(3).getTitle());
        System.out.println(bookManager.getBookById(3).getQuantity());
    }


    // test CustomerManager class function  

    public static void testCustomerManager() {
        CustomerManager customerManager = new CustomerManager();
        customerManager.addCustomer(new Customer(1, "John", "john@abc"));
        customerManager.addCustomer(new Customer(2, "Mary", "mary@abc"));

        System.out.println("All customers:");
        for (Customer customer : customerManager.getAllCustomers()) {
            System.out.println(customer.getName());
        }

        System.out.println("Customer with id 1:");
        System.out.println(customerManager.getCustomerById(1).getName());

    }

    // test CartManager class function

    public static void testCartManager() {
        CartManager cartManager = new CartManager();
        CustomerManager customerManager = new CustomerManager();
        int customer_id = 1;
        if (customerManager.getCustomerById(customer_id) != null) {
            cartManager.addCart(new Cart(customerManager.getCustomerById(customer_id)));
        }
        else {
            // add new customer
            customerManager.addCustomer(new Customer(customer_id, "John", "john@abc"));
            cartManager.addCart(new Cart(customerManager.getCustomerById(customer_id)));
        }

        int book_id = 1;
        int quantity = 1;
        BookManager bookManager = new BookManager();

        if (bookManager.getBookById(book_id) != null && bookManager.getBookById(book_id).getQuantity() >= quantity) {
            cartManager.getCartByCustomerId(customer_id).addItem(bookManager.getBookById(book_id), quantity);
        }
        else {
            System.out.println("Book not found or not enough quantity");
        }

        for (CartItem item : cartManager.getCartByCustomerId(customer_id).getItems()) {
            System.out.println(item.getBook().getTitle());
        }

        System.out.println("Total price of cart of customer 1:");
        System.out.println("Total: " + cartManager.getCartByCustomerId(customer_id).getTotal());

    }
    
    // manage customer
    public static void manageCustomer(CustomerManager customerManager, Scanner sc){
        System.out.println("Welcome to Customer management system, what you want to do?\n" +
        "1. Add Customer \n" + "2. Update Customer \n" + "3. Delete Customer \n" + "4. Get Customer \n" + "5. Get All Customers \n");
        
        String choicestr = sc.nextLine();
        int choice = Integer.parseInt(choicestr);

        switch(choice){
            case 1:
                customerManager.addCustomer(sc);
                break;
            case 2:
                customerManager.updateCustomer(sc);
                break;
            case 3:
                customerManager.deleteCustomer(sc);
                break;
            default: 
                System.out.println("Invalid choice");
                break;
        }
    }

    // manage book
    public static void manageBook(BookManager bookManager, Scanner sc){
        System.out.println("Welcome to Book management system, what you want to do?\n" +
        "1. Add Book \n" + "2. Update Book \n" + "3. Delete Book \n" + "4. Get Book \n" + "5. Get All Books \n");

        String choiceStr = sc.nextLine();
            int choice = Integer.parseInt(choiceStr);;

        switch(choice){
            case 1:
                bookManager.addBook(sc);
                break;
            case 2:
                bookManager.updateBook(sc);
                break;
            case 3:
                bookManager.deleteBook(sc);
                break;
            default: 
                System.out.println("Invalid choice");
                break;
        }
    }

    // manage cart
    public static void manageCart(CartManager cartManager, CustomerManager customerManager, BookManager bookManager, Scanner sc){
        System.out.println("Welcome to Cart management system, what you want to do?\n" +
        "1. Add Cart \n" + "2. Delete Cart \n" + "3. Get Cart INFO");
        
        String choiceStr = sc.nextLine();
            int choice = Integer.parseInt(choiceStr);;

        switch(choice){
            case 1:
                cartManager.addCart(customerManager, bookManager, sc);
                break;
            case 3:
                cartManager.getCartInfo(customerManager, bookManager, sc);
                break;
                
            default: 
                System.out.println("Invalid choice");
                break;
        }
    }
    public static void main(String[] args) throws Exception {
        
        // //test BookManager class function
        // testBookManager();
        // //test CustomerManager class function
        // testCustomerManager();
        // //test CartManager class function
        // testCartManager();
        BookManager bookManager = new BookManager();
        CustomerManager customerManager = new CustomerManager();
        CartManager cartManager = new CartManager();
        
        Scanner sc = new Scanner(System.in);
        while (true){

            System.out.println("Welcome to Book Store Management System, what you want to do?\n" +
            "1. Manage Customer \n" + "2. Manage Book \n" + "3. Manage Cart \n" + "4. Exit \n");
            String choiceStr = sc.nextLine();
            int choice = Integer.parseInt(choiceStr);;
            switch(choice){
                case 1:
                    manageCustomer(customerManager, sc);
                    break;
                case 2:
                    manageBook(bookManager, sc);
                    break;
                case 3:
                    manageCart(cartManager, customerManager, bookManager, sc);
                    break;
                case 4:
                    sc.close();
                    System.out.println("Thank you for using our system");
                    System.exit(0);
                    break;
                default: 
                    System.out.println("Invalid choice");
                    break;
            }
         }
    }
}
