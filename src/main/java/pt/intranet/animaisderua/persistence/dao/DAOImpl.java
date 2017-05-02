package pt.intranet.animaisderua.persistence.dao;

import pt.intranet.animaisderua.persistence.daointerfaces.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by smorais on 02/05/2017.
 */
public class DAOImpl<T> implements DAO {

    @PersistenceContext
    private EntityManager em;
    private final Class<T> classe;

    public DAOImpl(Class<T> classe, EntityManager em) {
        this.classe = classe;
        this.em = em;

    }

    @Override
    public Object save(Object entity) {
        em.getTransaction().begin();

        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public Object update(Object entity) {
        return null;
    }

    @Override
    public List listAll(Object entity) {
        return null;
    }
}
