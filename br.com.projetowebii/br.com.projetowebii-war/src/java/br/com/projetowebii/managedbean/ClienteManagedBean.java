package br.com.projetowebii.managedbean;

import br.com.projetowebii.service.IClienteService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.com.projetowebii.entidade.*;
import br.com.projetowebii.util.MensagemUtil;
import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

@Named(value = "clienteManagedBean")
@RequestScoped
public class ClienteManagedBean
{
    @EJB
    private IClienteService clienteService;
    
    private Cliente cliente;
    private Cliente clienteSelecionado;
    
    public ClienteManagedBean()
    {
        cliente = new Cliente();
        cliente.setPessoa(new Pessoa());
    }
    
    public void novo()
    {
        this.cliente = new Cliente();
        this.cliente.setPessoa(new Pessoa());
    }
    
    public void salvar()
    {
        System.out.println("Pessoa Nome: " + cliente.getPessoa().getNome());
        System.out.println("Pessoa Email: " + cliente.getPessoa().getEmail());
        System.out.println("Pessoa CPF: " + cliente.getPessoa().getCpfcnpj());
        System.out.println("Pessoa TipoPessoa:" + cliente.getPessoa().getTipoPessoa());
        
        System.out.println("Cliente: " + cliente);
        System.out.println("Pessoa: " + cliente.getPessoa());
        
        String erro = clienteService.salvar(cliente);
        
        if(erro == null)
        {
            MensagemUtil.addMensgeamInfo("Cliente savo com sucesso.");
            cliente = new Cliente();
        }
        else
            MensagemUtil.addMensagemError(erro);
    }
    
    
    public void excluir()
    {
        String erro = clienteService.remover(clienteSelecionado.getIdPessoa());
        if(erro == null)
        {
            MensagemUtil.addMensgeamInfo("Cliente Excluido com sucesso");
        }
        else
            MensagemUtil.addMensagemError(erro);
    }
    
    public void editar()
    {
        cliente = clienteSelecionado;
    }
    
    public List<Cliente> todos()
    {
        List<Cliente> lC = clienteService.listar();
        return lC;
    }
    
    public Cliente getCliente()
    {
        return cliente;
    }
    
    
    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }
    
    
    public Cliente getClienteSelecionado()
    {
        return clienteSelecionado;
    }
    
    
    public void setClienteSelecionado(Cliente clienteSelecionado)
    {
        this.clienteSelecionado = clienteSelecionado;
    }
}
