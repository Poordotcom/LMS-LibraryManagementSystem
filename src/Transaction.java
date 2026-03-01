import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * كلاس Transaction - يمثل معاملات الاستعارة والإرجاع
 * Represents borrowing and return transactions
 * يستخدم Composition - يحتوي على LibraryItem و Member
 */
public class Transaction {
    private String transactionId;
    // Composition - المعاملة تحتوي على عنصر من المكتبة
    private LibraryItem item;
    // Composition - المعاملة تحتوي على عضو
    private Member member;
    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private boolean returned;
    
    // Default Constructor
    public Transaction() {
        this.transactionId = "";
        this.item = null;
        this.member = null;
        this.borrowDate = new Date();
        this.dueDate = new Date();
        this.returnDate = null;
        this.returned = false;
    }
    
    // Parameterized Constructor
    public Transaction(String transactionId, LibraryItem item, Member member, int borrowDays) {
        this.transactionId = transactionId;
        this.item = item;
        this.member = member;
        this.borrowDate = new Date();
        
        // حساب تاريخ الاستحقاق
        long dueTimeMillis = borrowDate.getTime() + (borrowDays * 24L * 60 * 60 * 1000);
        this.dueDate = new Date(dueTimeMillis);
        
        this.returnDate = null;
        this.returned = false;
    }
    
    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }
    
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    
    public LibraryItem getItem() {
        return item;
    }
    
    public void setItem(LibraryItem item) {
        this.item = item;
    }
    
    public Member getMember() {
        return member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }
    
    public Date getBorrowDate() {
        return borrowDate;
    }
    
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
    
    public Date getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
    public Date getReturnDate() {
        return returnDate;
    }
    
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
        this.returned = true;
    }
    
    public boolean isReturned() {
        return returned;
    }
    
    // حساب عدد أيام التأخير
    public int getDaysOverdue() {
        if (returned) {
            // إذا تم الإرجاع، نحسب التأخير بناءً على تاريخ الإرجاع
            long diff = returnDate.getTime() - dueDate.getTime();
            int days = (int) TimeUnit.MILLISECONDS.toDays(diff);
            return days > 0 ? days : 0;
        } else {
            // إذا لم يتم الإرجاع بعد، نحسب التأخير حتى الآن
            long diff = new Date().getTime() - dueDate.getTime();
            int days = (int) TimeUnit.MILLISECONDS.toDays(diff);
            return days > 0 ? days : 0;
        }
    }
    
    public boolean isOverdue() {
        return !returned && new Date().after(dueDate);
    }
    
    public void displayTransaction() {
        System.out.println("=================================");
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Item: " + item.getTitle());
        System.out.println("Member: " + member.getName());
        System.out.println("Borrow Date: " + borrowDate);
        System.out.println("Due Date: " + dueDate);
        if (returned) {
            System.out.println("Return Date: " + returnDate);
            System.out.println("Status: Returned");
        } else {
            System.out.println("Status: Active");
            if (isOverdue()) {
                System.out.println("OVERDUE by " + getDaysOverdue() + " days!");
            }
        }
        System.out.println("=================================");
    }
}
