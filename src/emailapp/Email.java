package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String companySuffix = "mycompany.com";
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;

//    Constructor to receive first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

//     Call method asking for the department - return department
        this.department = setDepartment();

//        Call method that returns random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password: " + this.password);

//        Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
    }

//    Ask for department
    private String setDepartment() {
        System.out.println("DEPARTMENT CODE: \n 1 for Sales\n 2 for Development\n 3 for Accounting \n 0 for none\n Enter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "Sales"; }
        else if (depChoice == 2) { return "Development"; }
        else if (depChoice == 3) { return "Accounting"; }
        else { return ""; }
    }

//    Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$*";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int random = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

//    Set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

//    Set alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

//    Change the password
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "USER NAME: " + firstName + " " + lastName + "\n" +
                "COMPANY EMAIL: " + email + "\n" +
                "MAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
