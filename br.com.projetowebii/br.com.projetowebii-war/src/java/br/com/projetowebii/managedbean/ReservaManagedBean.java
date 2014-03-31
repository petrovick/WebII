package br.com.projetowebii.managedbean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.com.projetowebii.entidade.*;
import br.com.projetowebii.service.IReservaService;
import java.util.List;
import javax.ejb.EJB;
/**
 *
 * @author petrovick
 */
@Named(value = "reservaManagedBean")
@RequestScoped
public class ReservaManagedBean
{
    @EJB
    private IReservaService reservaService;
    private Reserva reserva;
    private Pessoa pessoa;
    private Conta conta;
    private StatusReserva statusReserva;
  
    private List<Reserva> reservas;
    public ReservaManagedBean()
    {
        
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

  
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public IReservaService getReservaService() {
        return reservaService;
    }

    public void setReservaService(IReservaService reservaService) {
        this.reservaService = reservaService;
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
    
    public boolean renderizaDropDownApartamento()
    {
        
    }
    
    
}
