/**
 * واجهة Borrowable - تحدد العناصر القابلة للاستعارة
 * Interface that defines borrowable items in the library
 */
public interface Borrowable {
    /**
     * استعارة العنصر
     * @param member العضو المستعير
     * @return true إذا تمت الاستعارة بنجاح
     */
    boolean borrow(Member member);
    
    /**
     * إرجاع العنصر
     * @return true إذا تم الإرجاع بنجاح
     */
    boolean returnItem();
    
    /**
     * التحقق من توفر العنصر
     * @return true إذا كان العنصر متاحاً
     */
    boolean isAvailable();
}
