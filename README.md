# نظام إدارة المكتبة - Library Management System

## مشروع Java OOP

---

## 📋 وصف المشروع

نظام إدارة مكتبة احترافي مطور بلغة Java يطبق جميع مبادئ البرمجة كائنية التوجه (OOP). النظام يدير العمليات الكاملة للمكتبة من إدارة الكتب والأعضاء إلى عمليات الاستعارة والغرامات.

---

## 🎯 المبادئ المطبقة (OOP Principles)

✅ **Encapsulation** - التغليف باستخدام private, protected, public
✅ **Inheritance** - الوراثة عبر extends
✅ **Polymorphism** - تعدد الأشكال عبر @Override
✅ **Abstraction** - التجريد باستخدام Abstract Classes و Interfaces
✅ **Composition** - التركيب باستخدام Has-A relationships

---

## 📁 هيكل المشروع (Project Structure)

```
LibraryManagementSystem/
└── src/
    ├── Borrowable.java          (Interface)
    ├── Renewable.java           (Interface)
    ├── Person.java              (Abstract Class)
    ├── Member.java              (Abstract Class)
    ├── Student.java             (Concrete Class)
    ├── Teacher.java             (Concrete Class)
    ├── Employee.java            (Concrete Class)
    ├── LibraryItem.java         (Abstract Class)
    ├── Book.java                (Concrete Class)
    ├── Magazine.java            (Concrete Class)
    ├── Transaction.java         (Concrete Class)
    ├── Fine.java                (Concrete Class)
    ├── Library.java             (Concrete Class)
    └── LibraryManagementSystem.java (Main Class)
```

---

## ⚙️ متطلبات التشغيل (Requirements)

- Java JDK 8 أو أحدث
- أي IDE (IntelliJ IDEA، Eclipse، VS Code)
- أو Command Line Terminal

---

## 🚀 طريقة التشغيل (How to Run)

### الطريقة الأولى: عبر Command Line

```bash
# 1. الانتقال إلى مجلد src
cd "d:\مشاريعي التي جاري العمل عليها\OOB-PROJECTS\LibraryManagementSystem\src"

# 2. تجميع جميع الملفات
javac *.java

# 3. تشغيل البرنامج
java LibraryManagementSystem
```

### الطريقة الثانية: عبر IDE

1. افتح المشروع في IDE المفضل لديك
2. افتح ملف `LibraryManagementSystem.java`
3. اضغط Run أو F5

---

## 📚 ميزات النظام (System Features)

1. **إدارة الكتب**
   - إضافة كتب جديدة
   - البحث عن كتاب
   - عرض الكتب المتاحة
   - عرض جميع الكتب

2. **إدارة الأعضاء**
   - تسجيل طلاب
   - تسجيل معلمين
   - عرض معلومات الأعضاء

3. **عمليات الاستعارة**
   - استعارة كتاب
   - إرجاع كتاب
   - تجديد الاستعارة

4. **إدارة الغرامات**
   - حساب الغرامات تلقائياً
   - عرض الغرامات غير المدفوعة
   - دفع الغرامات

5. **المعاملات**
   - تتبع جميع المعاملات
   - عرض المعاملات النشطة

---

## 💡 البيانات التجريبية (Sample Data)

عند تشغيل البرنامج، يتم تحميل بيانات تجريبية تلقائياً:

- 4 كتب
- 2 مجلات
- 3 أعضاء (2 طلاب + 1 معلم)
- 1 موظف

---

## 🎓 المتطلبات الأكاديمية المحققة

| المتطلب          | الحالة | التفاصيل                                                 |
| ---------------- | ------ | -------------------------------------------------------- |
| عدد الكلاسات     | ✅     | 12 كلاس (أكثر من المطلوب)                                |
| Inheritance      | ✅     | Person→Member→Student/Teacher, LibraryItem→Book/Magazine |
| Composition      | ✅     | Library has-a Books/Members/Transactions                 |
| Encapsulation    | ✅     | Private fields + Getters/Setters                         |
| Polymorphism     | ✅     | Override في displayInfo(), toString()                    |
| Abstract Classes | ✅     | Person, LibraryItem, Member                              |
| Interfaces       | ✅     | Borrowable, Renewable                                    |
| Final Constants  | ✅     | MAX_BOOKS, FINE_PER_DAY, MAX_RENEWALS                    |
| Constructors     | ✅     | Default و Parameterized                                  |
| Scanner Input    | ✅     | واجهة تفاعلية كاملة                                      |
| Main Method      | ✅     | LibraryManagementSystem.main()                           |

---

## 📊 العلاقات بين الكلاسات (Relationships)

### Inheritance (الوراثة)

```
Person
├── Member
│   ├── Student
│   └── Teacher
└── Employee

LibraryItem
├── Book
└── Magazine
```

### Implementation (تطبيق الواجهات)

```
Book implements Borrowable, Renewable
Magazine implements Borrowable
```

### Composition (التركيب)

```
Library has-a:
  - ArrayList<Book>
  - ArrayList<Member>
  - ArrayList<Transaction>
  - ArrayList<Fine>

Transaction has-a:
  - LibraryItem
  - Member

Fine has-a:
  - Transaction
```

---

## 📖 أمثلة الاستخدام (Usage Examples)

### مثال 1: استعارة كتاب

```
Input:
- اختر الخيار: 4
- رقم الكتاب: B001
- رقم العضوية: MEM001

Output:
- Book borrowed successfully!
- Transaction created: T0001
```

### مثال 2: إرجاع كتاب مع غرامة

```
Input:
- اختر الخيار: 5
- رقم الكتاب: B001

Output (إذا كان متأخراً):
- Book returned successfully!
- *** FINE APPLIED ***
- Fine Amount: $4.50
- Days Overdue: 3
```

---

## 👨‍💻 المطور (Developer)

- **اسم الطالب:** [يتم التعبئة]
- **التخصص:** علوم الحاسوب / هندسة البرمجيات
- **المادة:** البرمجة كائنية التوجه (OOP)
- **الجامعة:** [يتم التعبئة]
- **السنة:** 2026

---

## 📝 ملاحظات هامة (Important Notes)

1. جميع الـ Classes موثقة بتعليقات عربية وإنجليزية
2. الكود نظيف ويتبع Java Coding Standards
3. التصميم قابل للتوسع (Scalable)
4. UML Diagram يطابق الكود بشكل كامل
5. التوثيق الأكاديمي الكامل متوفر بصيغة DOCX

---

## 📞 للدعم (Support)

للاستفسارات أو المساعدة، يرجى التواصل مع المطور.

---

**© 2026 Library Management System - Java OOP Project**
