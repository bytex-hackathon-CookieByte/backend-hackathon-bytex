package ro.fiipractic.hackathon.jobyfier.util;

public interface IPasswordEncoder {

    public String encode(String password);

    public boolean matches(String plainPassword, String hashedPassword);
}
