/**
 * كلاس -> Book - يمثل الكتب في المكتبة
 * Represents books in the library
 * يرث من -> LibraryItem ويطبق -> Borrowable و Renewable (Implementation)
 */
public class Book extends LibraryItem implements Borrowable, Renewable {
    // final constant - استخدام
    private static final int MAX_BORROW_DAYS = 14;
    private static final int MAX_RENEWALS = 2;

    private String isbn;
    private String author;
    private int pages;
    private String category;
    private Member currentBorrower;
    private int renewalCount;

    // Default Constructor
    public Book() {
        super();
        this.isbn = "";
        this.author = "";
        this.pages = 0;
        this.category = "";
        this.currentBorrower = null;
        this.renewalCount = 0;
    }

    // Parameterized Constructor
    public Book(String itemId, String title, String publisher, int publicationYear,
            String isbn, String author, int pages, String category) {
        super(itemId, title, publisher, publicationYear);
        this.isbn = isbn;
        this.author = author;
        this.pages = pages;
        this.category = category;
        this.currentBorrower = null;
        this.renewalCount = 0;
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Member getCurrentBorrower() {
        return currentBorrower;
    }

    public static int getMaxBorrowDays() {
        return MAX_BORROW_DAYS;
    }

    // Implementation of abstract method من LibraryItem
    @Override
    public String getType() {
        return "Book";
    }

    // Override displayDetails() - Polymorphism
    @Override
    public void displayDetails() {
        System.out.println("=================================");
        System.out.println("Book Details:");
        System.out.println(toString());
        System.out.println("ISBN: " + isbn);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Category: " + category);
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
            this.renewalCount = 0;
            member.setBorrowedBooksCount(member.getBorrowedBooksCount() + 1);
            System.out.println("Book borrowed successfully! - تم استعارة الكتاب بنجاح!");
            return true;
        }
        System.out.println("Cannot borrow this book.");
        return false;
    }

    @Override
    public boolean returnItem() {
        if (!available && currentBorrower != null) {
            this.available = true;
            currentBorrower.setBorrowedBooksCount(currentBorrower.getBorrowedBooksCount() - 1);
            this.currentBorrower = null;
            this.renewalCount = 0;
            System.out.println("Book returned successfully!");
            return true;
        }
        System.out.println("Cannot return this book.");
        return false;
    }

    // Implementation of Renewable interface
    @Override
    public boolean renew() {
        if (canRenew()) {
            renewalCount++;
            System.out.println("Book renewed successfully! Renewals: " + renewalCount + "/" + MAX_RENEWALS);
            return true;
        }
        System.out.println("Cannot renew this book. Maximum renewals reached.");
        return false;
    }

    @Override
    public boolean canRenew() {
        return !available && currentBorrower != null && renewalCount < MAX_RENEWALS;
    }
}
