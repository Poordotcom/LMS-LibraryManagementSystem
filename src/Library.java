import java.util.ArrayList;

/**
 * كلاس Library - الكلاس الرئيسي لإدارة المكتبة
 * Main library management class
 * يستخدم Composition - يحتوي على مجموعات من الكتب والأعضاء والمعاملات
 */
public class Library {
    private String libraryName;
    private String address;
    
    // Composition - المكتبة تحتوي على مجموعات من الكائنات
    private ArrayList<Book> books;
    private ArrayList<Magazine> magazines;
    private ArrayList<Member> members;
    private ArrayList<Employee> employees;
    private ArrayList<Transaction> transactions;
    private ArrayList<Fine> fines;
    
    private int transactionCounter;
    private int fineCounter;
    
    // Default Constructor
    public Library() {
        this.libraryName = "";
        this.address = "";
        this.books = new ArrayList<>();
        this.magazines = new ArrayList<>();
        this.members = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.fines = new ArrayList<>();
        this.transactionCounter = 1;
        this.fineCounter = 1;
    }
    
    // Parameterized Constructor
    public Library(String libraryName, String address) {
        this.libraryName = libraryName;
        this.address = address;
        this.books = new ArrayList<>();
        this.magazines = new ArrayList<>();
        this.members = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.fines = new ArrayList<>();
        this.transactionCounter = 1;
        this.fineCounter = 1;
    }
    
    // Getters
    public String getLibraryName() {
        return libraryName;
    }
    
    public String getAddress() {
        return address;
    }
    
    // ===== إدارة الكتب (Book Management) =====
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }
    
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    
    public Book searchBookById(String id) {
        for (Book book : books) {
            if (book.getItemId().equals(id)) {
                return book;
            }
        }
        return null;
    }
    
    public void displayAllBooks() {
        System.out.println("\n========== All Books ==========");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                book.displayDetails();
            }
        }
    }
    
    public void displayAvailableBooks() {
        System.out.println("\n========== Available Books ==========");
        boolean found = false;
        for (Book book : books) {
            if (book.isAvailable()) {
                book.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available books at the moment.");
        }
    }
    
    // ===== إدارة المجلات (Magazine Management) =====
    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
        System.out.println("Magazine added successfully!");
    }
    
    public void displayAllMagazines() {
        System.out.println("\n========== All Magazines ==========");
        if (magazines.isEmpty()) {
            System.out.println("No magazines in the library.");
        } else {
            for (Magazine magazine : magazines) {
                magazine.displayDetails();
            }
        }
    }
    
    // ===== إدارة الأعضاء (Member Management) =====
    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Member registered successfully!");
    }
    
    public Member searchMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMembershipId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
    
    public void displayAllMembers() {
        System.out.println("\n========== All Members ==========");
        if (members.isEmpty()) {
            System.out.println("No registered members.");
        } else {
            for (Member member : members) {
                member.displayInfo();
            }
        }
    }
    
    // ===== إدارة الموظفين (Employee Management) =====
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }
    
    public void displayAllEmployees() {
        System.out.println("\n========== All Employees ==========");
        if (employees.isEmpty()) {
            System.out.println("No employees.");
        } else {
            for (Employee employee : employees) {
                employee.displayInfo();
            }
        }
    }
    
    // ===== عمليات الاستعارة (Borrowing Operations) =====
    public boolean borrowBook(String bookId, String memberId) {
        Book book = searchBookById(bookId);
        Member member = searchMemberById(memberId);
        
        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }
        
        if (member == null) {
            System.out.println("Member not found!");
            return false;
        }
        
        if (!book.isAvailable()) {
            System.out.println("Book is not available!");
            return false;
        }
        
        if (!member.canBorrowMore()) {
            System.out.println("Member has reached the maximum borrowing limit!");
            return false;
        }
        
        // تنفيذ الاستعارة
        if (book.borrow(member)) {
            Transaction transaction = new Transaction(
                "T" + String.format("%04d", transactionCounter++),
                book,
                member,
                Book.getMaxBorrowDays()
            );
            transactions.add(transaction);
            member.addTransaction(transaction);
            System.out.println("Transaction created: " + transaction.getTransactionId());
            return true;
        }
        
        return false;
    }
    
    // ===== عمليات الإرجاع (Return Operations) =====
    public boolean returnBook(String bookId) {
        Book book = searchBookById(bookId);
        
        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }
        
        if (book.isAvailable()) {
            System.out.println("Book is already available (not borrowed)!");
            return false;
        }
        
        // البحث عن المعاملة النشطة
        Transaction activeTransaction = null;
        for (Transaction t : transactions) {
            if (!t.isReturned() && t.getItem().equals(book)) {
                activeTransaction = t;
                break;
            }
        }
        
        if (activeTransaction == null) {
            System.out.println("No active transaction found for this book!");
            return false;
        }
        
        // إرجاع الكتاب
        if (book.returnItem()) {
            activeTransaction.setReturnDate(new java.util.Date());
            
            // التحقق من وجود غرامة
            if (activeTransaction.getDaysOverdue() > 0) {
                Fine fine = new Fine("F" + String.format("%04d", fineCounter++), activeTransaction);
                fines.add(fine);
                System.out.println("\n*** FINE APPLIED ***");
                fine.displayFine();
            }
            
            return true;
        }
        
        return false;
    }
    
    // ===== تجديد الاستعارة (Renew Borrowing) =====
    public boolean renewBook(String bookId) {
        Book book = searchBookById(bookId);
        
        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }
        
        if (book instanceof Renewable) {
            return ((Renewable) book).renew();
        }
        
        System.out.println("This item cannot be renewed!");
        return false;
    }
    
    // ===== عرض المعاملات (Display Transactions) =====
    public void displayAllTransactions() {
        System.out.println("\n========== All Transactions ==========");
        if (transactions.isEmpty()) {
            System.out.println("No transactions.");
        } else {
            for (Transaction transaction : transactions) {
                transaction.displayTransaction();
            }
        }
    }
    
    public void displayActiveTransactions() {
        System.out.println("\n========== Active Transactions ==========");
        boolean found = false;
        for (Transaction transaction : transactions) {
            if (!transaction.isReturned()) {
                transaction.displayTransaction();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No active transactions.");
        }
    }
    
    // ===== عرض الغرامات (Display Fines) =====
    public void displayAllFines() {
        System.out.println("\n========== All Fines ==========");
        if (fines.isEmpty()) {
            System.out.println("No fines.");
        } else {
            for (Fine fine : fines) {
                fine.displayFine();
            }
        }
    }
    
    public void displayUnpaidFines() {
        System.out.println("\n========== Unpaid Fines ==========");
        boolean found = false;
        for (Fine fine : fines) {
            if (!fine.isPaid()) {
                fine.displayFine();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No unpaid fines.");
        }
    }
    
    // ===== دفع الغرامة (Pay Fine) =====
    public boolean payFine(String fineId) {
        for (Fine fine : fines) {
            if (fine.getFineId().equals(fineId) && !fine.isPaid()) {
                fine.setPaid(true);
                System.out.println("Fine paid successfully!");
                return true;
            }
        }
        System.out.println("Fine not found or already paid!");
        return false;
    }
}
