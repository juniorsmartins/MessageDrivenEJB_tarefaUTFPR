package br.com.utfpr.aula4pratica7.ejb;

import br.com.utfpr.aula4pratica7.model.CrudProduto;
import br.com.utfpr.aula4pratica7.model.Produto;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 * @author JuniorMartins
 */
@Stateless
public class EJBProduto 
{
    public ArrayList<Produto> getAll()
    {return new CrudProduto().getAll();}
    
    
}



