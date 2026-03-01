/**
 * واجهة Renewable - تحدد العناصر القابلة لتجديد الاستعارة
 * Interface for items that can have their borrowing period renewed
 */
public interface Renewable {
    /**
     * تجديد فترة الاستعارة
     * @return true إذا تم التجديد بنجاح
     */
    boolean renew();
    
    /**
     * التحقق من إمكانية التجديد
     * @return true إذا كان يمكن تجديد الاستعارة
     */
    boolean canRenew();
}
