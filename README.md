
# Contact Management App

## 1. About the Project

The Contact Management App is a simple Java-based console application that helps users manage their contacts.

Using this application, you can add new contacts, view all saved contacts, search for a particular contact, update contact details, and delete contacts.

The application saves contact information in a local file so that your contacts remain available even after you close and restart the application.

## 2. Features

- Add a new contact with a name, email address, and phone number.
- View all saved contacts.
- Search for a contact by name or phone number.
- Edit an existing contact's details.
- Delete a contact.
- Validate email addresses and phone numbers.
- Save and retrieve contacts automatically.
- Display messages when a contact is not found or the contact list is empty.

## 3. Technologies Used

- Java
- ArrayList
- Java Object Serialization
- File Handling
- Regular Expressions
- Visual Studio Code

## 4. Project Structure
Task-1-Contact-Management-App/
├── data/
│   └── contacts.data
├── out/
│   └── Compiled Java class files
├── screenshots/
├── src/
│   ├── app/
│   │   └── Main.java
│   ├── controller/
│   │   └── ContactController.java
│   ├── model/
│   │   └── Contact.java
│   ├── service/
│   │   └── ContactService.java
│   └── view/
│       └── ContactView.java
├── .gitignore
└── README.md




## 5. Requirements

Before running the application, make sure you have:

- Java Development Kit (JDK) installed.
- A terminal or command prompt.
- A code editor such as Visual Studio Code.

To check whether Java is installed, open a terminal and run:

```bash
java -version
javac -version
```

Both commands should display the installed Java version.

## 6. How to Compile and Run the Application

**Step 1: Open the project folder**

Open the `Task-1-Contact-Management-App` folder in Visual Studio Code.

**Step 2: Open the terminal**

Open the VS Code terminal and make sure the current directory is the main project folder, not the `src` folder.

**Step 3: Compile the application**

Run the following command:

```powershell
javac -d out src\model\Contact.java src\service\ContactService.java src\view\ContactView.java src\controller\ContactController.java src\app\Main.java
```

This command compiles the Java source files and stores the generated `.class` files in the `out` folder.

**Step 4: Run the application**

Execute:

```powershell
java -cp out app.Main
```

The Contact Management App menu will appear in the terminal.

## 7. How to Use the Application

When the application starts, you will see a menu with six options.

### Option 1: Add Contact

Use this option to save a new contact.

1. Select `1`.
2. Enter the contact's name.
3. Enter the email address.
4. Enter the phone number.
5. The application validates the details and saves the contact if they are valid.

**Example:**

```text
Enter your Choice: 1
Enter name: Rahul Kumar
Enter email: rahul@gmail.com
Enter phone: 9876543210
Contact added successfully!
```

Phone numbers must contain exactly 10 digits.

### Option 2: View All Contacts

Use this option to display all saved contacts.

1. Select `2`.
2. The application displays each contact's name, email address, and phone number.

If no contacts are saved, the application displays a message indicating that the contact list is empty.

### Option 3: Search Contact

Use this option to find a particular contact.

1. Select `3`.
2. Choose whether to search by name or phone number.
3. Enter the requested name or phone number.
4. If a matching contact is found, its details are displayed.

If no matching contact exists, the application displays a not-found message.

### Option 4: Edit Contact

Use this option to update an existing contact.

1. Select `4`.
2. Enter the existing phone number of the contact you want to update.
3. Enter the new name.
4. Enter the new email address.
5. Enter the new phone number.
6. The application validates the new details and updates the contact if the information is valid.

Use the contact's current phone number to identify which contact should be edited.

### Option 5: Delete Contact

Use this option to remove a contact.

1. Select `5`.
2. Enter the phone number of the contact you want to delete.
3. If the contact exists, it is removed from the contact list and the updated list is saved.

Make sure you enter the correct phone number before deleting a contact.

### Option 6: Exit

Select `6` to close the application.

Contacts saved successfully before exiting remain available when you run the application again.

## 8. Data Storage

The application uses Java Object Serialization to store contacts in:

```````````````````
data/contacts.data
```````````````````

This is a binary file, not a normal text file. The application automatically loads saved contacts when it starts and saves changes when contacts are added, edited, or deleted.

**Important:** Run the application from the main project folder so that it uses the correct data file. Do not manually edit `contacts.data` in a text editor.

## 9. Validation Rules

- Phone numbers must contain exactly 10 digits.
- Email addresses must follow the email format configured in the application.
- Invalid contact details are rejected during add and edit operations.
- Searching, editing, or deleting a nonexistent contact should display an appropriate message instead of modifying another contact.

## 10. Testing

The following operations and scenarios have been tested:

- Adding contacts.
- Viewing all contacts.
- Searching by name and phone number.
- Editing contact details.
- Deleting contacts.
- Validating email addresses and phone numbers.
- Handling contacts that cannot be found.
- Loading saved contacts after restarting the application.

## 11. Author

Developed as part of the CodeNova Java Internship — Task 1.
