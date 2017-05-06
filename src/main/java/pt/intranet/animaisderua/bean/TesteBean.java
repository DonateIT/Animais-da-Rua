package pt.intranet.animaisderua.bean;

import pt.intranet.animaisderua.persistence.daointerfaces.DAO;
import pt.intranet.animaisderua.persistence.model.Projecto;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by smorais on 02/05/2017.
 */
@Named
@ViewScoped
public class TesteBean implements Serializable {
    @Inject
    private DAO<Projecto> dao;

    public void init(){
        List<Projecto> projectos = dao.listAll();
        System.out.println(projectos);


    }
}
