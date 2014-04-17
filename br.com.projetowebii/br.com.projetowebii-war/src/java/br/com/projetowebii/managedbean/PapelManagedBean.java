package br.com.projetowebii.managedbean;

import br.com.projetowebii.service.IPapelService;
import br.com.projetowebii.entidade.Papel;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

/**
 *
 * @author petrovick 
 */
@Named(value = "papelManagedBean")
public class PapelManagedBean
{
    @EJB
    IPapelService papelService;
    
    private Papel papel;

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }
    
    public List<Papel> listar()
    {
        return papelService.listar();
    }
    
    
    
    
}
