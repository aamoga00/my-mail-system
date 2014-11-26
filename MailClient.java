

/**
 * Esta clase representa al usuario del correo electronico.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    // Representa el servidor asociado al cliente
    private MailServer server;
    //Almacena la dirección de correo del usuario que usa el cliente.
    private String user;
    
    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
    }

    /**
     * Recupera del servidor el correo (objeto MailItem)
     */
    public MailItem getNextMailItem()
    
    {
       return server.getNextMailItem(user);
    }
    /**
     * Obtiene del servidor el siguiente correo del usuario y lo imprime por pantalla
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
     * Envia un correo a la dirección indicada con el contenido pasado por parametro.
     */
    public void sendMailItem(String to, String subject, String message)
    {
        MailItem correo = new MailItem(user, to, subject, message);
        server.post(correo);
    }
    /**
     * Nos dice cuantos correos tenemos en el servidor y nos devuelve el numero por pantalla
     */
    public int howManyMailItems()
    {
        return server.howManyMailItems(user);
    }
    /**
     * Al recibir un correo contesta automaticamente al emisor con un mensaje estandar e incorporando el mensaje original
     */
    public void getNextMailItemAndAutorespond()
    {
        MailItem correoOriginal = server.getNextMailItem(user);
        if(correoOriginal != null)
        {
           String to = correoOriginal.getFrom();
           String subject = "RE: "+ correoOriginal.getSubject();
           String message = correoOriginal.getMessage() + "\nEstamos de vacaciones";
           MailItem correoNuevo = new MailItem (user,to, subject, message);
           sendMailItem(to, subject, message);     
        }
    }
    
}