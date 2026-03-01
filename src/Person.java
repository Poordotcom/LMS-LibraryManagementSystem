/**
 * الكلاس المجرد Person - الكلاس الأب لجميع الأشخاص في النظام
 * Abstract base class for all persons in the library system
 */
public abstract class Person {
    // استخدام private للتغليف (Encapsulation)
    private String id;
    private String name;
    private String email;
    private String phone;
    
    // Default Constructor
    public Person() {
        this.id = "";
        this.name = "";
        this.email = "";
        this.phone = "";
    }
    
    // Parameterized Constructor
    public Person(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    // Abstract Methods - يجب تطبيقها في الكلاسات الموروثة
    public abstract String getRole();
    public abstract void displayInfo();
    
    // Override toString() - Polymorphism
    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Email: %s, Phone: %s", 
                           id, name, email, phone);
    }
}
