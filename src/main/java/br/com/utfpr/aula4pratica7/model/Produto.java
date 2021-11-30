package br.com.utfpr.aula4pratica7.model;

import java.io.Serializable;
import lombok.Data;

/**
 * @author JuniorMartins
 */
@Data
public class Produto implements Serializable
{
    private static final long serialVersionUID = 1l;
    
    private int codigo;
    private String descricao;
    
    public Produto(){}
    public Produto(int codigo, String descricao)
    {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    
    
}



