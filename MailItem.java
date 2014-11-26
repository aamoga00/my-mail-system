
/**
 * Esta clase representa a un mensaje de email.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    // Almacena de quien es el mensaje
    private String from;
    //Almacena para quien es el mensaje
    private String to;
    //Almacena el contenido del mensaje
    private String message;

    /**
     * Constructor for objects of class MailItem
     */
    public MailItem(String from, String to, String message)
    {
       this.from = from;
       this.to = to;
       this.message = message;
    }

    /**
     * Nos devuelve la información de quien es el que envia el mail
     */
    public String getFrom()
    {
       return from;
    }
    /**
     * Nos devuelve la información de para quien es el mail.
     */
    public String getTo()
    {
        return to;
    }
    /**
     * Nos devuelve el mensaje que esta escrito en el mail.
     */
    public String message()
    {
        return message;
    }
    /**
     * Nos muestra por pantalla los atributos del objeto mailItem.
     */
    public void print()
    {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println(message);
        
    }
    
}
