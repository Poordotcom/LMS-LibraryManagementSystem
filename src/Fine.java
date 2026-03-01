/**
 * كلاس Fine - يمثل الغرامات على التأخير
 * Represents fines for overdue items
 * يستخدم Composition - الغرامة مرتبطة بمعاملة
 */
public class Fine {
    // استخدام final constant
    private static final double FINE_PER_DAY = 1.5;
    
    private String fineId;
    // Composition - الغرامة ترتبط بمعاملة واحدة
    private Transaction transaction;
    private double amount;
    private boolean paid;
    
    // Default Constructor
    public Fine() {
        this.fineId = "";
        this.transaction = null;
        this.amount = 0.0;
        this.paid = false;
    }
    
    // Parameterized Constructor
    public Fine(String fineId, Transaction transaction) {
        this.fineId = fineId;
        this.transaction = transaction;
        this.amount = calculateFineAmount();
        this.paid = false;
    }
    
    // Getters and Setters
    public String getFineId() {
        return fineId;
    }
    
    public void setFineId(String fineId) {
        this.fineId = fineId;
    }
    
    public Transaction getTransaction() {
        return transaction;
    }
    
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
        this.amount = calculateFineAmount();
    }
    
    public double getAmount() {
        return amount;
    }
    
    public boolean isPaid() {
        return paid;
    }
    
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    
    public static double getFinePerDay() {
        return FINE_PER_DAY;
    }
    
    // حساب قيمة الغرامة
    private double calculateFineAmount() {
        if (transaction != null) {
            int overdueDays = transaction.getDaysOverdue();
            return overdueDays * FINE_PER_DAY;
        }
        return 0.0;
    }
    
    // تحديث قيمة الغرامة (في حالة تغير عدد الأيام)
    public void updateAmount() {
        this.amount = calculateFineAmount();
    }
    
    public void displayFine() {
        System.out.println("=================================");
        System.out.println("Fine Details:");
        System.out.println("Fine ID: " + fineId);
        if (transaction != null) {
            System.out.println("Transaction ID: " + transaction.getTransactionId());
            System.out.println("Member: " + transaction.getMember().getName());
            System.out.println("Item: " + transaction.getItem().getTitle());
            System.out.println("Days Overdue: " + transaction.getDaysOverdue());
        }
        System.out.println("Fine Amount: $" + String.format("%.2f", amount));
        System.out.println("Status: " + (paid ? "Paid" : "Unpaid"));
        System.out.println("=================================");
    }
}
