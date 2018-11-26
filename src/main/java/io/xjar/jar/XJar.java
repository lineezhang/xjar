package io.xjar.jar;

import io.xjar.*;
import io.xjar.key.XKey;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;

import java.io.*;

/**
 * Spring Jar 工具类
 *
 * @author Payne 646742615@qq.com
 * 2018/11/26 11:11
 */
public class XJar implements XConstants {

    public static void encrypt(File src, File dest, String password, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        encrypt(src, dest, password, DEFAULT_ALGORITHM, filters);
    }

    public static void encrypt(File src, File dest, String password, String algorithm, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        encrypt(src, dest, password, algorithm, DEFAULT_KEYSIZE, filters);
    }

    public static void encrypt(File src, File dest, String password, String algorithm, int keysize, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        encrypt(src, dest, password, algorithm, keysize, DEFAULT_IVSIZE, filters);
    }

    public static void encrypt(File src, File dest, String password, String algorithm, int keysize, int ivsize, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        try (
                InputStream in = new FileInputStream(src);
                OutputStream out = new FileOutputStream(dest)
        ) {
            encrypt(in, out, password, algorithm, keysize, ivsize, filters);
        }
    }

    public static void encrypt(InputStream in, OutputStream out, String password, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        encrypt(in, out, password, DEFAULT_ALGORITHM, filters);
    }

    public static void encrypt(InputStream in, OutputStream out, String password, String algorithm, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        encrypt(in, out, password, algorithm, DEFAULT_KEYSIZE, filters);
    }

    public static void encrypt(InputStream in, OutputStream out, String password, String algorithm, int keysize, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        encrypt(in, out, password, algorithm, keysize, DEFAULT_IVSIZE, filters);
    }

    public static void encrypt(InputStream in, OutputStream out, String password, String algorithm, int keysize, int ivsize, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        XJarEncryptor xJarEncryptor = new XJarEncryptor(new XJdkEncryptor(algorithm), filters);
        XKey xKey = XKit.key(algorithm, keysize, ivsize, password);
        xJarEncryptor.encrypt(xKey, in, out);
    }

    public static void decrypt(File src, File dest, String password, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        decrypt(src, dest, password, DEFAULT_ALGORITHM, filters);
    }

    public static void decrypt(File src, File dest, String password, String algorithm, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        decrypt(src, dest, password, algorithm, DEFAULT_KEYSIZE, filters);
    }

    public static void decrypt(File src, File dest, String password, String algorithm, int keysize, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        decrypt(src, dest, password, algorithm, keysize, DEFAULT_IVSIZE, filters);
    }

    public static void decrypt(File src, File dest, String password, String algorithm, int keysize, int ivsize, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        try (
                InputStream in = new FileInputStream(src);
                OutputStream out = new FileOutputStream(dest)
        ) {
            decrypt(in, out, password, algorithm, keysize, ivsize, filters);
        }
    }

    public static void decrypt(InputStream in, OutputStream out, String password, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        decrypt(in, out, password, DEFAULT_ALGORITHM, filters);
    }

    public static void decrypt(InputStream in, OutputStream out, String password, String algorithm, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        decrypt(in, out, password, algorithm, DEFAULT_KEYSIZE, filters);
    }

    public static void decrypt(InputStream in, OutputStream out, String password, String algorithm, int keysize, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        decrypt(in, out, password, algorithm, keysize, DEFAULT_IVSIZE, filters);
    }

    public static void decrypt(InputStream in, OutputStream out, String password, String algorithm, int keysize, int ivsize, XEntryFilter<JarArchiveEntry>... filters) throws Exception {
        XJarDecryptor xJarDecryptor = new XJarDecryptor(new XJdkDecryptor(algorithm), filters);
        XKey xKey = XKit.key(algorithm, keysize, ivsize, password);
        xJarDecryptor.decrypt(xKey, in, out);
    }

}