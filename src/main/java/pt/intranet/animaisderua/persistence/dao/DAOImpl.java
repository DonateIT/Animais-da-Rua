package pt.intranet.animaisderua.persistence.dao;

import pt.intranet.animaisderua.persistence.daointerfaces.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
        em.merge(entity);
        em.flush();
        return entity;

    }


    @Override
    public List listAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("Select e from ").append(this.classe.getSimpleName()).append(" e");
        TypedQuery<T> query = em.createQuery(sb.toString(), this.classe);
        return query.getResultList();
    }
}
