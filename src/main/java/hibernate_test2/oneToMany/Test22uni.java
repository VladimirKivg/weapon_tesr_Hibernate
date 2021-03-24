package hibernate_test2.oneToMany;

import hibernate_test2.oneToMany.uni.*;
import hibernate_test2.oneToMany.uni.Address3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

// витягування
public class Test22uni {
    public static void main(String[] args) {
        getObject();
    }

    private static void getObject() {
        SessionFactory factory = getFactory();
        Session session = null;
        hibernate_test2.oneToMany.uni.Address3 address3;
        ArrayList<User3> usr;


        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            address3 = session.get(Address3.class, 29);
            // usr=new ArrayList<>(address3.getUser2s());
            address3.getUser2s().get(0);//можна такий варіан викорістовувати в цьму випадків замість ліста як я робив ранішше
            session.getTransaction().commit();
            session.close();
            System.out.println(address3);
            System.out.println(address3.getUser2s());
            //   System.out.println(usr);


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
                .addAnnotatedClass(hibernate_test2.oneToMany.uni.Address3.class)
                .addAnnotatedClass(User3.class)
                .buildSessionFactory();
        return factory;
    }
}
