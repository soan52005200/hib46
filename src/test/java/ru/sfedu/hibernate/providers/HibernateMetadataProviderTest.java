package ru.sfedu.hibernate.providers;

import junit.framework.TestCase;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static ru.sfedu.hibernate.Constants.*;

public class HibernateMetadataProviderTest {

    public HibernateMetadataProviderTest() {
        System.setProperty(HIBERNATE_CFG_KEY,"C:\\hib46\\src\\test\\resources\\hibernate1.cfg.xml");

    }

    @Before
    public void setUp(){

    }
    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testGetAllSchemas() {
        System.out.println("getAllSchemas");
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        List result=instance.getAllSchemas();
        assertNotNull(result);
    }
    @Test
    public void getColumnNames() {
        System.out.println("getColumnNames");
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        List result = instance.getColumnNames();
        assertNotNull(result);
    }
    @Test
    public void getDomainName() {
        System.out.println("getDomainName");
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        List result = instance.getDomainName();
        assertNotNull(result);
    }
    @Test
    public void getAllTypes() {
        System.out.println("getDomainName");
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        List result = instance.getAllTypes();
        assertNotNull(result);
    }


}