package hibernate_test2.oneToMany;
// дістаємо та видаляємо обект повністю
import org.hibernate.Session;

public class Test23 {
    public static void main(String[] args) {
       Session session= null;
       try {
           session=Test22.getFactory().getCurrentSession();
           session.beginTransaction();
           Address2 address2=session.get(Address2.class,28);
           session.delete(address2);
           session.getTransaction().commit();
       } catch (Exception e) {
           System.out.println("________"+e);
       }finally {session.close();

       }

    }
}
