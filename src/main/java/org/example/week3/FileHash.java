package org.example.week3;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.Security;
import java.util.Arrays;

public class FileHash {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        int BUF_SIZE = 2048;
        byte[] buffer = new byte[BUF_SIZE];

        MessageDigest digest = MessageDigest.getInstance("SHA256", "BC");

        FileInputStream fileInputStream = new FileInputStream("01.pdf");

        int read;
        while ((read = fileInputStream.read(buffer, 0, BUF_SIZE)) > 0) {
            digest.update(buffer, 0, read);
        }

        byte[] out = digest.digest();

        System.out.println(Arrays.toString(out));

        fileInputStream.close();
    }
}
