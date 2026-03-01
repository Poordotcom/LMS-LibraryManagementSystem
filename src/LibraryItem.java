/**
 * الكلاس المجرد LibraryItem - الكلاس الأب لجميع العناصر في المكتبة
 * Abstract base class for all library items
 */
public abstract class LibraryItem {
    // استخدام protected للوصول من الكلاسات الموروثة
    protected String itemId;
    protected String title;
    protected String publisher;
    protected int publicationYear;
    protected boolean available;
    
    // Default Constructor
    public LibraryItem() {
        this.itemId = "";
        this.title = "";
        this.publisher = "";
        this.publicationYear = 0;
        this.available = true;
    }
    
    // Parameterized Constructor
    public LibraryItem(String itemId, String title, String publisher, int publicationYear) {
        this.itemId = itemId;
        this.title = title;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.available = true;
    }
    
    // Getters and Setters
    public String getItemId() {
        return itemId;
    }
    
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public int getPublicationYear() {
        return publicationYear;
    }
    
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    // Abstract Methods
    public abstract String getType();
    public abstract void displayDetails();
    
    @Override
    public String toString() {
        return String.format("ID: %s, Title: %s, Publisher: %s, Year: %d, Available: %s",
                           itemId, title, publisher, publicationYear, 
                           available ? "Yes" : "No");
    }
}
