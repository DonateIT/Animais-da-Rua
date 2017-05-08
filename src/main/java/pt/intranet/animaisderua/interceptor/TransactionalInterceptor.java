package pt.intranet.animaisderua.interceptor;

import pt.intranet.animaisderua.annotations.Transactional;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

/**
 * Created by smorais on 08/05/2017.
 */
@Interceptor
@Transactional
public class TransactionalInterceptor implements Serializable {
    @Inject
    private EntityManager em;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        Object result = null;
        try {
            if (!transaction.isActive()) {
                transaction.begin();
                result = context.proceed();
                if (!transaction.getRollbackOnly()) {
                    transaction.commit();
                } else {
                    transaction.rollback();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
                System.out.println("Transação não efetuada, rollback executado!");
            }
        }
        return result;
    }
}
