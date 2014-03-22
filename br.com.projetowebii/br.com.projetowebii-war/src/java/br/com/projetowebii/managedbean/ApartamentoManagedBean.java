package br.com.projetowebii.managedbean;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.com.projetowebii.entidade.Apartamento;
import br.com.projetowebii.service.IApartamentoService;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author petrovick
 */
@Named(value = "apartamentoManagedBean")
@RequestScoped
public class ApartamentoManagedBean implements Serializable
{
    @EJB
    private IApartamentoService apartamentoService;
    private String nomeConsulta;
    private String apConsulta;
    private List<Apartamento> apartamentos;
    private Apartamento apartamentoSelecionado;
    
    public ApartamentoManagedBean()
    {
        apartamentos = new ArrayList<Apartamento>();
    }

    public Apartamento getApartamentoSelecionado() {
        return apartamentoSelecionado;
    }

    public void setApartamentoSelecionado(Apartamento apartamentoSelecionado) {
        this.apartamentoSelecionado = apartamentoSelecionado;
    }
    
    public List<Apartamento> getApartamentos() {
        apartamentos = apartamentoService.listar();
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
    
    
    public List<Apartamento> listar()
    {
        return apartamentoService.listar();
    }
    
    
    public List<Apartamento> listarApartamentoLivre()
    {
        return apartamentoService.listarApartamentosLivres();
    }
    
    
    
}

