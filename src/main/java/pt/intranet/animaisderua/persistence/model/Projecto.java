package pt.intranet.animaisderua.persistence.model;


import javax.persistence.Entity;


/**
 * Created by smorais on 02/05/2017.
 */
@Entity
public class Projecto extends AbstractEntity {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
