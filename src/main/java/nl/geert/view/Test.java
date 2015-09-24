/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.geert.view;


import nl.geert.controller.HibernateUtil;
import nl.geert.controller.service.KlantService;
import nl.geert.controller.service.KlantServiceImpl;
import nl.geert.model.Adres;
import nl.geert.model.Klant;
import nl.geert.model.dao.KlantDao;
import nl.geert.model.dao.KlantDaoHibernate;
import nl.geert.model.dao.factories.DaoFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 *
 * @author Geert
 */
public class Test {

    public static void main(String[] args) {
//        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
//
//        Metadata metadata = new MetadataSources(serviceRegistry).
//                addAnnotatedClass(Klant.class)
//                .addAnnotatedClass(Adres.class)
//                .getMetadataBuilder().build();
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//        Session session = sessionFactory.openSession();

//        Properties properties = new Properties();
//        try {
//            properties.load(new FileInputStream("src/main/resources/hibernate.properties"));
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } catch (Exception ex) {
//           
//        }
//        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();
//
//        Metadata metadata = new MetadataSources(serviceRegistry)
//                .addAnnotatedClass(Klant.class)
//                .addAnnotatedClassName("nl.geert.model.Adres")
//                .getMetadataBuilder().build();
//
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//        Session session = sessionFactory.openSession();
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        
        Klant klant = new Klant();
        klant.setVoornaam("Henkie");
        klant.setAchternaam("Tankie");
        klant.setTussenvoegsel("der");
        klant.setEmail("gg@ggmail.com");
        
        Adres adres = new Adres();
        adres.setHuisnummer(124);
        adres.setStraatnaam("Straatnaam");
        klant.setAdres(adres);
        adres.getKlanten().add(klant);
        
        Klant klant2 = new Klant();
        klant2.setAchternaam("Hallo");
        
        DaoFactory df = DaoFactory.getDaoFactory(1);
        KlantService service = new KlantServiceImpl();
        service.setDaoFactory(df);
        
        service.create(klant);
        
        HibernateUtil.getSessionFactory().close();
//        session.beginTransaction();
//        session.save(klant);
//        session.save(adres);
//       session.save(klant2);
//        session.getTransaction().commit();
//      
//        sf.close();
    }
}
