package com.leo.learn.arch.session11.domain.service;

import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.util.Random;

public class PwdService {

  public static final String PREFLIX = "pwd_";

  /**
   * generate a random string for salt in 5 bits
   *
   * @return
   */
  public String generateSalt() {
    return getRandomString(5);
  }

  /**
   * user orignal pwd and salt to generate encrepted password
   *
   * @param originalPWD
   * @param salt
   * @return
   */
  public String getHashedPassword(String originalPWD, String salt) {
    return encryptMD5(originalPWD, salt);
  }

  private static String encryptMD5(String pwd, String salt) {
    String result = null;
    try {
      pwd = pwd + salt;
      MessageDigest m = MessageDigest.getInstance("MD5");
      m.update(pwd.getBytes("UTF8"));
      byte s[] = m.digest();
      for (int i = 0; i < s.length; i++) {
        result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return PREFLIX + result;
  }


  private static String getRandomString(int length){
    String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random=new Random();
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<length;i++){
      int number=random.nextInt(62);
      sb.append(str.charAt(number));
    }
    return sb.toString();
  }

}
