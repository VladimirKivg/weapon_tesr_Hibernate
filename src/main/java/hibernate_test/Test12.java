package hibernate_test;

import hibernate_test.adres.Address;
import hibernate_test.adres.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test12 {// перштй варіант витягуєм обєкт з бази данних, другий витягуєм і видаляєм, але вже тут робим для них спільний сесіонФакторі
    static SessionFactory factory;

static {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        getUser();// дістаємо юзера

        //deleteUser();//дістаємо і видаляемо обект

    }

    private static void deleteUser() {
        Session session = factory.getCurrentSession();//factory.openSession();
        try {
            session.beginTransaction();

            User user = session.get(User.class, 3);
            session.delete(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ловим помилку");
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

    private static void getUser() {
        Session session = factory.openSession();//factory.getCurrentSession();

        try {
            session.beginTransaction();
            User user = session.get(User.class, 2);
            System.out.println(user + "_ _" + user.getAddressId().getCity());
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("ловим ошибку");
            ;
        } finally {
            session.close();
            factory.close();
        }
    }
}
