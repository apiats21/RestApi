package com.andrey.restapp.repository.hibernate;

import com.andrey.restapp.model.User;
import com.andrey.restapp.repository.UserRepository;
import com.andrey.restapp.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class HibernateUserRepositoryImpl implements UserRepository {

    public HibernateUserRepositoryImpl() {
        HibernateUtils.getSessionFactory();
    }

    private static final String GET_USER_BY_ID = "FROM User u join fetch u.events WHERE u.id = :aLong";

    private static final String GET_ALL_USERS = "FROM User";

    @Override
    public User getById(Long aLong) {
        try {
            Session session = HibernateUtils.getSession();
            return session.get(User.class, aLong);
        } catch (Throwable t) {
            return null;
        }
    }

    @Override
    public User save(User user) {

        try (Session session = HibernateUtils.getSession()) {

            Transaction transaction = session.beginTransaction();
            Long id = (Long) session.save(user);
            user.setId(id);
            transaction.commit();
            return user;
        } catch (Throwable t) {
            return null;
        }
    }

    @Override
        public List<User> getAll() { // getting lazy exception when use try with resources

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createQuery(GET_ALL_USERS, User.class).getResultList();
    }

    @Override
    public User update(User user) {

        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            User updUser = session.get(User.class, user.getId());
            updUser.setFirstName(user.getFirstName());
            updUser.setLastName(user.getLastName());
            session.update(updUser);
            transaction.commit();
            return user;
        } catch (Throwable t) {
            return null;
        }
    }

    @Override
    public void deleteById(Long aLong) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, aLong);
            session.delete(user);
            transaction.commit();
        }
    }
}
