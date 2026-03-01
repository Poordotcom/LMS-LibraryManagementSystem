import java.util.Scanner;

/**
 * كلاس LibraryManagementSystem - نقطة الدخول الرئيسية للبرنامج
 * Main entry point for the Library Management System
 * يحتوي على main method ويوفر واجهة المستخدم التفاعلية
 */
public class LibraryManagementSystem {
    private static Library library;
    private static Scanner scanner;

    public static void main(String[] args) {
        // تهيئة النظام
        scanner = new Scanner(System.in);
        library = new Library("مكتبة الجامعة المركزية", "شارع العلم، المدينة الجامعية");

        // تحميل بيانات تجريبية
        loadSampleData();

        // عرض الترحيب
        displayWelcome();

        // القائمة الرئيسية
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("اختر الخيار: ");

            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    addNewMagazine();
                    break;
                case 3:
                    registerNewMember();
                    break;
                case 4:
                    borrowBookOperation();
                    break;
                case 5:
                    returnBookOperation();
                    break;
                case 6:
                    renewBookOperation();
                    break;
                case 7:
                    searchBook();
                    break;
                case 8:
                    library.displayAvailableBooks();
                    break;
                case 9:
                    library.displayAllBooks();
                    break;
                case 10:
                    library.displayAllMagazines();
                    break;
                case 11:
                    library.displayAllMembers();
                    break;
                case 12:
                    library.displayActiveTransactions();
                    break;
                case 13:
                    library.displayAllTransactions();
                    break;
                case 14:
                    library.displayUnpaidFines();
                    break;
                case 15:
                    payFineOperation();
                    break;
                case 0:
                    System.out.println("\nشكراً لاستخدام نظام إدارة المكتبة. وداعاً!");
                    running = false;
                    break;
                default:
                    System.out.println("خيار غير صحيح! حاول مرة أخرى.");
            }

            if (running) {
                System.out.println("\nاضغط Enter للمتابعة...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void displayWelcome() {
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║                                                    ║");
        System.out.println("║        نظام إدارة المكتبة - Java OOP              ║");
        System.out.println("║     Library Management System - Java OOP           ║");
        System.out.println("║                                                    ║");
        System.out.println("║        " + library.getLibraryName() + "        ║");
        System.out.println("║                                                    ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.println();
    }

    private static void displayMenu() {
        System.out.println("\n╔════════════════ القائمة الرئيسية ═══════════════════════╗");
        System.out.println("║                                                            ║");
        System.out.println("║  [1]  إضافة كتاب جديد   - add new book                    ║");
        System.out.println("║  [2]  إضافة مجلة جديدة   - add new magazine               ║");
        System.out.println("║  [3]  تسجيل عضو جديد   - register new member              ║");
        System.out.println("║  [4]  استعارة كتاب   - borrow book                        ║");
        System.out.println("║  [5]  إرجاع كتاب   - return book                          ║");
        System.out.println("║  [6]  تجديد استعارة   - renew book                        ║");
        System.out.println("║  [7]  البحث عن كتاب   - search book                       ║");
        System.out.println("║  [8]  عرض الكتب المتاحة   - display available books       ║");
        System.out.println("║  [9]  عرض جميع الكتب   - display all books                ║");
        System.out.println("║  [10] عرض جميع المجلات   - display all magazines           ║");
        System.out.println("║  [11] عرض جميع الأعضاء   - display all members             ║");
        System.out.println("║  [12] عرض المعاملات النشطة   - display active transactions ║");
        System.out.println("║  [13] عرض جميع المعاملات     - display all transactions     ║");
        System.out.println("║  [14] عرض الغرامات غير المدفوعة     - display unpaid fines ║");
        System.out.println("║  [15] دفع غرامة     - pay fine                              ║");
        System.out.println("║  [0]  خروج     - exit                                       ║");
        System.out.println("║                                                             ║");
        System.out.println("╚═════════════════════════════════════════════════════════════╝");
    }

    private static void addNewBook() {
        System.out.println("\n========== إضافة كتاب جديد ==========");

        String id = getStringInput("رقم الكتاب (Book ID) - Book ID: ");
        String title = getStringInput("عنوان الكتاب - Book Title: ");
        String author = getStringInput("المؤلف - Author: ");
        String publisher = getStringInput("الناشر - Publisher: ");
        int year = getIntInput("سنة النشر - Year: ");
        String isbn = getStringInput("رقم ISBN - ISBN: ");
        int pages = getIntInput("عدد الصفحات - Pages: ");
        String category = getStringInput("التصنيف - Category: ");

        Book book = new Book(id, title, publisher, year, isbn, author, pages, category);
        library.addBook(book);
    }

    private static void addNewMagazine() {
        System.out.println("\n========== إضافة مجلة جديدة ==========");

        String id = getStringInput("رقم المجلة (Magazine ID) - Magazine ID: ");
        String title = getStringInput("عنوان المجلة - Magazine Title: ");
        String publisher = getStringInput("الناشر - Publisher: ");
        int year = getIntInput("سنة النشر - Year: ");
        int issueNumber = getIntInput("رقم العدد - Issue Number: ");
        String month = getStringInput("الشهر - Month: ");

        Magazine magazine = new Magazine(id, title, publisher, year, issueNumber, month);
        library.addMagazine(magazine);
    }

    private static void registerNewMember() {
        System.out.println("\n========== تسجيل عضو جديد ==========");

        System.out.println("نوع العضوية: - Member Type:");
        System.out.println("[1] طالب (Student)");
        System.out.println("[2] معلم (Teacher)");
        int type = getIntInput("اختر النوع - Member Type: ");

        String id = getStringInput("رقم الهوية - ID: ");
        String name = getStringInput("الاسم - Name: ");
        String email = getStringInput("البريد الإلكتروني - Email: ");
        String phone = getStringInput("رقم الهاتف - Phone: ");
        String membershipId = getStringInput("رقم العضوية - Membership ID: ");

        if (type == 1) {
            String major = getStringInput("التخصص - Major: ");
            int year = getIntInput("السنة الدراسية - Year: ");
            Student student = new Student(id, name, email, phone, membershipId, major, year);
            library.registerMember(student);
        } else if (type == 2) {
            String department = getStringInput("القسم - Department: ");
            String specialization = getStringInput("التخصص - Specialization: ");
            Teacher teacher = new Teacher(id, name, email, phone, membershipId, department, specialization);
            library.registerMember(teacher);
        } else {
            System.out.println("نوع غير صحيح!");
        }
    }

    private static void borrowBookOperation() {
        System.out.println("\n========== استعارة كتاب - Borrow Book ==========");

        String bookId = getStringInput("رقم الكتاب - Book ID: ");
        String memberId = getStringInput("رقم العضوية - Membership ID: ");

        library.borrowBook(bookId, memberId);
    }

    private static void returnBookOperation() {
        System.out.println("\n========== إرجاع كتاب ==========");

        String bookId = getStringInput("رقم الكتاب: ");
        library.returnBook(bookId);
    }

    private static void renewBookOperation() {
        System.out.println("\n========== تجديد استعارة ==========");

        String bookId = getStringInput("رقم الكتاب: ");
        library.renewBook(bookId);
    }

    private static void searchBook() {
        System.out.println("\n========== البحث عن كتاب ==========");

        String title = getStringInput("عنوان الكتاب: ");
        Book book = library.searchBookByTitle(title);

        if (book != null) {
            book.displayDetails();
        } else {
            System.out.println("الكتاب غير موجود!");
        }
    }

    private static void payFineOperation() {
        System.out.println("\n========== دفع غرامة ==========");

        String fineId = getStringInput("رقم الغرامة: ");
        library.payFine(fineId);
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("يرجى إدخال رقم صحيح!");
            }
        }
    }

