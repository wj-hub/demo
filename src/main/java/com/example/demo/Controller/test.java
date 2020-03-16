package com.example.demo.Controller;

import com.example.demo.Entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {
    public static void main(String args[]) {
        int i = 0;
        while (true) {
            if (i % 3 == 2 && i % 5 == 3 && i % 7 == 2) {
                System.out.println(i);
                break;
            } else {
                i++;
            }
        }
    }
}

