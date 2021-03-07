package hibernate_test;
// дастаем один обект
import hibernate_test.adres.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        try {
Session session = factory.getCurrentSession();
session.beginTransaction();
            List<Address> addressList =session
                    .createQuery("from Address")
                    .getResultList();
 session.getTransaction();
            for (Address address: addressList) {
                System.out.println(address);
            }


        } finally {
            factory.close();
        }

    }
}
