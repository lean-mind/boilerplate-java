package es.leanmind.boilerplate.app.user;

import es.leanmind.boilerplate.helper.MailService;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import javax.mail.MessagingException;

public class MailServiceMocks {
    public void initMocks(MailService mailService) throws MessagingException {
        Mockito.doNothing().when(mailService).sendMail(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
    }
}
