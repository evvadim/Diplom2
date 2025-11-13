package config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final String baseURI;

    private static final String email;
    private static final String userPassword;
    private static final String userName;

    private static final String anotherEmail;
    private static final String anotherUserPassword;
    private static final String anotherUserName;

    static {

        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/java/config/resource.properties"));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        baseURI = properties.getProperty("baseURI");

        email = properties.getProperty("email");
        userPassword = properties.getProperty("userPassword");
        userName = properties.getProperty("userName");

        anotherEmail = properties.getProperty("anotherEmail");
        anotherUserPassword = properties.getProperty("anotherUserPassword");
        anotherUserName = properties.getProperty("anotherUserName");

    }

    public static String getBaseURI() {
        return baseURI;
    }


    public static String getEmail() {
        return email;
    }

    public static String getUserPassword() {
        return userPassword;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getAnotherEmail() {
        return anotherEmail;
    }

    public static String getAnotherUserPassword() {
        return anotherUserPassword;
    }

    public static String getAnotherUserName() {
        return anotherUserName;
    }

}
