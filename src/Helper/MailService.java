package Helper;

import Classes.Product;

import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

public class MailService {

    private static final String EMAIL_ADDRESS = "";
    private static final String EMAIL_PASSWORD = "";
    Session session;

    public MailService() {
        // Configuration of email client
        Properties properties = getSmtpProperties();
        Authenticator authenticator = getAuthenticator();

        // Create a session for sending emails
        session = Session.getInstance(properties, authenticator);
    }

    public void sendEmail(String subject, String message, String userMail) {
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(EMAIL_ADDRESS));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(userMail));
            msg.setSubject(subject);
            msg.setText(message);
            Transport.send(msg);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private Authenticator getAuthenticator() {
        return new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_ADDRESS, EMAIL_PASSWORD);
            }
        };
    }

    private Properties getSmtpProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }

    public void createOrderMessage(String firstname, String lastname,String username) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("Thank you for your order\n");
        sb.append(String.format("Firstname: %s \n", firstname));
        sb.append(String.format("Lastname: %s \n", lastname));
        sb.append(String.format("Username: %s \n", username));
        sb.append("-----------------------------------------------\n");
        for (Product P : Cart.cartProducts) {
            sb.append(String.format("Product Name: %s \n", P.getName()));
            sb.append(String.format("Product Price : %s \n", P.getPriceFormatted()));
            sb.append(String.format("Product ISBN : %s \n", P.getIsbnFormatted()));
            sb.append(String.format("Product Author : %s \n", P.getAuthor()));
            sb.append(String.format("Product Genre : %s \n", P.getGenre()));
            sb.append(String.format("Product Quantity : %s \n", Cart.cartProductQuantity.get(i)));
            sb.append("-----------------------------------------------\n");
            i++;

        }
        sb.append(String.format("Totalprice $ %s \n", Cart.totalPrice));

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(EMAIL_ADDRESS));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(Cart.user.getEmail()));
            msg.setSubject("Order confirmation");
            msg.setText(sb.toString());
            Transport.send(msg);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}