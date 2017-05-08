package pt.intranet.animaisderua.persistence.model.enums;

/**
 * Created by smorais on 08/05/2017.
 */
public enum Condition {
    LIKE("LIKE"), EQUAL("=");
    private String condition;

    Condition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
}
