import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Message m1 = new Message(10, 100);
        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Contact");
            System.out.println("2. Send Message");
            System.out.println("3. Display Messages");
            System.out.println("4. Delete Message");
            System.out.println("5. Search Contact");
            System.out.println("6. Search Message");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String contactName = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    m1.addcontact(contactName, contactNumber);
                    break;

                case 2:
                    System.out.print("Enter sender number: ");
                    String sender = scanner.nextLine();
                    System.out.print("Enter receiver number: ");
                    String receiver = scanner.nextLine();
                    System.out.print("Enter message text: ");
                    String text = scanner.nextLine();
                    m1.sendMessage(sender, receiver, text);
                    break;

                case 3:
                    System.out.print("Enter contact number to display messages: ");
                    String contactDisplay = scanner.nextLine();
                    m1.display(contactDisplay);
                    break;

                case 4:
                    System.out.print("Enter contact number: ");
                    String delContact = scanner.nextLine();
                    System.out.print("Enter message ID: ");
                    String messageId = scanner.nextLine();
                    m1.delete(delContact, messageId);
                    break;

                case 5:
                    System.out.print("Enter contact number to search: ");
                    String searchContact = scanner.nextLine();
                    m1.searchContact(searchContact);
                    break;

                case 6:
                    System.out.print("Enter contact number: ");
                    String searchMessageContact = scanner.nextLine();
                    System.out.print("Enter message ID: ");
                    String searchMessageId = scanner.nextLine();
                    m1.searchMessage(searchMessageContact, searchMessageId);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (running) {
                System.out.print("Do you want to perform another action? (yes/no): ");
                String again = scanner.nextLine().trim().toLowerCase();
                if (!again.equals("yes")) {
                    System.out.println("Exiting...");
                    running = false;
                }
            }
        }

        scanner.close();
    }
}