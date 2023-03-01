import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {
    private HashMap<String, Customer> customers;
    // additional fields and methods
    
    public CustomerManager() {
        customers = new HashMap<String, Customer>();
    }
    
    // add a customer to the store
    public void addCustomer(Customer customer) {
        if (customers.containsKey(customer.getEmail())) {
            System.out.println("Customer already exists");
        } else {
            customers.put(customer.getEmail(), customer);
            customer.setId(customers.size());
        }
    }
    public void addCustomer(String name, String email) {
        if (customers.containsKey(email)) {
            System.out.println("Customer already exists");
        } else {
            customers.put(email, new Customer(customers.size() + 1, name, email));
        }
    }
    public void addCustomer(Scanner scanner) {
        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.println("Enter customer email: ");
        String email = scanner.nextLine();
        this.addCustomer(name, email);
    }

    
    public Customer getCustomerByEmail(String email) {
        return customers.get(email);
    }
    
    public Customer getCustomerById(int id) {
        for (Customer customer : customers.values()) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public ArrayList<Customer> getAllCustomers() {
        return new ArrayList<Customer>(customers.values());
    }
    // additional methods for updating and deleting customers

    // update a customer's name and email
    public void updateCustomer(Customer customer) {
        customers.put(customer.getEmail(), customer);
    }
    public void updateCustomer(String email, String name) {
        Customer customer = customers.get(email);
        customer.setName(name);
        customers.put(email, customer);
    }
    public void updateCustomer(Scanner scanner) {
        System.out.println("Enter customer email: ");
        String email = scanner.nextLine();
        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();
        this.updateCustomer(email, name);
    }
    
    
    // delete a customer
    public void deleteCustomer(Customer customer) {
        if (customers.containsKey(customer.getEmail())) {
            customers.remove(customer.getEmail());
        } else {
            System.out.println("Customer does not exist");
        }
    }
    public void deleteCustomer(String email) {
        if (customers.containsKey(email)) {
            customers.remove(email);
        } else {
            System.out.println("Customer does not exist");
        }
    }
    public void deleteCustomer(Scanner scanner) {
        System.out.println("Enter customer email: ");
        String email = scanner.nextLine();
        this.deleteCustomer(email);
    }
    
}
