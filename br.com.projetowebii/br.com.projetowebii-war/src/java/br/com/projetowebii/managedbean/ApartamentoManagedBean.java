package br.com.projetowebii.managedbean;
import br.com.projetowebii.service.IApartamentoService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.com.projetowebii.entidade.Apartamento;
import java.util.Date;
import java.util.List;

/**
 *
 * @author petrovick
 */

@Named(value = "apartamentoManagedBean")
@RequestScoped
public class ApartamentoManagedBean
{
    @EJB
    private IApartamentoService apartamentoService;
    
    public ApartamentoManagedBean()
    {
        super();
    }
    
    public List<Apartamento> listar()
    {
        return apartamentoService.listar();
    }
}
