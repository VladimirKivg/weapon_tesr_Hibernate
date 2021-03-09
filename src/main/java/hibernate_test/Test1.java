package hibernate_test;

import hibernate_test.adres.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Address address = new Address("Львів", "проспект Кобили",
                    11, 42);

            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}
