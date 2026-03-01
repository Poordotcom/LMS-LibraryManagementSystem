/**
 * كلاس Student - يمثل الطلاب الأعضاء في المكتبة
 * Represents student members of the library
 * يرث من Member (Inheritance)
 */
public class Student extends Member {
    // استخدام final constant
    private static final int MAX_BOOKS_FOR_STUDENT = 3;
    
    private String major;
    private int year;
    
    // Default Constructor
    public Student() {
        super();
        this.major = "";
        this.year = 1;
    }
    
    // Parameterized Constructor - استخدام super()
    public Student(String id, String name, String email, String phone, 
                   String membershipId, String major, int year) {
        super(id, name, email, phone, membershipId);
        this.major = major;
        this.year = year;
    }
    
    // Getters and Setters
    public String getMajor() {
        return major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    // Implementation of abstract methods
    @Override
    public String getRole() {
        return "Student";
    }
    
    @Override
    public int getMaxBooksAllowed() {
        return MAX_BOOKS_FOR_STUDENT;
    }
    
    // Override displayInfo() - Polymorphism
    @Override
    public void displayInfo() {
        System.out.println("=================================");
        System.out.println("Student Information:");
        System.out.println(toString());
        System.out.println("Membership ID: " + getMembershipId());
        System.out.println("Major: " + major);
        System.out.println("Year: " + year);
        System.out.println("Borrowed Books: " + getBorrowedBooksCount() + "/" + MAX_BOOKS_FOR_STUDENT);
        System.out.println("=================================");
    }
}
