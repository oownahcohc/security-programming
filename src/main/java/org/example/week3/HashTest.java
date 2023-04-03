package org.example.week3;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.CharUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Arrays;

public class HashTest {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
        Security.addProvider(new BouncyCastleProvider());

        MessageDigest hash = MessageDigest.getInstance("SHA256", "BC");

        String input = "soongsil univ";

        hash.update(CharUtils.toByteArray(input.toCharArray()));

        byte[] out = hash.digest();

        byte[] another = hash.digest(CharUtils.toByteArray(input.toCharArray()));

        System.out.println(Arrays.toString(out));
        System.out.println(Arrays.toString(another));

        System.out.println(hash.getDigestLength());
        System.out.println(hash.getAlgorithm());
    }
}
