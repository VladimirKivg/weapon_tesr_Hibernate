package hibernate_test;

import hibernate_test.adres.Address;
import hibernate_test.adres.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test11 {// записеєм обєкт в базу данних

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();


        try {


            Session session = factory.getCurrentSession();

            Address address = new Address("Чернівці", "бульва Героїв Крут", 20, 41);
            User user = new User("Вованчик Хулиганчик", address);

            session.beginTransaction();
            session.save(user);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("ловим ошибку");
        } finally {
            factory.close();
        }


    }
}
