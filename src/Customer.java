public class Customer {
    private String name;
    private String email;
    private int id=-1;
    // additional fields and methods
    
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public Customer(int id, String name, String email) {
        this.name = name;
        this.email = email;
        this.id = id;
    }
    
    
    // getters and setters for name and email
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

