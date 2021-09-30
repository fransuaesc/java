import javax.crypto.*;    
import java.security.*;  
 
public class Java {
 
 private static SecretKey key = null;         
 private static Cipher cipher = null; 
 
 public static void main(String[] args) throws Exception
 {
 KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
 keyGenerator.init(128);
 SecretKey secretKey = keyGenerator.generateKey();
 cipher = Cipher.getInstance("AES");
 
 String clearText = "hola";
 byte[] clearTextBytes = clearText.getBytes("UTF8");
 System.out.println("Texto en claro: " + clearText);
 System.out.println("Texto en Bytes claro: " + clearTextBytes);
 
 cipher.init(Cipher.ENCRYPT_MODE, secretKey);
 byte[] cipherBytes = cipher.doFinal(clearTextBytes);
 String cipherText = new String(cipherBytes, "UTF8");
 System.out.println("Texto cifrado: " + cipherText);
 System.out.println("Texto en Bytes cifrado: " + cipherBytes);
 
 cipher.init(Cipher.DECRYPT_MODE, secretKey);
 byte[] decryptedBytes = cipher.doFinal(cipherBytes);
 String decryptedText = new String(decryptedBytes, "UTF8");
 System.out.println("Texto descifrado: " + decryptedText);
 System.out.println("Texto en Bytes cifrado: " + decryptedBytes);
 }
}
