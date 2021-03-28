package hibernate_test2.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;

// витягування
public class Test22bi {
    public static void main(String[] args) {
        getObject();
    }

    private static void getObject() {
        SessionFactory factory = getFactory();
        Session session = null;
        Address2 address2;
        ArrayList<User2> usr;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            address2 = session.get(Address2.class, 27);
            usr = new ArrayList<>(address2.getUser2s());
            session.getTransaction().commit();
            session.close();
            System.out.println(address2);
            System.out.println(usr);


        } catch (Exception e) {
            System.out.println("_________" + e);
        } finally {
            factory.close();
            session.close();
        }
    }

    public static SessionFactory getFactory() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address2.class)
                .addAnnotatedClass(User2.class)
                .buildSessionFactory();
        return        factory;
    }
}
