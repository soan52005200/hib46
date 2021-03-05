package ru.sfedu.hibernate.providers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import ru.sfedu.hibernate.Constants;
import ru.sfedu.hibernate.utils.HibernateUtil;

import java.util.List;


public class HibernateMetadataProvider implements IMetaDataProvider{

    private static Logger log = LogManager.getLogger(HibernateMetadataProvider.class);

    @Override
    public List getAllSchemas() {
        Session session = this.getSession();
        NativeQuery query = session.createSQLQuery(Constants.SQL_ALL_SCHEMAS);
        List resList = query.getResultList();
        session.close();
        log.info("Get schemas size: {}",resList != null? resList.size() : null);
        return resList;
    }
    @Override
    public List getColumnNames(){
        Session session = this.getSession();
        NativeQuery query = session.createSQLQuery(Constants.SQL_COLUMN_NAMES);
        List resList = query.getResultList();
        session.close();
        log.info("Get column names: {}",resList != null? resList.size() : null);
        return resList;
    }
    @Override
    public List getDomainName(){
        Session session = this.getSession();
        NativeQuery query = session.createSQLQuery(Constants.SQL_DOMAIN_NAME);
        List resList = query.getResultList();
        session.close();
        log.info("Get domain name: {}",resList != null? resList.size() : null);
        return resList;
    }
    @Override
    public List getAllTypes(){
        Session session = this.getSession();
        NativeQuery query = session.createSQLQuery(Constants.SQL_ALL_TYPES);
        List resList = query.getResultList();
        session.close();
        log.info("Get all types: {}",resList != null? resList.size() : null);
        return resList;
    }
    private Session getSession(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        return sessionFactory.openSession();
    }
}
