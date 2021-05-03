package ua.com.alevel.servlet.helper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
    public  String hasher(String passwordToHash) {

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

    public String salt(String passwordToSalt){
        char[] characters = passwordToSalt.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            char c = characters[i];
            if (Character.isUpperCase(c)) {
                characters[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                characters[i] = Character.toUpperCase(c);
            }
        }
        String result = new String(characters);
        return result;
    }

    public String pepper(String passwordToPepper){
        char[] characters = passwordToPepper.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            char c = characters[i];
            if (Character.isDigit(c)  ) {
                if(Integer.parseInt(String.valueOf(c)) < 9){
                    Integer intValue = (Integer.parseInt(String.valueOf(c))+1);
                    char character =(char)(intValue+'0');
                    characters[i] =  character ;
                }else {
                    Integer intValue = (Integer.parseInt(String.valueOf(c))-5);
                    char character =(char)(intValue+'0');
                    characters[i] =  character ;
                }
            }
        }
        String result = new String(characters);
        return result;
    }

}
