import java.util.Scanner;

interface MessagingService{
    void sendMessage();
}

class SMSMessagingService implements MessagingService{
    public void sendMessage() {
        Scanner getInputFromUser = new Scanner(System.in);
        System.out.println("Enter Mobile Number to send SMS :");
        String mobileNumber = getInputFromUser.next();
        while (mobileNumber.length() != 10 || mobileNumber.charAt(0) == '0'){
            System.out.println("Invalid Mobile Number \n" + "Enter Mobile Number again : ");
            mobileNumber = getInputFromUser.next();
        }
        System.out.println("Enter Message to send : ");
        String message = getInputFromUser.next();
        System.out.println("Message sent to " +mobileNumber);
    }
}

class EmailMessagingService implements MessagingService{
    public void sendMessage(){
        Scanner getInputFromUser = new Scanner(System.in);
        System.out.println("Enter Email to Send : ");
        String emailTo = getInputFromUser.next();
        while ( emailTo.length() <= 10 || ! (emailTo.substring(emailTo.length()-10,emailTo.length())).equals("@gmail.com") ){
            System.out.println("Email entered is wrong \n" + "Enter Email again :");
            emailTo = getInputFromUser.next();
        }
        System.out.println("Enter Subject : ");
        String subject = getInputFromUser.next();
        System.out.println("Enter Message : ");
        String message = getInputFromUser.next();
        System.out.println("Email sent to " + emailTo);
    }
}

class WhatsAppMessagingService implements MessagingService{
    public void sendMessage(){
        Scanner getFromUser = new Scanner(System.in);
        System.out.println("Enter Mobile Number to send SMS :");
        String mobileNumber = getFromUser.next();
        while (mobileNumber.length() != 10 || mobileNumber.charAt(0) == '0'){
            System.out.println("Invalid Mobile Number \n" + "Enter Mobile Number again : ");
            mobileNumber = getFromUser.next();
        }
        System.out.println("Enter Message to send : ");
        String message = getFromUser.next();
        System.out.println("Message sent to " +mobileNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        SMSMessagingService smsSender = new SMSMessagingService();
        EmailMessagingService emailSender = new EmailMessagingService();
        WhatsAppMessagingService whatsappSender = new WhatsAppMessagingService();
        Scanner getUserInput = new Scanner(System.in);
        int userInput = 0;
        do {
            System.out.println("Enter \n" + "1 for SMS Messaging Service \n" + "2 for Email Messaging Service \n" + "3 for WhatsApp Messaging Service \n" + "4 to Exit");
            userInput = getUserInput.nextInt();
            switch (userInput){
                case 1 : {
                    smsSender.sendMessage();
                    break;
                }
                case 2 : {
                    emailSender.sendMessage();
                    break;
                }
                case 3 : {
                    whatsappSender.sendMessage();
                    break;
                }
                case 4 : {
                    System.out.println("Thank You...");
                    break;
                }
            }
        }while (userInput != 4);
    }
}