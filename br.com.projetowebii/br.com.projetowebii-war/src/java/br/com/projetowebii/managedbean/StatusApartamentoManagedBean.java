package br.com.projetowebii.managedbean;

import br.com.projetowebii.service.IStatusApartamentoService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.com.projetowebii.entidade.StatusApartamento;

/**
 *
 * @author petrovick
 */
@Named(value = "statusApartamentoManagedBean")
@RequestScoped
public class StatusApartamentoManagedBean
{
    @EJB
    private IStatusApartamentoService statusApartamentoService;
    
    public StatusApartamentoManagedBean()
    {
        super();
    }
    
    public List<StatusApartamento> listar()
    {
        return statusApartamentoService.listar();
    }
    
    
}
