package TestnetCreateAccount;
import io.digitalbits.sdk.KeyPair;
import java.net.*;
import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        KeyPair pair = KeyPair.random();
        System.out.println(new String(pair.getSecretSeed()));
        System.out.println(pair.getAccountId());
        String friendbotUrl = String.format(
        "https://frontier.testnet.digitalbits.io/friendbot?addr=%s",
        pair.getAccountId());
       
        try {
            InputStream response = new URL(friendbotUrl).openStream();
            String body = new Scanner(response, "UTF-8").useDelimiter("\\A").next();
            System.out.println("SUCCESS! You have a new account :)\n" + body);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        }
}
