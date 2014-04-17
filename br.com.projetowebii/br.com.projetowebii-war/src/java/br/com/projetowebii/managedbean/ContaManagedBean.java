package br.com.projetowebii.managedbean;

import br.com.projetowebii.service.IContaService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.com.projetowebii.entidade.Conta;
/**
 *
 * @author petrovick
 */
@Named(value = "contaManagedBean")
@RequestScoped
public class ContaManagedBean
{
    @EJB
    IContaService contaService;
    private Conta conta;

    
    public void pagar()
    {
        
    }
    
    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
}
