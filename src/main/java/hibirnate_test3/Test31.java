package hibirnate_test3;

import hibirnate_test3.manyToMany.Agency;
import hibirnate_test3.manyToMany.Apartment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test31 {


    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Agency.class)
                    .addAnnotatedClass(Apartment.class)
                    .buildSessionFactory();

        Session session=null;
        try {
            session=factory.getCurrentSession();
            session.beginTransaction();

            Agency agency =new Agency("баланс");
           // Agency agency1=new Agency("альбатрос");
          //  Agency agency2=new Agency("нерухомість");
            Apartment apartment= new Apartment("черноуц","бульва",22);
       //     Apartment apartment1= new Apartment();
        //    agency.addApartment(apartment);
        //    Apartment apartment2= new Apartment();
           apartment.addAgency(agency);
          //  apartment.addAgency(agency1);
          //  apartment.addAgency(agency2);
session.save(apartment);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("________"+e);
        }finally {
            session.close();

        }
    }
}
