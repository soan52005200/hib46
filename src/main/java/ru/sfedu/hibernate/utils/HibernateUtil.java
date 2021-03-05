package ru.sfedu.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.sfedu.hibernate.Jr2.model.TestEntity;

//import

import java.io.File;

import static ru.sfedu.hibernate.Constants.HIBERNATE_CFG_KEY;

public class HibernateUtil {
    private static final String HIBERNATE_CFG_PATH = System.getProperty(HIBERNATE_CFG_KEY);

    private static SessionFactory sessionFactory;

    /**
     * Создание фабрики
     *
     */

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure(new File(HIBERNATE_CFG_PATH));

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();


            MetadataSources metadataSources =
                    new MetadataSources(serviceRegistry);

            metadataSources.addAnnotatedClass(TestEntity.class);
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }

        return sessionFactory;
    }
}
