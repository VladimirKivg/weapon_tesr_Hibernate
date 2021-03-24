package hibernate_test2.oneToMany;
// додавання обєктів в таблицю

import hibernate_test2.oneToMany.uni.Address3;
import hibernate_test2.oneToMany.uni.User3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test21uni {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address3.class)
                .addAnnotatedClass(User3.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            User3 user2 = new User3("vasya");
            User3 user1 = new User3("miron");
            User3 user3 = new User3("pasha");
            Address3 address3 = new Address3("Chernouct", "Marichka", 511, 12);
            address3.addUser(user2);
            address3.addUser(user1);
            address3.addUser(user3);
            session.save(address3);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("ловим ошибку " + e);

        } finally {
            factory.close();
        }
    }
}
