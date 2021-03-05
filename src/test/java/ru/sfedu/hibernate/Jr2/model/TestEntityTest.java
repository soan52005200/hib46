package ru.sfedu.hibernate.Jr2.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import ru.sfedu.hibernate.providers.HibernateMetadataProvider;
import ru.sfedu.hibernate.utils.HibernateUtil;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static ru.sfedu.hibernate.Constants.HIBERNATE_CFG_KEY;

public class TestEntityTest {

    public TestEntityTest() {
        System.setProperty(HIBERNATE_CFG_KEY,"C:\\hib46\\src\\test\\resources\\hibernate1.cfg.xml");

    }
    private Session getSession(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        return sessionFactory.openSession();
    }

    @Test
    public void createTestEntity(){

        Session session= getSession();
        Long id = (Long) session.save(new TestEntity("Andrew","User",new Date(),true));
        assertNotNull(id);
    }
}
