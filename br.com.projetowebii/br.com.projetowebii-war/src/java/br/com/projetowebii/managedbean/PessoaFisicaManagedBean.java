package br.com.projetowebii.managedbean;

import br.com.projetowebii.service.IPessoaFisicaService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.com.projetowebii.entidade.PessoaFisica;

/**
 *
 * @author petrovick
 */
@Named(value = "pessoaFisicaManagedBean")
@RequestScoped
public class PessoaFisicaManagedBean
{
    @EJB
    private IPessoaFisicaService pessoaFisicaService;
    
    public PessoaFisicaManagedBean()
    {
        super();
    }
    
    public List<PessoaFisica> listar()
    {
        return pessoaFisicaService.listar();
    }
    
    
}
