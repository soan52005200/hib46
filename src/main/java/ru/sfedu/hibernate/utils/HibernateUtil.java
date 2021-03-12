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
    private static final String HIBERNATE_CFG_PATH = System.getProperty(HIBERNATE_CFG_KEY,"C:\\hib46\\src\\main\\resources\\hibernate.cfg.xml");

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
            //metadataSources.addAnnotatedClass(ru.sfedu.hibernate.lab3.mappedSuperclass.model.Eatable.class);
            //metadataSources.addAnnotatedClass(ru.sfedu.hibernate.lab3.mappedSuperclass.model.Uneatable.class);
            //metadataSources.addAnnotatedClass(ru.sfedu.hibernate.lab3.tablePerClass.model.Uneatable.class);
            //metadataSources.addAnnotatedClass(ru.sfedu.hibernate.lab3.tablePerClass.model.Product.class);
            //metadataSources.addAnnotatedClass(ru.sfedu.hibernate.lab3.tablePerClass.model.Eatable.class);
            //metadataSources.addAnnotatedClass(ru.sfedu.hibernate.lab3.singleTable.model.Eatable.class);
            //metadataSources.addAnnotatedClass(ru.sfedu.hibernate.lab3.singleTable.model.Uneatable.class);
            //metadataSources.addAnnotatedClass(ru.sfedu.hibernate.lab3.singleTable.model.Product.class);
            metadataSources.addAnnotatedClass(ru.sfedu.hibernate.lab3.joinedTable.model.Product.class);
            metadataSources.addAnnotatedClass(ru.sfedu.hibernate.lab3.joinedTable.model.Uneatable.class);
            metadataSources.addAnnotatedClass(ru.sfedu.hibernate.lab3.joinedTable.model.Eatable.class);

            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }

        return sessionFactory;
    }
}
