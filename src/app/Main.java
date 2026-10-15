package app;
import model.Contact;
import service.ContactService;
import java.util.*;
import view.ContactView;
import controller.ContactController;

public class Main 
{
     public static void main(String[] args)
{
    ContactService service =new ContactService();
    service.loadContacts();
     ContactView view=new ContactView();
     ContactController controller = new ContactController(service,view);
     controller.run();
     





}}