package com.bike.bananacard.common.tools.code;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.*;
import java.security.Key;
import java.security.SecureRandom;

public class PBEUtils {

    public static final String ALGORITHM = "PBEWITHMD5andDES";

    /**
     * 迭代次数
     */
    public static final int ITERATION_COUNT = 100;

    /**
     * 盐初始化
     * 盐长度必须为8字节
     *
     * @return byte[] 盐
     */
    public static byte[] initSalt() throws Exception {
        //实例化安全随机数
        SecureRandom random = new SecureRandom();
        //产出盐
        return random.generateSeed(8);
    }

    /**
     * 转换密钥
     *
     * @param password 密码
     * @return Key 密钥
     */
    private static Key toKey(String password) throws Exception {
        //密钥彩礼转换
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        //实例化
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        //生成密钥
        return keyFactory.generateSecret(keySpec);
    }

    /**
     * 加密
     *
     * @param data     待加密数据
     * @param password 密码
     * @param salt     盐
     * @return byte[] 加密数据
     */
    public static byte[] encrypt(byte[] data, String password, byte[] salt) throws Exception {
        //转换密钥
        Key key = toKey(password);
        //实例化PBE参数材料
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
        //实例化
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        //初始化
        cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        //执行操作
        return cipher.doFinal(data);
    }

    public static void encrypt(File file, String password, byte[] salt) throws Exception {
        //转换密钥
        Key key = toKey(password);
        //实例化PBE参数材料
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
        //实例化
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        //初始化
        cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        InputStream is = new FileInputStream(file);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        CipherInputStream cis = new CipherInputStream(is, cipher);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = cis.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        rewrite(file, out.toByteArray());
        cis.close();
        is.close();
        out.close();
    }

    private static void rewrite(File file, byte[] data) throws IOException {
        String path = file.getPath();
        FileOutputStream out = new FileOutputStream(path);
        out.write(data);
        out.close();
    }

    /**
     * 解密
     *
     * @param data     待解密数据
     * @param password 密码
     * @param salt     盐
     * @return byte[] 解密数据
     */
    public static byte[] decrypt(byte[] data, String password, byte[] salt) throws Exception {
        //转换密钥
        Key key = toKey(password);
        //实例化PBE参数材料
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
        //实例化
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        //初始化
        cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        //执行操作
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(File file, String password, byte[] salt) throws Exception {
        //转换密钥
        Key key = toKey(password);
        //实例化PBE参数材料
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
        //实例化
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        //初始化
        cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        InputStream is = new FileInputStream(file);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        CipherOutputStream cos = new CipherOutputStream(out, cipher);
        byte[] buffer = new byte[1024];
        int r;
        while ((r = is.read(buffer)) >= 0) {
            cos.write(buffer, 0, r);
        }
        cos.flush();
        cos.close();
        out.close();
        is.close();
        return out.toByteArray();
    }
}
