package br.com.projetowebii.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author petrovick
 */
public class MensagemUtil
{
    public static void addMenssagem(Severity severity, String sumary, String detail)
    {
        FacesMessage facesMessage = new FacesMessage(severity, sumary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    public static void addMensgeamInfo(String message)
    {
        addMenssagem(FacesMessage.SEVERITY_INFO, message, null);
    }
    
    public static void addMensagemError(String message)
    {
        addMenssagem(FacesMessage.SEVERITY_ERROR, message, null);
    }
    
    
}
