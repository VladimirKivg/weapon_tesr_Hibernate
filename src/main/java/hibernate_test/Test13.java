package hibernate_test;

import hibernate_test.adres.Address;
import hibernate_test.adres.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test13 {
    //знаходимо да видалямо обєк використовуючи зворотній звязок

    static SessionFactory factory;

    static {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        getObject(); // дістаємо обект
        deleteObject();//

    }

    private static void deleteObject() {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Address address = session.get(Address.class, 12);
            System.out.println(address.getUser());// ось тут ховається весь прікол
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("ловим помилку");
            e.printStackTrace();
        } finally {
            factory.close();
            session.close();
        }
    }

    private static void getObject() {
        Session session=null;
        try {
            session = factory.openSession();
            session.beginTransaction();
Address address =session.get(Address.class,12);
            System.out.println(address.getUser());// ось тут ховається весь прікол
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("ловим помилку");
            e.printStackTrace();
        } finally {
            factory.close();
session.close();
        }
    }
}