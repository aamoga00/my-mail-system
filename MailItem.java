
/**
 * Write a description of class MailItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    // instance variables - replace the example below with your own
    private String from;
    private String to;
    private String message;

    /**
     * Constructor for objects of class MailItem
     */
    public MailItem(String newFrom, String newTo, String newMessage)
    {
       from = newFrom;
       to = newTo;
       message = newMessage;
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
