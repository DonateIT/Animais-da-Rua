package pt.intranet.animaisderua.persistence.daointerfaces;

import pt.intranet.animaisderua.persistence.model.enums.Condition;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * Created by Sérgio Morais on 30/04/2017.
 */
public interface DAO<T> extends Serializable {

    T save(T entity);

    T update(T entity);

    List<T> listAll();

    List<T> findByHQLQuery(String queryId, int maxResults);

    List<T> findByHQLQuery(String queryId, List<Object> params, int maxResults);

    List<T> findByAttributes(Map<String, Object> mapAttributeValue, List<Condition> conditions);

    void remove(T entity);

    T findById(Serializable id);

}
