import java.time.LocalDateTime;
public class Message {
    String[][] contacts;
    int contactcount;
    int messageidc;

    public Message(int maxmessages, int maxcontacts) {
        this.contacts = new String[maxcontacts][maxmessages + 2];
        this.contactcount = 0;
        this.messageidc = 1;
    }

    public void addcontact(String contactName, String contactNumber) {
        if (contactcount < contacts.length) {
            contacts[contactcount][0] = contactName;
            contacts[contactcount][1] = contactNumber;
            System.out.println("Contact added: " + contactName + " (" + contactNumber + ")");
            contactcount++;
        } else {
            System.out.println("Unable to add contact. Max contacts reached.");
        }
    }

    public void sendMessage(String senderno, String recieverno, String Text) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i][1] != null && contacts[i][1].equals(senderno)) {
                for (int j = 2; j < contacts[i].length; j++) {
                    if (contacts[i][j] == null) {
                        LocalDateTime time = LocalDateTime.now();
                        Sms msg = new Sms(senderno, recieverno, Text, String.valueOf(messageidc), time);
                        contacts[i][j] = msg.toString();
                        messageidc++;
                        return;
                    }
                }
            }
        }
        System.out.println("Invalid sender contact number.");
    }

    public void display(String contactno) {
        System.out.println("Displaying message history for: " + contactno);
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i][1] != null && contacts[i][1].equals(contactno)) {
                System.out.println("Messages for " + contacts[i][0] + " (" + contacts[i][1] + "):");
                for (int j = 2; j < contacts[i].length; j++) {
                    if (contacts[i][j] != null) {
                        System.out.println(contacts[i][j]);
                    }
                }
                return;
            }
        }
        System.out.println("No messages found for this contact.");
    }

    public void delete(String contactno, String messageid) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i][1] != null && contacts[i][1].equals(contactno)) {
                for (int j = 2; j < contacts[i].length; j++) {
                    if (contacts[i][j] != null && contacts[i][j].contains(messageid)) {
                        contacts[i][j] = null;
                        System.out.println("The message has been deleted");
                        return;
                    }
                }
            }
        }
        System.out.println("Invalid contact number or message ID not found.");
    }

    public void searchContact(String contactno) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i][1] != null && contacts[i][1].equals(contactno)) {
                System.out.println("Contact found: " + contacts[i][0] + " (" + contacts[i][1] + ")");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void searchMessage(String contactno, String messageid) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i][1] != null && contacts[i][1].equals(contactno)) {
                for (int j = 2; j < contacts[i].length; j++) {
                    if (contacts[i][j] != null && contacts[i][j].contains(messageid)) {
                        System.out.println("Message found: ");
                        System.out.println(contacts[i][j]);
                        return;
                    }
                }
            }
        }
        System.out.println("Message not found for the given contact number and message ID.");
    }
}