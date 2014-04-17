package br.com.projetowebii.managedbean;

import br.com.projetowebii.service.IReservaService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.com.projetowebii.entidade.Reserva;
import br.com.projetowebii.entidade.Apartamento;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author petrovick
 */
@Named(value = "reservaManagedBean")
@RequestScoped
public class ReservaManagedBean implements Serializable
{
    @EJB
    private IReservaService reservaService;
    
    private String nomeConsulta;
    private String apConsulta;
    private List<Apartamento> apartamentos;
    private Apartamento apartamentoSelecionado;
    
    
    
    public ReservaManagedBean()
    {
        apartamentos = new ArrayList<Apartamento>();
    }
    
    public List<Reserva> listarReservasNaoPagas()
    { 
        return reservaService.listarReservasNaoPagas();
    }
    
    public List<Reserva> listar()
    {
        return reservaService.listar();
    }
    
    
    public List<Apartamento> listarApartamento()
    {
        return reservaService.listarApartamento();
    }
    
    public String redirecionaParaPagamento()
    {
        return "/reserva/RealizarReserva.xhtml";
    }

    public Apartamento getApartamentoSelecionado() {
        return apartamentoSelecionado;
    }

    public void setApartamentoSelecionado(Apartamento apartamentoSelecionado) {
        this.apartamentoSelecionado = apartamentoSelecionado;
    }
    
    public List<Apartamento> getApartamentos() {
        apartamentos = reservaService.listarApartamento();
        return apartamentos;
    }

    public String getNomeConsulta() {
        return nomeConsulta;
    }

    public void setNomeConsulta(String nomeConsulta) {
        this.nomeConsulta = nomeConsulta;
    }

    public String getApConsulta() {
        return apConsulta;
    }

    public void setApConsulta(String apConsulta) {
        this.apConsulta = apConsulta;
    }
}

