package hibernate_test;

import hibernate_test.adres.Address;
import hibernate_test.adres.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test11 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();



        Session session = factory.getCurrentSession();

        Address address = new Address("Чернівці","бульва Героїв Крут",22,128);
        User user = new User("Сашко",address);
        session.beginTransaction();
session.save(address);

        session.getTransaction().commit();

        factory.close();

    }
}
