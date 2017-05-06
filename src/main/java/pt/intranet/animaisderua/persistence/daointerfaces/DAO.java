package pt.intranet.animaisderua.persistence.daointerfaces;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sérgio Morais on 30/04/2017.
 */
public interface DAO<T> extends Serializable {
    public abstract T save(T entity);

    public abstract T update(T entity);

    public abstract List<T> listAll();

}
