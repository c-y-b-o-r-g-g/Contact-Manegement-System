import java.util.ArrayList;
import java.io.*;

public class Contacts {

    static ArrayList<Contact> contacts = new ArrayList<>();

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public static void createContact(String name, String phone) {


        for (Contact temp : contacts) {
            if (temp.name.equals(name) && temp.phone.equals(phone)) {
                return;
            }
        }
        Contact c = new Contact(name, phone);
        contacts.add(c);
        saveToFile();

    }

    public static void createContact(String name, String phone, String email) {
        for (Contact temp : contacts) {
            if (temp.name.equals(name) && temp.phone.equals(phone) && temp.email.equals(email)) {
                return;
            }
        }
        Contact c = new Contact(name, phone, email);

        contacts.add(c);
        saveToFile();

    }


    public static void viewContacts() {
        for (Contact contact : contacts) {
            System.out.println("Name:" + contact.name + " ,Phone Number:" + contact.phone + " ,Email:" + contact.email);
        }


    }

    public static void readFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("contactlist.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Contact c = new Contact(data[0], data[1], data[2]);
                contacts.add(c);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


    public static void deleteContact(String name) {
        for (Contact temp : contacts) {
            if (temp.name.equals(name)) {
                contacts.remove(temp);
                System.out.println("Contact Deleted Successfully !");
                saveToFile();
                return;
            }
        }
        System.out.println("Contact Not Found !");

    }

    public static void saveToFile() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("contactlist.txt"));
            for (Contact c : contacts) {
                writer.println(c.name + "," + c.phone + "," + c.email);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Contact searchForContact(String name) {
        for (Contact temp : contacts) {
            if (temp.name.equals(name)) {
                return temp;

            }
        }
        return null;
    }

    public static Contact popContact(String name) {
        for (Contact temp : contacts) {
            if (temp.name.equals(name)) {
                contacts.remove(temp);
                return temp;

            }
        }
        return null;
    }


    public static void saveContact(Contact contact) {
        contacts.add(contact);
        saveToFile();
    }


}
