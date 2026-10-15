package controller;

import service.ContactService;
import view.ContactView;

import java.util.ArrayList;

import model.Contact;

public class ContactController 
{
    private ContactService service;
    private ContactView view;

    public ContactController(ContactService service,ContactView view)
    {
        this.service=service;
        this.view=view;
    }
    public void run()
    {
        int choice;
        do{
            choice =view.showMenu();
            switch(choice)
            {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewAllContacts();
                    break;
                case 3:
                    searchContact();
                    return;
                case 4:
                    editContact();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    System.out.println("Exiting applications...");
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again");

            }
        } while(choice!=6);
    }
    private void addContact()
    {
        String name =view.readName();
        String email=view.readEmail();
        String phone=view.readPhone();
        Contact contact =new Contact(name,email,phone);
        boolean added=service.addContact(contact);
        if(added)
        {
            view.showMessage("Contact added successfully!");
        }
        else 
        {
            view.showError("Invalid phone number or email.contact not added.");
        }
    }

private void viewAllContacts() {
    ArrayList<Contact> contacts = service.getAllContacts();

    if (contacts.isEmpty()) {
        view.showNoContactsMessage();
    } else {
        for (Contact contact : contacts) {
            view.displayContact(contact);
        }
    }
}

private void searchContact() {
    int choice = view.showSearchMenu();

    if (choice == 1) {
        String name = view.readName();
        Contact found = service.searchContactByName(name);

        if (found != null) {
            view.displayContact(found);
        } else {
            view.showContactNotFound();
        }

    } else if (choice == 2) {
        String phone = view.readPhone();
        Contact found = service.searchContactByPhone(phone);

        if (found != null) {
            view.displayContact(found);
        } else
             {
            view.showContactNotFound();
        }

    }
     else 
        {
        view.showError("Invalid search choice.");
        }
}


    private void editContact()
    {
    String oldPhone=view.readOldPhone();
    String newName=view.readName();
    String newEmail=view.readEmail();
    String newPhone=view.readPhone();
    
    Contact  updated = service.editContact(oldPhone,newName,newEmail,newPhone);
    if(updated!=null)
    {
        view.showMessage("contact updated successfully!");
        view.displayContact(updated);
    }
    else{
        view.showError("Contact not updated. Check the existing phone number,email, and new details.");
         }
   }

private void deleteContact() {
    String phone = view.readOldPhone();

    boolean deleted = service.deleteContact(phone);

    if (deleted) {
        view.showMessage("Contact deleted successfully!");
    } else {
        view.showError("Contact not found. Nothing was deleted.");
    }
}






}