    /**
     * تحميل بيانات تجريبية للتوضيح
     * Load sample data for demonstration
     */
    private static void loadSampleData() {
        // إضافة كتب تجريبية
        library.addBook(new Book("B001", "مقدمة في البرمجة", "دار النشر العلمية",
                2020, "978-1234567890", "أحمد محمد", 350, "Computer Science"));
        library.addBook(new Book("B002", "هياكل البيانات", "دار المعرفة",
                2019, "978-0987654321", "فاطمة علي", 420, "Computer Science"));
        library.addBook(new Book("B003", "الذكاء الاصطناعي", "مكتبة التقنية",
                2021, "978-1122334455", "محمد سالم", 500, "AI"));
        library.addBook(new Book("B004", "تعلم Java", "دار البرمجة",
                2022, "978-5544332211", "سارة أحمد", 400, "Programming"));

        // إضافة مجلات تجريبية
        library.addMagazine(new Magazine("M001", "مجلة العلوم", "مؤسسة العلوم",
                2023, 156, "يناير"));
        library.addMagazine(new Magazine("M002", "مجلة التقنية", "دار التكنولوجيا",
                2023, 89, "فبراير"));

        // إضافة أعضاء تجريبيين
        library.registerMember(new Student("S001", "علي حسن", "ali@university.edu",
                "0501234567", "MEM001", "Computer Science", 2));
        library.registerMember(new Student("S002", "نور محمد", "noor@university.edu",
                "0509876543", "MEM002", "Engineering", 3));
        library.registerMember(new Teacher("T001", "د. خالد إبراهيم", "khaled@university.edu",
                "0505551234", "MEM003", "Computer Science", "Software Engineering"));

        // إضافة موظف
        library.addEmployee(new Employee("E001", "يوسف عمر", "youssef@library.edu",
                "0502223333", "EMP001", "Librarian", 3000.0));

        System.out.println("تم تحميل البيانات التجريبية بنجاح!\n");
    }
}
