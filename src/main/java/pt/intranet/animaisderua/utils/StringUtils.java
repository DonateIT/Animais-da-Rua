package pt.intranet.animaisderua.utils;

/**
 * Created by smorais on 08/05/2017.
 */
public class StringUtils {
    public static String likeLower(String param) {
        return "%" + param.toLowerCase() + "%";
    }
    public static String like(String param) {
        return "%" + param + "%";
    }
}
