package edu.mum.email;

/**
 * Created by Sushan on 8/15/2017.
 */
public interface EmailService {

    public void sendEmail(String to, String subject, String text);
}
