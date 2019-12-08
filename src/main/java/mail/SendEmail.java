package mail;

import hibernate.Employees;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public void sendEmail(String preparedMessage, Employees employees) {

        final String username = "test.kurs.123123@gmail.com";
        final String password = "Test1234@";
        final String messageTitle = "COMPANY - Uwaga! Zmiany w twoich danych osobowych";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(employees.getEmail())
            );
            message.setSubject(messageTitle);
            message.setText(preparedMessage);

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public String prepareMessage(Employees beforeUpdate, Employees afterUptade) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Witaj ").append(afterUptade.getLastName()).append("\n").append(EmailInfo.information);

        if (!beforeUpdate.getLastName().equals(afterUptade.getLastName())) {
            stringBuilder.append("\n Twoje nowe imię: ").append(afterUptade.getLastName());
        }
        if (!beforeUpdate.getFirstName().equals(afterUptade.getFirstName())) {
            stringBuilder.append("\n Twoje nowe nazwisko: ").append(afterUptade.getFirstName());
        }
        if (!beforeUpdate.getAddress().equals(afterUptade.getAddress())) {
            stringBuilder.append("\n Twój nowy adres: ").append(afterUptade.getAddress());
        }
        if (!beforeUpdate.getCity().equals(afterUptade.getCity())) {
            stringBuilder.append("\n Twoje nowe miasto: ").append(afterUptade.getCity());
        }
        if (!beforeUpdate.getAge().equals(afterUptade.getAge())) {
            stringBuilder.append("\n Twój nowy wiek: ").append(afterUptade.getAge());
        }
        if (!beforeUpdate.getSalary().equals(afterUptade.getSalary())) {
            stringBuilder.append("\n Twoje nowe wynagrodzenie: ").append(afterUptade.getSalary());
        }
        if (!beforeUpdate.getStartJobDate().equals(afterUptade.getStartJobDate())) {
            stringBuilder.append("\n Zmieniono twoją datę rozpoczęcia pracy na: ").append(afterUptade.getStartJobDate());
        }

        return stringBuilder.toString();
    }

}
