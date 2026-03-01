/**
 * كلاس Employee - يمثل موظفي المكتبة
 * Represents library employees who manage operations
 * يرث من Person (Inheritance)
 */
public class Employee extends Person {
    private String employeeId;
    private String position;
    private double salary;
    
    // Default Constructor
    public Employee() {
        super();
        this.employeeId = "";
        this.position = "";
        this.salary = 0.0;
    }
    
    // Parameterized Constructor
    public Employee(String id, String name, String email, String phone,
                   String employeeId, String position, double salary) {
        super(id, name, email, phone);
        this.employeeId = employeeId;
        this.position = position;
        this.salary = salary;
    }
    
    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    // Implementation of abstract methods من Person
    @Override
    public String getRole() {
        return "Employee";
    }
    
    // Override displayInfo() - Polymorphism
    @Override
    public void displayInfo() {
        System.out.println("=================================");
        System.out.println("Employee Information:");
        System.out.println(toString());
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Position: " + position);
        System.out.println("Salary: $" + salary);
        System.out.println("=================================");
    }
}
