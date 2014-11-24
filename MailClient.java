

/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    // Representa el servidor asociado al cliente
    private MailServer server;
    //Representa la dirección de correo del usuario que usa ese cliente
    private String user;
    
    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(MailServer newServer, String newUser)
    {
        server = newServer;
        user = newUser;
    }

    /**
     * Recupera del servidor el correo (objeto MailItem)
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }
    /**
     * Recupera del servidor un correo que tenga el usuario e imprime los datos del mensaje.
     */
    public void printNextMailItem()
    {
        MailItem correo = server.getNextMailItem(user);
        if(correo == null)
        {
            System.out.println("En este momento, no se ha encontrado ningún mensaje.");
                   
        }
        else
        {
            correo.print();    
        }
    }
    /**
     * Envia un email al servidor asociado al cliente.
     */
    public void sendMailItem(String to, String message)
    {
        MailItem correo = new MailItem(user, to, message);
        server.post(correo);
    }
}