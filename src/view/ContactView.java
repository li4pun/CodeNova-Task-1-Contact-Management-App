package view;
import java.util.Scanner;

import model.Contact;

public class ContactView 
{
    
private Scanner sc=new Scanner(System.in);

public int showMenu()
{
    System.out.println("\n****************Contact Management App*******************");
    System.out.println("1.Add Contact");
    System.out.println("2.View All Contacts");
    System.out.println("3.search contacts");
    System.out.println("4.Edit COntact");
    System.out.println("5.Delete Contact");
    System.out.println("6.Exit");
    System.out.println("Enter your Choice: ");

    int choice=sc.nextInt();
    sc.nextLine();
    return choice;
} 
public String readName()
{
    System.out.println("Enter your name:");
    return sc.nextLine();
}
public String readEmail()
{
    System.out.println("Enter Contact Email:");
    return sc.nextLine();
}
 public String readPhone()
 {
    System.out.println("Enter Phone Number:");
    return sc.nextLine();
 }
 public String readOldPhone()
 {
    System.out.println("Enter existing phone number:");
    return sc.nextLine();
 }
 public void showMessage(String message)
 {
    System.out.println(message);
 }
 public void showError(String message)
 {
    System.out.println("Error:"+message);
 }
 
public void displayContact(Contact contact) {
    System.out.println("Name: " + contact.getName());
    System.out.println("Email: " + contact.getEmail());
    System.out.println("Phone: " + contact.getPhoneNumber());
    System.out.println("--------------------------");
}

public void showNoContactsMessage() {
    System.out.println("No contacts available.");
}

public int showSearchMenu() {
    System.out.println("\n--- Search Contacts ---");
    System.out.println("1. Search by Name");
    System.out.println("2. Search by Phone");
    System.out.print("Enter your choice: ");

    int choice = sc.nextInt();
    sc.nextLine();

    return choice;
}

public void showContactNotFound() {
    System.out.println("Contact not found.");
}




}
