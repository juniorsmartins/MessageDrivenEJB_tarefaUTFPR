package br.com.utfpr.aula4pratica7.jsf;

import br.com.utfpr.aula4pratica7.ejb.EJBProduto;
import br.com.utfpr.aula4pratica7.model.Produto;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 * @author JuniorMartins
 */
@Named(value = "jSFProduto")
@RequestScoped
public class JSFProduto 
{
    @EJB
    private EJBProduto eJBProduto;
    
    public JSFProduto(){}
    
    public ArrayList<Produto> getAll()
    {return eJBProduto.getAll();}
    
    
    
    
}
