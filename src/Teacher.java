/**
 * كلاس Teacher - يمثل المعلمين/الأساتذة الأعضاء في المكتبة
 * Represents teacher members of the library
 * يرث من Member (Inheritance)
 */
public class Teacher extends Member {
    // استخدام final constant
    private static final int MAX_BOOKS_FOR_TEACHER = 5;
    
    private String department;
    private String specialization;
    
    // Default Constructor
    public Teacher() {
        super();
        this.department = "";
        this.specialization = "";
    }
    
    // Parameterized Constructor
    public Teacher(String id, String name, String email, String phone, 
                   String membershipId, String department, String specialization) {
        super(id, name, email, phone, membershipId);
        this.department = department;
        this.specialization = specialization;
    }
    
    // Getters and Setters
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    // Implementation of abstract methods
    @Override
    public String getRole() {
        return "Teacher";
    }
    
    @Override
    public int getMaxBooksAllowed() {
        return MAX_BOOKS_FOR_TEACHER;
    }
    
    // Override displayInfo() - Polymorphism
    @Override
    public void displayInfo() {
        System.out.println("=================================");
        System.out.println("Teacher Information:");
        System.out.println(toString());
        System.out.println("Membership ID: " + getMembershipId());
        System.out.println("Department: " + department);
        System.out.println("Specialization: " + specialization);
        System.out.println("Borrowed Books: " + getBorrowedBooksCount() + "/" + MAX_BOOKS_FOR_TEACHER);
        System.out.println("=================================");
    }
}
