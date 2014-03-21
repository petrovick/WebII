package br.com.projetowebii.managedbean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.com.projetowebii.entidade.*;
/**
 *
 * @author petrovick
 */
@Named(value = "reservaManagedBean")
@RequestScoped
public class ReservaManagedBean
{
    
    
    private Pessoa pessoa;
    private Conta conta;
    private StatusReserva statusReserva;
    
    public ReservaManagedBean()
    {
        
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public StatusReserva getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(StatusReserva statusReserva) {
        this.statusReserva = statusReserva;
    }
    
    
    
}
