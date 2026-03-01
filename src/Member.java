import java.util.ArrayList;
import java.util.Date;

/**
 * الكلاس المجرد Member - يمثل أعضاء المكتبة القادرين على الاستعارة
 * Abstract class representing library members who can borrow items
 * يرث من Person (Inheritance)
 */
public abstract class Member extends Person {
    private String membershipId;
    private Date membershipDate;
    private int borrowedBooksCount;
    // Composition - العضو لديه قائمة من المعاملات
    private ArrayList<Transaction> transactions;
    
    // Default Constructor
    public Member() {
        super();
        this.membershipId = "";
        this.membershipDate = new Date();
        this.borrowedBooksCount = 0;
        this.transactions = new ArrayList<>();
    }
    
    // Parameterized Constructor
    public Member(String id, String name, String email, String phone, String membershipId) {
        super(id, name, email, phone);
        this.membershipId = membershipId;
        this.membershipDate = new Date();
        this.borrowedBooksCount = 0;
        this.transactions = new ArrayList<>();
    }
    
    // Getters and Setters
    public String getMembershipId() {
        return membershipId;
    }
    
    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }
    
    public Date getMembershipDate() {
        return membershipDate;
    }
    
    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }
    
    public int getBorrowedBooksCount() {
        return borrowedBooksCount;
    }
    
    public void setBorrowedBooksCount(int borrowedBooksCount) {
        this.borrowedBooksCount = borrowedBooksCount;
    }
    
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
    
    // Abstract method - الحد الأقصى للكتب يختلف حسب نوع العضو
    public abstract int getMaxBooksAllowed();
    
    // Concrete method
    public boolean canBorrowMore() {
        return borrowedBooksCount < getMaxBooksAllowed();
    }
    
    // Override من Person
    @Override
    public void displayInfo() {
        System.out.println("=================================");
        System.out.println("Member Information:");
        System.out.println("Role: " + getRole());
        System.out.println(toString());
        System.out.println("Membership ID: " + membershipId);
        System.out.println("Borrowed Books: " + borrowedBooksCount + "/" + getMaxBooksAllowed());
        System.out.println("=================================");
    }
}
