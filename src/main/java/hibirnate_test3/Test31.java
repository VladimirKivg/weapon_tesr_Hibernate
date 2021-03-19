package hibirnate_test3;

import hibirnate_test3.manyToMany.Agency;
import hibirnate_test3.manyToMany.Apartment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test31 {
    static SessionFactory factory;
    {factory= new  Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Agency.class)
            .addAnnotatedClass(Apartment.class)
            .buildSessionFactory();
    }

    public static void main(String[] args) {
        Session session=null;
        try {
            session=factory.getCurrentSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
