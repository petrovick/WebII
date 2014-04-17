package br.com.projetowebii.managedbean;

import br.com.projetowebii.entidade.Apartamento;
import br.com.projetowebii.entidade.Cliente;
import br.com.projetowebii.entidade.Conta;
import br.com.projetowebii.entidade.Reserva;
import br.com.projetowebii.service.IApartamentoService;
import br.com.projetowebii.service.IClienteService;
import br.com.projetowebii.service.IReservaService;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.com.projetowebii.entidade.StatusReserva;
import br.com.projetowebii.service.IContaService;
import br.com.projetowebii.service.IStatusApartamentoService;
import br.com.projetowebii.service.IStatusReservaService;
import br.com.projetowebii.serviceimple.ContaService;
import java.math.BigDecimal;
import java.util.Locale;

@Named(value = "realizarReservaManagedBean")
@RequestScoped
public class realizarReservaManagedbean
{
    @EJB
    private IReservaService reservaService;
    @EJB
    private IContaService contaService;
    @EJB
    private IApartamentoService apartamentoService;
    @EJB
    private IClienteService clienteService;
    @EJB
    private IStatusReservaService statusReservaService;
    @EJB
    private IStatusApartamentoService statusApartamentoService;
    
    private Apartamento apartamentoDePesquisaParaAutoComplete;
    private Cliente clienteDePesquisaParaAutoComplete;
    private Date dataReserva;
    private Short numeroDias;
    private BigDecimal valorConta;
    
    private Reserva reserva;
    private Conta conta;
    
    public realizarReservaManagedbean()
    {
        reserva = new Reserva();
        reserva.setIdApartamento(new Apartamento());
        reserva.setIdPessoa(new Cliente());
        reserva.setIdStatusReserva(new StatusReserva());
        
//        conta = new Conta();
//        conta.setDescricao("Alguel");
    }
    
    
    public void salvar()
    {
        
        //reserva.setIdStatusReserva(null);
        
        System.out.println("ENTROUU");
        reserva.setDataRealizacaoReserva(new Date());
        short s = 1;
        reserva.setIdStatusReserva(statusReservaService.obter(s));
        s = 2;
        reserva.getIdApartamento().setIdStatusApartamento(statusApartamentoService.obter(s));
        
        System.out.println("IDPESSOA" + reserva.getIdPessoa() + "\n\n");
        System.out.println("IDSTATUSRESERVA" + reserva.getIdStatusReserva().getDescricao());
        System.out.println("+_+_+_+_+_+_+_+_+_+_++_+_+_+_+_+_++_+_+_+_+_++_+++++_+_+_+_+_+_+_+_+");
        reservaService.salvar(reserva);
        apartamentoService.AlterarStatusApartamento(reserva.getIdApartamento().getIdApartamento(), s);
    }
    
    public List<Apartamento> listarApartamentoParaAutoComplete(String quarto)
    {
        List<Apartamento> aa = apartamentoService.listarClienteParaAutoComplete(quarto);
        for(Apartamento a : aa)
        {
            System.out.println("AAAA:" + a.getDescricao());
        }
        return aa;
    }
    
    public List<Cliente> listarClienteParaAutoComplete(String queryDePesquisaParaAutoComplete)
    {
        List<Cliente> aa = clienteService.listarClienteParaAutoComplete(queryDePesquisaParaAutoComplete);
        System.out.println("AA: " + aa);
        for(Cliente c : aa)
        {
            System.out.println("AAAAA:" + c.getIdPessoa());
        }
        return aa;
        
    }
    
    public void setApartamentoDePesquisaParaAutoComplete(Apartamento apartamentoDePesquisaParaAutoComplete)
    {
        this.apartamentoDePesquisaParaAutoComplete = apartamentoDePesquisaParaAutoComplete;
    }
    
    public Apartamento getApartamentoDePesquisaParaAutoComplete()
    {
        return apartamentoDePesquisaParaAutoComplete;
    }
    
    public void setDataReserva(Date dataReserva)
    {
        this.dataReserva = dataReserva;
    }
    
    public Date getDataReserva()
    {
        return this.dataReserva;
    }
    
    public void setNumeroDias(Short numeroDias)
    {
        this.numeroDias = numeroDias;
    }
    
    
    public Short getNumeroDias()
    {
        return numeroDias;
    }

    public Cliente getClienteDePesquisaParaAutoComplete() {
        return clienteDePesquisaParaAutoComplete;
    }

    public void setClienteDePesquisaParaAutoComplete(Cliente clienteDePesquisaParaAutoComplete) {
        this.clienteDePesquisaParaAutoComplete = clienteDePesquisaParaAutoComplete;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    

    public BigDecimal getValorConta() {
        return valorConta;
    }

    public void setValorConta(BigDecimal valorConta) {
        this.valorConta = valorConta;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    
}
