/**
 * كلاس Magazine - يمثل المجلات في المكتبة
 * Represents magazines in the library
 * يرث من LibraryItem ويطبق Borrowable (Implementation)
 */
public class Magazine extends LibraryItem implements Borrowable {
    private static final int MAX_BORROW_DAYS = 7;
    
    private int issueNumber;
    private String month;
    private Member currentBorrower;
    
    // Default Constructor
    public Magazine() {
        super();
        this.issueNumber = 0;
        this.month = "";
        this.currentBorrower = null;
    }
    
    // Parameterized Constructor
    public Magazine(String itemId, String title, String publisher, int publicationYear,
                   int issueNumber, String month) {
        super(itemId, title, publisher, publicationYear);
        this.issueNumber = issueNumber;
        this.month = month;
        this.currentBorrower = null;
    }
    
    // Getters and Setters
    public int getIssueNumber() {
        return issueNumber;
    }
    
    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
    
    public String getMonth() {
        return month;
    }
    
    public void setMonth(String month) {
        this.month = month;
    }
    
    public static int getMaxBorrowDays() {
        return MAX_BORROW_DAYS;
    }
    
    // Implementation of abstract method من LibraryItem
    @Override
    public String getType() {
        return "Magazine";
    }
    
    // Override displayDetails() - Polymorphism
    @Override
    public void displayDetails() {
        System.out.println("=================================");
        System.out.println("Magazine Details:");
        System.out.println(toString());
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Month: " + month);
        System.out.println("Status: " + (available ? "Available" : "Borrowed"));
        if (currentBorrower != null) {
            System.out.println("Borrowed by: " + currentBorrower.getName());
        }
        System.out.println("=================================");
    }
    
    // Implementation of Borrowable interface
    @Override
    public boolean borrow(Member member) {
        if (available && member.canBorrowMore()) {
            this.available = false;
            this.currentBorrower = member;
            member.setBorrowedBooksCount(member.getBorrowedBooksCount() + 1);
            System.out.println("Magazine borrowed successfully!");
            return true;
        }
        System.out.println("Cannot borrow this magazine.");
        return false;
    }
    
    @Override
    public boolean returnItem() {
        if (!available && currentBorrower != null) {
            this.available = true;
            currentBorrower.setBorrowedBooksCount(currentBorrower.getBorrowedBooksCount() - 1);
            this.currentBorrower = null;
            System.out.println("Magazine returned successfully!");
            return true;
        }
        System.out.println("Cannot return this magazine.");
        return false;
    }
}
