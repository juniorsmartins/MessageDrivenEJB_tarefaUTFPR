package br.com.utfpr.aula4pratica7.jsf;

import br.com.utfpr.aula4pratica7.ejb.EJBProduto;
import br.com.utfpr.aula4pratica7.model.Produto;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;

/**
 * @author JuniorMartins
 */
@Named(value = "jSFProdutorProduto")
@RequestScoped
public class JSFProdutorProduto 
{
    @EJB
    private EJBProduto eJBProduto;
    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(lookup = "pratica7utfpr/Topico")
    private Topic topico;
    
    public JSFProdutorProduto(){}
    
    public void send()
    {
        try
        {
            ArrayList<Produto> listProd;
            listProd = eJBProduto.getAll();
            Connection conn = connectionFactory.createConnection();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            ObjectMessage om = session.createObjectMessage();
            om.setObject(listProd);
            JMSContext context = connectionFactory.createContext();
            context.createProducer().send(topico, om);
        }
        catch(Exception e)
        {System.err.println("Exception - " + e.getMessage());}
    }
    
    
}
