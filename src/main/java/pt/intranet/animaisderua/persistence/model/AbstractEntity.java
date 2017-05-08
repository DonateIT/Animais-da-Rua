package pt.intranet.animaisderua.persistence.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by smorais on 02/05/2017.
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractEntity) {
            if (obj.getClass() == this.getClass()) {
                if (getId() != null && ((AbstractEntity) obj).getId().equals(getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + "id=" + id + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
