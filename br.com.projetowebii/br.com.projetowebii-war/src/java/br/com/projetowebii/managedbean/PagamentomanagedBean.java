/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetowebii.managedbean;

import br.com.projetowebii.service.IPagamentoService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author petrovick
 */
@Named(value = "pagamentoManagedbean")
@RequestScoped
public class PagamentomanagedBean
{
    @EJB
    IPagamentoService pagamentoService;
    
    
    
    
}
