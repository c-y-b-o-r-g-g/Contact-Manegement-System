import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Contacts.readFromFile();
        boolean in_program = true;
        Scanner scanner = new Scanner(System.in);
        while (in_program) {
            System.out.println("***Contact Manager***");
            System.out.println("Choose an Option:");
            System.out.print("1.Create a new Contact\n2.View Contacts\n3.Delete Contact\n4.Edit Contact\n5.Exit\n>");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Phone number");
                    String phone = scanner.nextLine();
                    System.out.println("Enter Email: (Enter to leave blank)");
                    String email = scanner.nextLine();
                    if (email.isEmpty()) {
                        email = "null";
                    }

                    Contacts.createContact(name, phone, email);
                    break;
                case 2:

                    Contacts.viewContacts();
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    String deletename = scanner.nextLine();
                    Contacts.deleteContact(deletename);
                    break;
                case 4:

                    System.out.println("Enter Name: ");
                    String editName = scanner.nextLine();
                    Contact temp = Contacts.popContact(editName);
                    if (temp != null) {
                        System.out.println("Contact Found !");
                        System.out.println(temp.name + "," + temp.phone + "," + temp.email);
                        boolean inEdit = true;
                        while (inEdit) {
                            System.out.println("What Do You want to Edit?");
                            System.out.print("1.Name\n2.Phone Number\n3.Email\n4.Cancel\n>");
                            int edit = scanner.nextInt();
                            scanner.nextLine();
                            switch (edit) {
                                case 1:
                                    System.out.println("Enter New Name:");
                                    String newName = scanner.nextLine();
                                    temp.setName(newName);
                                    break;
                                case 2:
                                    System.out.println("Enter New Phone Number:");
                                    String newPhone = scanner.nextLine();
                                    temp.setPhone(newPhone);
                                    break;

                                case 3:
                                    System.out.println("Enter New Email: ");
                                    String newEmail = scanner.nextLine();
                                    temp.setEmail(newEmail);
                                    break;
                                case 4:
                                    inEdit = false;
                                    Contacts.saveContact(temp);
                                    break;
                                default:
                                    break;

                            }
                        }

                    }

                    break;
                case 5:
                    in_program = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }
        scanner.close();
    }

}


