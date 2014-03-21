package br.com.projetowebii.managedbean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Scope;
import br.com.projetowebii.entidade.PessoaJuridica;
import br.com.projetowebii.service.IPessoaJuridicaService;
import br.com.projetowebii.serviceimple.PessoaJuridicaService;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author petrovick
 */
@Named(value = "pessoaJuridicaManagedBean")
@RequestScoped
public class PessoaJuridicaManagedBean
{
    @EJB
    private IPessoaJuridicaService pessoaJuridicaService;
    
    public PessoaJuridicaManagedBean()
    {
        super();
    }
    
    public List<PessoaJuridica> listar()
    {
        return pessoaJuridicaService.listar();
    }
    
    
    
    
    
}
