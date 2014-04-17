package br.com.projetowebii.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.projetowebii.entidade.Papel;

/**
 *
 * @author petrovick
 */
@FacesConverter(value = "papelConverter", forClass = Papel.class)
public class PapelConverter implements Converter
{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty())
            return null;
        Papel papel = new Papel();
        papel.setIdPapel(Integer.parseInt(value));
        return papel;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null || value.getClass() != Papel.class)
            return null;
        Papel papel = (Papel)value;
        return papel.getIdPapel().toString();
    }
    
}
