package nl.geert.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import nl.geert.model.Adres;
import nl.geert.model.Klant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 *
 * @author Geert
 */
public class HibernateUtil {

    private static StandardServiceRegistry serviceRegistry;
    private static Metadata metaData;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory != null) {
            return sessionFactory;
        } else {
            sessionFactory = createSessionFactory();
            return sessionFactory;
        }
    }

    private static SessionFactory createSessionFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/hibernate.properties"));

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();

            metaData = new MetadataSources(serviceRegistry)
                    .addAnnotatedClass(Klant.class)
                    .addAnnotatedClass(Adres.class)
                    .getMetadataBuilder().build();

            sessionFactory = metaData.getSessionFactoryBuilder().build();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
        return sessionFactory;
    }

      public static Session getSession() {
        Session session;
        
        if (sessionFactory != null) {
            session = sessionFactory.openSession();
            return session;
        } else {
            sessionFactory = createSessionFactory();
            session = sessionFactory.openSession();
            return session;
        }
    }

    public static void commitAndCloseSession(Session session) {
        if(session.isOpen()){
            session.getTransaction().commit();
            session.close();
           }
    }
}
