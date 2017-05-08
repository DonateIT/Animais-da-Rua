package pt.intranet.animaisderua.bean;


import pt.intranet.animaisderua.annotations.Transactional;
import pt.intranet.animaisderua.persistence.daointerfaces.DAO;
import pt.intranet.animaisderua.persistence.model.Projecto;
import pt.intranet.animaisderua.persistence.model.enums.Condition;
import com.google.common.collect.ImmutableMap;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;
import static pt.intranet.animaisderua.utils.FacesUtils.addSuccessMessage;
import static pt.intranet.animaisderua.utils.FacesUtils.addErrorMessage;

/**
 * Created by smorais on 02/05/2017.
 */
@Named
@ViewScoped
public class TesteBean implements Serializable {
    private final DAO<Projecto> dao;
    private Projecto projecto;
    private List<Projecto> projectos;

    @Inject
    public TesteBean(DAO<Projecto> dao) {
        this.dao = dao;
    }

    @PostConstruct
    public void init(){
        projectos = dao.listAll();

        List<Projecto> projectoList = dao.findByAttributes(ImmutableMap.of("nome", "Projecto 1","id", 1L), asList(Condition.LIKE,Condition.EQUAL));
        System.out.println(projectoList);
    }
    @Transactional
    public void construct() throws Exception {
        try {
//            Projeto p = new Projeto();
//            Projeto p2 = new Projeto();
//            p.setNome("Projeto 1");
//            p2.setNome("Projeto 2");
//            dao.save(p);
//            dao.save(p2);
            System.out.println(projecto);
            addSuccessMessage("sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            addErrorMessage("error");
            throw e;
        }
    }

    public Projecto getProjecto() {
        return projecto;
    }

    public void setProjecto(Projecto projeto) {
        this.projecto = projeto;
    }

    public List<Projecto> getProjectos() {
        return projectos;
    }

    public void setProjectos(List<Projecto> projectos) {
        this.projectos = projectos;
    }
}
