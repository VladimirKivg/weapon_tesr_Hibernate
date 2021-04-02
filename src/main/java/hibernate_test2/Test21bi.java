package hibernate_test2;
// додавання обєктів в таблицю

import hibernate_test2.oneToMany.bi.Address2;
import hibernate_test2.oneToMany.bi.User2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test21bi {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address2.class)
                .addAnnotatedClass(User2.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            User2 user2 = new User2("vovik");
            User2 user1 = new User2("sashako");
    User2 user3 = new User2("pasha");
            Address2 address2 = new Address2("chernouc", "hirurga", 20, 41);
            address2.addUser(user2);
            address2.addUser(user1);
            address2.addUser(user3);
            session.save(address2);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("ловим ошибку " + e);

        } finally {
            factory.close();
        }
    }
}
