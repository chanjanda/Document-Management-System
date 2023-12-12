import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class User {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Document {
    private int id;
    private String title;
    private String content;
    private User author;
    private Date created_at;
    private Date updated_at;

    public Document(int id, String title, String content, User author, Date created_at, Date updated_at) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }
}

class Folder {
    private int id;
    private String name;
    private List<Document> documents;

    public Folder(int id, String name) {
        this.id = id;
        this.name = name;
        this.documents = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    // Getters, setters, and methods to add/remove documents
}

public class DocumentManagementSystem {
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";

    private List<User> users;
    private List<Document> documents;
    private List<Folder> folders;
    private Scanner scanner;

    public DocumentManagementSystem() {
        this.users = new ArrayList<>();
        this.documents = new ArrayList<>();
        this.folders = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void add_user(User user) {
        users.add(user);
    }

    public void remove_user(User user) {
        users.remove(user);
    }

    public User get_user(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; // User not found
    }

    public void add_document(Document document) {
        documents.add(document);
    }

    public void remove_document(Document document) {
        documents.remove(document);
    }

    public Document get_document(int id) {
        for (Document document : documents) {
            if (document.getId() == id) {
                return document;
            }
        }
        return null; // Document not found
    }

    public void add_folder(Folder folder) {
        folders.add(folder);
    }

    public void remove_folder(Folder folder) {
        folders.remove(folder);
    }

    public Folder get_folder(int id) {
        for (Folder f : folders) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null; // Folder not found
    }

    // Methods for adding/removing users, documents, and folders

    public void displayWelcomeMessage() {
        System.out.println("\n\t" + ANSI_BLUE + "+---------------------------------------------+" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "|                                             |" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "| " + ANSI_GREEN + " Welcome to the Document Management System" + ANSI_BLUE + "  |" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "|                                             |" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "+---------------------------------------------+" + ANSI_RESET);
    }

    public void displayMenu() {
        System.out.print("\nEnter your Id: ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your Name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter your Email: ");
        String userEmail = scanner.nextLine();

        System.out.println("\nChoose an action: ");
        System.out.println("[1] Add User");
        System.out.println("[2] Remove User");
        System.out.println("[3] Add Document");
        System.out.println("[4] Remove Document");
        System.out.println("[5] Add Folder");
        System.out.println("[6] Remove Folder");
        System.out.println("[7] View Document");
        System.out.println("[8] Exit");
    }

    public void performUserAction(int choice) {
        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                removeUser();
                break;
            case 3:
                addDocument();
                break;
            case 4:
                removeDocument();
                break;
            case 5:
                addFolder();
                break;
            case 6:
                removeFolder();
                break;
            case 7:
                viewDocument();
                break;
            case 8:
                System.out.println("\nExiting Document Management System. Thank you!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void addUser() {
        System.out.println("\n\t" + ANSI_BLUE + "*********************" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "*   ADDING USER    *" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "*********************" + ANSI_RESET);

        System.out.print("\nEnter User Name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter User Email: ");
        String userEmail = scanner.nextLine();

        // Generate a unique user ID (you can modify this based on your needs)
        int userId = users.size() + 1;

        User user = new User(userId, userName, userEmail);
        add_user(user);

        System.out.println("\nUser added successfully!");
    }

    private void removeUser() {
        System.out.println("\n\t" + ANSI_BLUE + "*********************" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "*  REMOVING USER   *" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "*********************" + ANSI_RESET);

        System.out.print("\nEnter the user ID to remove: ");
        int userIdToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        User userToRemove = get_user(userIdToRemove);

        if (userToRemove != null) {
            remove_user(userToRemove);
            System.out.println("\nUser removed successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    private void addDocument() {
        System.out.println("\n\t" + ANSI_BLUE + "*********************" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "*  ADDING DOCUMENT  *" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "*********************" + ANSI_RESET);

        System.out.print("\nEnter document title: ");
        String docTitle = scanner.nextLine();
        System.out.print("Enter document content: ");
        String docContent = scanner.nextLine();

        // Generate a unique document ID (you can modify this based on your needs)
        int docId = documents.size() + 1;

        Document document = new Document(docId, docTitle, docContent, null, new Date(), new Date());
        add_document(document);

        System.out.println("\nDocument added successfully.");
    }

    private void removeDocument() {
        System.out.println("\n\t" + ANSI_BLUE + "*********************" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "* REMOVING DOCUMENT *" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "*********************" + ANSI_RESET);

        System.out.print("\nEnter the document ID to remove: ");
        int docIdToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Document docToRemove = get_document(docIdToRemove);

        if (docToRemove != null) {
            remove_document(docToRemove);
            System.out.println("\nDocument removed successfully.");
        } else {
            System.out.println("Document not found.");
        }
    }

    private void addFolder() {
        System.out.println("\n\t" + ANSI_BLUE + "*********************" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "*   ADDING FOLDER   *" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "*********************" + ANSI_RESET);

        System.out.print("\nEnter folder name: ");
        String folderName = scanner.nextLine();

        // Generate a unique folder ID (you can modify this based on your needs)
        int folderId = folders.size() + 1;

        Folder folder = new Folder(folderId, folderName);
        add_folder(folder);

        System.out.println("\nFolder added successfully.");
    }

    private void removeFolder() {
        System.out.println("\n\t" + ANSI_BLUE + "*********************" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "* REMOVING FOLDER  *" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "*********************" + ANSI_RESET);

        System.out.print("\nEnter the folder ID to remove: ");
        int folderIdToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Folder folderToRemove = get_folder(folderIdToRemove);

        if (folderToRemove != null) {
            remove_folder(folderToRemove);
            System.out.println("\nFolder removed successfully.");
        } else {
            System.out.println("Folder not found.");
        }
    }

    private void viewDocument() {
        System.out.println("\n\t" + ANSI_BLUE + "*********************" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "* VIEWING DOCUMENT  *" + ANSI_RESET);
        System.out.println("\t" + ANSI_BLUE + "*********************" + ANSI_RESET);

        System.out.print("\nEnter the document ID to view: ");
        int docIdToView = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Document docToView = get_document(docIdToView);

        if (docToView != null) {
            System.out.println("\nDocument ID: " + docToView.getId());
            System.out.println("Title: " + docToView.getTitle());
            System.out.println("Content: " + docToView.getContent());
            System.out.println("Author: " + (docToView.getAuthor() != null ? docToView.getAuthor().getName() : "Unknown"));
        } else {
            System.out.println("Document not found.");
        }
    }


    public static void main(String[] args) {
        DocumentManagementSystem dms = new DocumentManagementSystem();
        dms.displayWelcomeMessage();

        while (true) {
            dms.displayMenu();
            System.out.print("\nEnter your choice: ");
            int choice = dms.scanner.nextInt();
            dms.scanner.nextLine(); // Consume the newline character
            dms.performUserAction(choice);

            if (choice == 8) {
                break;
            }
        }

        // Close the scanner to prevent resource leak
        dms.scanner.close();
    }
}
