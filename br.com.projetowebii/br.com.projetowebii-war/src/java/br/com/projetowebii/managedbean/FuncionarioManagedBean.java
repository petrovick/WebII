package br.com.projetowebii.managedbean;

import br.com.projetowebii.entidade.Funcionario;
import br.com.projetowebii.entidade.Pessoa;
import br.com.projetowebii.service.IFuncionarioService;
import br.com.projetowebii.service.IPapelService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
/**
 *
 * @author petrovick
 */
@Named(value = "funcionarioManagedBean")
@RequestScoped
public class FuncionarioManagedBean
{
    @EJB
    IFuncionarioService funcionarioService;
    @EJB
    IPapelService papelService;
    
    private Funcionario funcionario;
    private Funcionario funcionarioSelecionado;

    public FuncionarioManagedBean()
    {
        funcionario = new Funcionario();
        funcionario.setPessoa(new Pessoa());
    }
    
    public void excluir()
    {
        
    }
    
    public void editar()
    {
        
    }
    
    public List<Funcionario> todos()
    {
        List<Funcionario> f = funcionarioService.listar();
        for(Funcionario ff : f)
        {
            System.out.println("\nFunc: " + ff.getIdPessoa() + " - "+ ff.getPessoa().getCpfcnpj()+ " - " + ff.getPessoa().getNome() + " - " + ff.getPessoa().getEmail());
            System.out.println("------------------------------------------");
        }
        return f;
    }
    
    public void salvar()
    {
        funcionario.getPessoa().setTipoPessoa('W');
        funcionarioService.salvar(funcionario);
    }

    public Funcionario getFuncionarioSelecionado() {
        return funcionarioSelecionado;
    }

    public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
        this.funcionarioSelecionado = funcionarioSelecionado;
    }
    
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
    
}
