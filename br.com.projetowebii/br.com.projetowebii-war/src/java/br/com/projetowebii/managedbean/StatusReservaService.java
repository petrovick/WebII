package br.com.projetowebii.managedbean;

import br.com.projetowebii.service.IStatusReservaService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.com.projetowebii.entidade.StatusReserva;

/**
 *
 * @author petrovick
 */
@Named(value = "statusReservaService")
@RequestScoped
public class StatusReservaService
{
    @EJB
    private IStatusReservaService statusReservaService;
    
    public StatusReservaService()
    {
        super();
    }

    public List<StatusReserva> listar()
    {
        return statusReservaService.listar();
    }
    
}
