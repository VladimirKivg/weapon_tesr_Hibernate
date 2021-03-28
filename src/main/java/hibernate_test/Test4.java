package hibernate_test;

import hibernate_test.adres.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args) {
//lesson1(); // видаляєм один обект за id

        SessionFactory factory = new Configuration() // відаляем декілька обектів з однаковими данними
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        try {


               Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete Address where house_number=12").executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("ловим помилку");
        } finally {
            factory.close();
        }

    }

    private static void lesson1() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Address address = session.get(Address.class, 3);
            session.delete(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("спіймали помилку");
        } finally {
            factory.close();
        }
    }
}
