package hibernate_test.adres;
// дастаем один обект
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        try {
Session session = factory.getCurrentSession();
session.beginTransaction();
Address address = session.get(Address.class,2);
            System.out.println(address);

        } finally {
            factory.close();
        }

    }
}
