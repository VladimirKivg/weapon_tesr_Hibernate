package hibernate_test;
// дастаем один обект

import hibernate_test.adres.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {

//lesson1(); //  дастаем один обеэкт
        //       lesson2();// дастаем все обекты

        SessionFactory factory = new Configuration()  //  дастаем несколко обектов за заданными параметрами
                .configure(" ")
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        try {
              Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Address> addressList = session
                    .createQuery("from Address where strit= 'бульвар Героїв Крут'" +
                            "and house_number= 20")// тут все пишим як в SQL
                    .getResultList();
            session.getTransaction();
            for (Address address : addressList) {
                System.out.println(address);
            }


        } finally {
            factory.close();
        }
    }


    private static void lesson2() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Address> addressList = session
                    .createQuery("from Address")
                    .getResultList();
            session.getTransaction();
            for (Address address : addressList) {
                System.out.println(address);
            }


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
            Address address = session.get(Address.class, 2);
            session.getTransaction();
            System.out.println(address);

        } finally {
            factory.close();
        }
    }
}
