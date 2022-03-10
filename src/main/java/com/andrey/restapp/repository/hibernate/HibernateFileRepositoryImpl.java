package com.andrey.restapp.repository.hibernate;

import com.andrey.restapp.model.File;
import com.andrey.restapp.model.User;
import com.andrey.restapp.repository.FileRepository;
import com.andrey.restapp.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateFileRepositoryImpl implements FileRepository {

    @Override
    public File getById(Long aLong) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            return session.get(File.class, aLong);
        } catch (Throwable t) {
            return null;
        }
    }

    @Override
    public File save(File file) {

        try{

            Session session = HibernateUtils.getSession();
            Transaction transaction = session.beginTransaction();
            Long id = (Long) session.save(file);
            file.setId(id);
            transaction.commit();
            return file;
        } catch (Throwable t) {
            return null;
        }
    }

    @Override
    public List<File> getAll() { // try with resources doesn't work

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createQuery("FROM File", File.class).getResultList();
    }

    @Override
    public File update(File file) {

        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            File updFile = session.get(File.class, file.getId());
            updFile.setFileName(file.getFileName());
            session.update(updFile);
            transaction.commit();
            return file;
        } catch (Throwable t) {
            return null;
        }
    }

    @Override
    public void deleteById(Long aLong) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            File file = session.get(File.class, aLong);
            session.delete(file);
            transaction.commit();
        }
    }
}
