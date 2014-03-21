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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

@Named(value = "clienteManagedBean")
@ViewScoped
public class ClienteManagedBean
{
    @EJB
    private IClienteService clienteService;
    private Cliente cliente;
    private Cliente clienteSelecionado;
    private List<Cliente> clientes;
    private String nomeConsulta;
    private List<SelectItem> tpPessoa;
    private SelectItem itemSelecionado;
    private String mascaraCpfCnpj;
    private String cpfCnpj;

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    
    public List<SelectItem> getTpPessoa() {
        return tpPessoa;
    }

    public void setTpPessoa(List<SelectItem> tpPessoa) {
        this.tpPessoa= tpPessoa;
    }
    
    

    public SelectItem getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(SelectItem itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public String getMascaraCpfCnpj() {
        return mascaraCpfCnpj;
    }

    public void setMascaraCpfCnpj(String mascaraCpfCnpj) {
        this.mascaraCpfCnpj = mascaraCpfCnpj;
    }
    
    public void trocarMascara(ValueChangeEvent evt){  
        itemSelecionado.setValue(evt.getNewValue());  
        if(itemSelecionado.getValue() != null){  
            String tipo = itemSelecionado.getValue().toString();  
            System.out.println("TIPO:" + tipo );
            if (tipo.equals("cnpj")) {    
                mascaraCpfCnpj = "99.999.999/9999-99"; 
            } else {    
                mascaraCpfCnpj = "999.999.999-99";    
            }    
        }   
    }  
    
    
    @PostConstruct
    public void init()
    {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if(id != null)
            cliente = clienteService.obter(Integer.parseInt(id));
        
        cliente = new Cliente();
        cliente.setPessoa(new Pessoa());
        itemSelecionado = new SelectItem();
        tpPessoa = new ArrayList<SelectItem>();
        tpPessoa.add(new SelectItem("cpf", "Pessoa Fisica"));
        tpPessoa.add(new SelectItem("cnpj", "Pessoa Juridica"));
        
    }
    
    public void salvar()
    {
        Boolean erro = clienteService.salvar(cliente);
        if(erro)
            MensagemUtil.addMensgeamInfo("Cliente salvo com sucesso.");
        else
            MensagemUtil.addMensagemError("Cliente não foi salvo.");
    }
    
    public void excluir()
    {
        Boolean erro = clienteService.remover(clienteSelecionado.getIdPessoa());
        if(erro)
        {
            MensagemUtil.addMensgeamInfo("Cliente excluido com sucesso.");
            this.clientes.remove(clienteSelecionado);
        }
        else
            MensagemUtil.addMensagemError("Erro ao excluir.");
    }
    
    
    public void editar() throws IOException
    {
        FacesContext.getCurrentInstance().getExternalContext().redirect("formulario.html?id=" + clienteSelecionado.getIdPessoa());
    }
    
    
    public void consultarCliente()
    {
        this.clientes = clienteService.listarNome(nomeConsulta);
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
    
    
    public List<Cliente> getClientes()
    {
        return clientes;
    }
    
    public void setClientes(List<Cliente> clientes)
    {
        this.clientes = clientes;
    }
    
    public String getNomeConsulta()
    {
        return nomeConsulta;
    }
    
    public void setNomeConsulta(String nomeConsulta)
    {
        this.nomeConsulta = nomeConsulta;
    }
    
    public List<Cliente> listar()
    {
        return clienteService.listar();
    }
    
    
    
}
