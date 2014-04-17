package br.com.projetowebii.converter;

import br.com.projetowebii.entidade.Cliente;
import br.com.projetowebii.entidade.Pessoa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author petrovick
 */
@FacesConverter(value="clienteConverter", forClass = Cliente.class)
public class ClienteConverter implements Converter
{
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        if(value == null || value.isEmpty())
            return null;
        try
        {
            Cliente cliente = new Cliente();
            cliente.setIdPessoa(Integer.parseInt(value));
            cliente.setPessoa(new Pessoa());
            cliente.getPessoa().setIdPessoa(cliente.getIdPessoa());
            return cliente;
        }
        catch(NumberFormatException e)
        {
            return null;
        }
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        if(value == null || value.getClass() != Cliente.class)
            return null;
        Cliente cliente = (Cliente) value;
        if(cliente.getPessoa() == null)
            return null;
        return cliente.getPessoa().getIdPessoa().toString();
    }
    
}
