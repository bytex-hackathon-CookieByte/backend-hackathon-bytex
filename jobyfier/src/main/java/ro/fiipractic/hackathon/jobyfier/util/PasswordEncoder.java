package ro.fiipractic.hackathon.jobyfier.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder implements IPasswordEncoder{

    private final BCryptPasswordEncoder encoder;


    public PasswordEncoder() {
        encoder = new BCryptPasswordEncoder();
    }

    public String encode(String password) {
        return encoder.encode(password);
    }

    public boolean matches(String plainPassword, String hashedPassword) {
        return encoder.matches(plainPassword.trim(), hashedPassword.trim());
    }
}