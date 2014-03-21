package br.com.projetowebii.managedbean;
import br.com.projetowebii.entidade.Pessoa;
import br.com.projetowebii.service.IPessoaService;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named(value = "pessoaManagedBean")
@RequestScoped
public class PessoaManagedBean implements Serializable
{
    @EJB
    private IPessoaService pessoaService;
    
    public PessoaManagedBean()
    {
        super();
        
    }
    
    public List<Pessoa> listar()
    {
        return pessoaService.listar();
    }
    
}