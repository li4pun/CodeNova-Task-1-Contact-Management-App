package service;
import model.Contact;
import java.util.*;
import java.io.*;


public  class ContactService
 {

   private ArrayList<Contact> contacts = new ArrayList<>() ;
 
    public boolean addContact( Contact contact)
   {  
        if(contact == null)
        { return false;  
        }  
        if(isValidPhone(contact.getPhoneNumber())&&isValidEmail(contact.getEmail()))
           { 
            contacts.add(contact);
            saveContacts();
            return true;
           }
       else
           {
            return false;
           }
    }
 public ArrayList<Contact> getAllContacts()
{
    return contacts;
}
public  Contact searchContactByName(String name)
     {
        for(Contact c: contacts)
        {
            if(c.getName().equalsIgnoreCase(name))
            {
                return c;
            } 
        }
             return null;
             }
   public  Contact searchContactByPhone(String phoneNumber)
    {
        for(Contact c:contacts)
        {
            if(c.getPhoneNumber().equals(phoneNumber))
            {
                return c;
            }
        }
        
            return null;
         }
    public Contact editContact(String oldPhoneNumber,String newName,String newEmail,String newPhoneNumber)
    {
      Contact contact=searchContactByPhone(oldPhoneNumber);
      if(contact!=null)
       { 
           if(isValidPhone(newPhoneNumber)&&isValidEmail(newEmail))
           {
            contact.setName( newName);
            contact.setEmail(newEmail);
            contact.setPhoneNumber(newPhoneNumber);  
            saveContacts();
            return contact; 
           }  
           else
            {
            System.out.println("invalid contact,please update");
            return null;
             }
       }
         else {
            return null;
              }
        
    }
  public  boolean deleteContact( String phoneNumber)
   {
      Contact contact=searchContactByPhone(phoneNumber);
      if(contact!=null)
      {
        contacts.remove(contact);
        saveContacts();
        return true;
      }
      else {
        return false ;
      }

   }
public boolean isValidPhone(String phoneNumber)
{ 
 return phoneNumber.matches("\\d{10}");
    
}
public boolean isValidEmail(String email)
{
    return email!= null &&
    email.matches("^[A-Za-z0-9._%+-]+@[a-zA-z][a-zA-Z0-9-]*(\\.[a-zA-Z0-9-]*)*\\.[A-Za-z]{2,}$");
}
  public void saveContacts()
  { File folder = new File("data");
  if(!folder.exists()&&!folder.mkdirs())
  {
    System.out.println("Error:Could not create data folder.");
    return;
  }
    try(ObjectOutputStream out =new ObjectOutputStream( new FileOutputStream("data/contacts.data")))
      {    
        out.writeObject(contacts);
        System.out.println("Contacts saved successfully");
      }
      catch(IOException e)
      {
        System.out.println("Error saving contacts:"+e.getMessage());
      }
  } 

  @SuppressWarnings("Unchecked")
    public void loadContacts()
  {
File file = new File("data/contacts.data");

if ( !file.exists())
   {
    System.out.println("No saved contacts found. Starting fresh.");
    return;
} try(ObjectInputStream in= new ObjectInputStream(new FileInputStream(file)))
   {
     ArrayList<Contact> savedContacts =(ArrayList<Contact>) in.readObject();
     contacts = savedContacts;
     System.out.println("Contacts retrieved successfully");
    }
    catch(IOException e)
    {
      System.out.println("error retrieving contacts="+e.getMessage());
    }
    catch(ClassNotFoundException e)
    {
      System.out.println("Contact class not found:"+e.getMessage());
    }
  }



}
