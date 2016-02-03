package lv.javaguru.java2.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by mike on 1/26/2016.
 */
public class PasswordService {

    public static void sendUserData(HashMap paymentDataMap, String eMail) throws Exception {

        final String username = "PlayTester482@gmail.com";
        final String password = "@Splurgeola$22";
        String messageText = "";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(eMail));

            message.setSubject("User Data");
            messageText = "Received User Data: \n\n";

            Iterator<Map.Entry<Integer, String>> iterator = paymentDataMap.entrySet()
                    .iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, String> entry = iterator.next();
                messageText += entry.getKey() + " : " + entry.getValue() + "\n\n";
            }

            message.setText(messageText);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    public static void sendUserPassword(String userPassword, String eMail) throws Exception {

        final String username = "PlayTester482@gmail.com";
        final String password = "@Splurgeola$22";
        String messageText = "";

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

    //    props.put("mail.setFromAddress", "mike");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(eMail));

            message.setSubject("Received User Password");
            messageText = "Password: " + userPassword;
            message.setText(messageText);
            Transport.send(message);
            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}
