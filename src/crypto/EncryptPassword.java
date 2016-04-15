/*
 * Copyright (C) 2016 Lartsev
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package crypto;

/**
 *
 * @author Lartsev
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPassword {

    /**
     * 
     * @param password
     * @return
     * @throws NoSuchAlgorithmException 
     */
public static String encryptPassword(String password, String digest)
    throws NoSuchAlgorithmException {
    MessageDigest messageDigest = null;
    if (digest.equals("")) {
        messageDigest = MessageDigest.getInstance("MD5");
    } else {
        messageDigest = MessageDigest.getInstance(digest);
    }
    
        
    byte[] bs;

    messageDigest.reset();
    bs = messageDigest.digest(password.getBytes());

    StringBuilder stringBuilder = new StringBuilder();

    //hex encode the digest
    for (int i = 0; i < bs.length; i++) {
      String hexVal = Integer.toHexString(0xFF & bs[i]);
      if (hexVal.length() == 1) {
        stringBuilder.append("0");
      }
      stringBuilder.append(hexVal);
    }

    return stringBuilder.toString();
  }

  public static void main(String[] args) throws NoSuchAlgorithmException {
    
    /*
    String encryptedPassword = null;
    try {
    
    if (args.length == 0) {
    System.err.println("Usage: java "
    + "net.ensode.glassfishbook.EncryptPassword "
    + "cleartext");
    } else {
    encryptedPassword = encryptPassword(args[0]);
    System.out.println(encryptedPassword);
    }
    } catch (NoSuchAlgorithmException e) {
    e.printStackTrace();
    }*/
    
    String enc = encryptPassword("password", "MD2");
    String enc1 = encryptPassword("password", "MD5");
    String enc2 = encryptPassword("password", "SHA-1");
    //String enc3 = encryptPassword("password", "SHA-128");
    String enc4 = encryptPassword("password", "SHA-256");
    String enc5 = encryptPassword("password", "SHA-512");
    
    
    System.out.println(enc + "\t" + "with length" + "\t" + enc.length());
    System.out.println(enc1 + "\t" + "with length" + "\t" + enc1.length());
    System.out.println(enc2 + "\t" + "with length" + "\t" + enc2.length());
    //System.out.println(enc3 + "\t" + "with length" + "\t" + enc3.length());
    System.out.println(enc4 + "\t" + "with length" + "\t" + enc4.length());
    System.out.println(enc5 + "\t" + "with length" + "\t" + enc5.length());
    
    
  }
}
