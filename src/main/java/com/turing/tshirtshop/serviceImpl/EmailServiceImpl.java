package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger LOG = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public boolean emailValidator(String email) {
        boolean isValid = false;
        try{
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();

            isValid = true;
        }catch (AddressException ex){
            LOG.debug("Exception occurred for: " + email);
            ex.printStackTrace();
        }
        return isValid;
    }
}
