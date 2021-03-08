package ru.sfedu.hibernate.Jr2.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import ru.sfedu.hibernate.providers.HibernateMetadataProvider;
import ru.sfedu.hibernate.utils.HibernateUtil;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
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
        Session session = getSession();
        session.getTransaction().begin();
        Long id = (Long) session.save(new TestEntity("Andrew","User",new Date(),new User("Valera",9888,"good")));
        session.getTransaction().commit();
        assertNotNull(id);
    }

    @Test
    public void getById() {
        Session session = getSession();
        session.getTransaction().begin();
        Long id = (Long) session.save(new TestEntity("Andrew","User",new Date(),new User("Valera",9888,"good")));
        session.getTransaction().commit();

        assertTrue(Optional.ofNullable(session.find(TestEntity.class, id)).isPresent());
    }

    @Test
    public void delById() {
        Session session = getSession();
        session.getTransaction().begin();
        Long id = (Long) session.save(new TestEntity("Andrew","User",new Date(),new User("Valera",9888,"good")));

        session.getTransaction().commit();

        TestEntity testEntity = session.find(TestEntity.class, id);
        assertTrue(Optional.ofNullable(testEntity).isPresent());

        session.getTransaction().begin();
        session.delete(testEntity);
        session.getTransaction().commit();

        testEntity = session.find(TestEntity.class, id);
        assertTrue(Optional.ofNullable(testEntity).isEmpty());
    }


    @Test
    public void upd() {
        Session session = getSession();
        session.getTransaction().begin();
        Long id = (Long) session.save(new TestEntity("Andrew","User",new Date(),new User("Valera",9888,"good")));
        session.getTransaction().commit();

        TestEntity testEntity = session.find(TestEntity.class, id);
        assertTrue(Optional.ofNullable(testEntity).isPresent());
        testEntity.setName("Ivan");

        session.getTransaction().begin();
        session.saveOrUpdate(testEntity);
        session.getTransaction().commit();

        testEntity = session.find(TestEntity.class, id);
        Optional.ofNullable(testEntity).ifPresent(t -> {
            assertEquals(t.getName(), "Ivan");
        });
    }

}
