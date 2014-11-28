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
    //Representa el ultimo email recibido.
    private MailItem lastEmail;
    
    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
        lastEmail = null;
    }

    /**
     * Recupera del servidor el correo (objeto MailItem)
     */
    public MailItem getNextMailItem()
    
    {
       lastEmail = server.getNextMailItem(user);
        return lastEmail;
    }
    /**
     * Obtiene del cliente el correo del usuario y lo imprime por pantalla
     */
    public void printNextMailItem()
    {
        if(lastEmail == null)
        {
            System.out.println("En este momento, no se ha encontrado ningún mensaje.");
                   
        }
        else
        {
            lastEmail.print();    
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
     * Nos imprime por pantalla el numero de mensajes que tenemos en el servidor.
     */
    public void howManyMailItems()
    {
        int numberOfMails = server.howManyMailItems(user);
        System.out.println("Tienes" + numberOfMails + " mensajes en el servidor");
        //Otra opcion seria sin variable local: System.out.println("Tienes" + server.howManyMailItems(user) 
        //                                                         + " mensajes en el servidor");
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
           MailItem correoNuevo = new MailItem (user, to, subject, message);
           server.post(correoNuevo);
           //sendMailItem(to, subject, message); --> alternativa para enviar correo.   
        }
    }
    /**
    * Muestra por pantalla el ultimo correo
    */
    public void printLastMailItem()
    {
       lastEmail.print();
    }
}