package id.ginanjar.authentication.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtility {
    private final static String SALT = "randomstring";

    public static String hash(String string) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(SALT.getBytes());
        return new String(digest.digest(string.getBytes(StandardCharsets.UTF_8)));
    }
}
