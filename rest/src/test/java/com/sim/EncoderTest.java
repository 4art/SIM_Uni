package com.sim;

import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import static org.junit.Assert.assertEquals;

public class EncoderTest {
  @Test
  public void md5Encoder() {

    Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
    String actual = md5PasswordEncoder.encodePassword("!artem..", null);
    String expected = "73515c4a9ef85a6b0deeb325f4ad1520";

    System.out.println("Md5 encoded " + actual);
    assertEquals(actual, expected);
  }
}
