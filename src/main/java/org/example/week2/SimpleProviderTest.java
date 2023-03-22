package org.example.week2;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

public class SimpleProviderTest {
    public static void main(String[] args) {
        BouncyCastleProvider bouncyCastleProvider = new BouncyCastleProvider();
        Security.addProvider(bouncyCastleProvider);

        String providerName = "BC";
        if (Security.getProvider(providerName) == null) {
            System.out.println(providerName + " provider not installed");
        } else {
            System.out.println(providerName + " is installed");
        }
    }
}
