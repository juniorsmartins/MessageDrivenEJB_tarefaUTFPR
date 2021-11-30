package br.com.utfpr.aula4pratica7.model;

import java.util.ArrayList;

/**
 * @author JuniorMartins
 */
public class CrudProduto 
{
    public ArrayList<Produto> getAll()
    { 
        ArrayList<Produto> listProd = new ArrayList<>();
        listProd.add(new Produto(1, "Computador"));
        listProd.add(new Produto(2, "Mouse"));
        listProd.add(new Produto(3, "Teclado"));
        listProd.add(new Produto(4, "Monitor"));
        return listProd;
    }
    
    
}



