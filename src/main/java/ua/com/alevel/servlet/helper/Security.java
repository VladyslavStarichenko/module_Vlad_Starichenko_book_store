package ua.com.alevel.servlet.helper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
    public static String hasher(String passwordToHash) {

        String hashed = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] passInBytes = md5.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : passInBytes) {
                hashed = stringBuilder.append(String.format("%02X", b)).toString();
            }
            return hashed;
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
