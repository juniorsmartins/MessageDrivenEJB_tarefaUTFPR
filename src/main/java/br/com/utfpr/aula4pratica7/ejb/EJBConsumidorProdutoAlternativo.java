package br.com.utfpr.aula4pratica7.ejb;

import br.com.utfpr.aula4pratica7.model.Produto;
import java.util.ArrayList;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * @author JuniorMartins
 */
@MessageDriven(activationConfig = 
{
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "pratica7utfpr/Topico"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class EJBConsumidorProdutoAlternativo implements MessageListener
{
    @Override
    public void onMessage(Message msg) 
    {
        System.out.println("(Topico) Mensagem recebida pelo " + this.getClass().getSimpleName());
        try
        {
            ObjectMessage tm = (ObjectMessage) msg;
            ArrayList<Produto> lprod = new ArrayList<>();
            lprod = (ArrayList<Produto>) tm.getObject();
            for(Produto produto: lprod)
            {System.out.println("Código: " + produto.getCodigo() + " - produto: " + produto.getDescricao());}
        }
        catch(Exception e)
        {System.err.println("Exception! " + e.getMessage());}
    }
    
}



