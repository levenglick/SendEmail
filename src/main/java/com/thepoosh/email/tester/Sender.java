package com.thepoosh.email.tester;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class Sender {

    @Value("SMTP_SERVER")
    private String serverUrl;

    @Value("SMTP_ADMIN_USER")
    private String username;

    @Value("SMTP_ADMIN_PASSWORD")
    private String password;

    @PostConstruct
    public void sendEmail() throws EmailException {
        Email email = new SimpleEmail();
        email.setFrom("test@campusm.com");
        email.setHostName(serverUrl);
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setStartTLSEnabled(true);
        email.setFrom("test@exlibrisgroup.com");
        email.setSubject("Test email");
        email.setContent("this is a test email, feel free to ignore it", "text/html");
        email.addTo("yishai.levenglick@exlibrisgroup.com");
        email.addTo("Payton.Pietron@exlibrisgroup.com");
        email.send();
    }

}
