package hibernate_test2;
// дістаємо та видаляємо обект повністю

import hibernate_test2.oneToMany.Test22uni;
import hibernate_test2.oneToMany.uni.User3;
import org.hibernate.Session;


public class Test23uni {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = Test22uni.getFactory().getCurrentSession();
            session.beginTransaction();
            User3 user3 = session.get(User3.class, 32);

            System.out.println(user3);
            session.delete(user3);


            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("__________" + e);

        } finally {
            session.close();
        }

    }
}
