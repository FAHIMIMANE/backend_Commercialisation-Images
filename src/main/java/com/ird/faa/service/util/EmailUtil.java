package com.ird.faa.service.util;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EmailUtil {
    private String username = "SirIHmprojet@gmail.com";
    private String password = "fpycibpfqkxuznjb";

    public void envoyer(String emailDestination) {
// Etape 1 : Création de la session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
//        try {
//// Etape 2 : Création de l'objet Message
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("aminebouja666@gmail.com"));
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(emailDestination));
//            message.setSubject("Code de confirmation de Compte");
//            message.setText("Bonjour voici votre contrat");
//            MimeBodyPart messageBodyPart = new MimeBodyPart();
//
//            Multipart multipart = new MimeMultipart();
//
//            String file = "C:\\Users\\Toufi\\Desktop\\contrat.pdf";
//            String fileName = "TESTFILE.pdf";
//            DataSource source = new FileDataSource(file);
//            messageBodyPart.setDataHandler(new DataHandler(source));
//            messageBodyPart.setFileName(fileName);
//            multipart.addBodyPart(messageBodyPart);
//            message.setContent(multipart);
//            System.out.println("Sending");
//
//            Transport.send(message);
//// Etape 3 : Envoyer le message
//            System.out.println("Message_envoye");
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress("aminebouja666@gmail.com"));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailDestination));

            // Set Subject: header field
            message.setSubject("Testing Subject");

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText("This is message body");

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "C:\\Users\\Toufi\\Desktop\\contrat.pdf";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
