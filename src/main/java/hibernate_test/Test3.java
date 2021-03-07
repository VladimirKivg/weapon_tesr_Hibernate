package hibernate_test;
// изменяем данные обектов
import hibernate_test.adres.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {

//lesson1();//дістаємо один обєкт і робим в ньому зміни

        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        try {


            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Address set flet_nember=22 " +
                    "where city='Чернівці' ").executeUpdate();
            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }

    private static void lesson1() {
        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        try {

            Session session = factory.getCurrentSession();
session.beginTransaction();
Address address=session.get(Address.class,2);
address.setCity("франківськ");
session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}