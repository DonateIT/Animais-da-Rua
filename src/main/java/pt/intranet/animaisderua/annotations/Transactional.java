package pt.intranet.animaisderua.annotations;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by smorais on 02/05/2017.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface Transactional {
}
