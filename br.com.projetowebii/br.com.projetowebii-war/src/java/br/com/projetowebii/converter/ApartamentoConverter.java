package br.com.projetowebii.converter;

import br.com.projetowebii.entidade.Apartamento;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author petrovick
 */
@FacesConverter(value = "apartamentoConverter", forClass = Apartamento.class)
public class ApartamentoConverter implements Converter
{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        if(value == null || value.isEmpty())
            return null;
        try
        {
            Apartamento apartamento = new Apartamento();
            apartamento.setIdApartamento(Integer.parseInt(value));
            return apartamento;
        }
        catch(NumberFormatException e)
        {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null || value.getClass() != Apartamento.class)
            return null;
        Apartamento apartamento = (Apartamento)value;
        if(apartamento.getIdApartamento() == null)
                return null;
        return apartamento.getIdApartamento().toString();
    }
    
}
