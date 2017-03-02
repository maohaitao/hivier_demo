package com.bike.bananacard.common.tools.code;

import com.bike.bananacard.common.constant.Keys;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/11
 * time: 上午12:18
 * description: 加解密处理工具
 */
public class RSAUtils {

    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";


    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;


    /**
     * 私钥解密
     *
     * @param encryptedData 已加密数据
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData)
            throws Exception {
        byte[] keyBytes = Base64.decodeBase64(Keys.PRIVATEKEY.getValue());
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        return getData(cipher, encryptedData, MAX_DECRYPT_BLOCK);
    }

    /**
     * 公钥解密
     *
     * @param encryptedData 已加密数据
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData)
            throws Exception {
        byte[] keyBytes = Base64.decodeBase64(Keys.PUBLICKEY.getValue());
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicK);
        return getData(cipher, encryptedData, MAX_DECRYPT_BLOCK);
    }

    /**
     * 公钥加密
     *
     * @param data 源数据
     * @return byte[]
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(Keys.PUBLICKEY.getValue());
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicK);

        return getData(cipher, data, MAX_ENCRYPT_BLOCK);
    }

    /**
     * 私钥加密
     *
     * @param data 源数据
     * @return byte[]
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data)
            throws Exception {
        byte[] keyBytes = Base64.decodeBase64(Keys.PRIVATEKEY.getValue());
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateK);
        return getData(cipher, data, MAX_ENCRYPT_BLOCK);
    }

    /**
     * 数据处理
     *
     * @param cipher 加解密转换类
     * @param data   加解密数据
     * @return byte[]
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws IOException
     */
    private static byte[] getData(Cipher cipher, byte[] data, int maxValue) throws BadPaddingException, IllegalBlockSizeException, IOException {
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > maxValue) {
                cache = cipher.doFinal(data, offSet, maxValue);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * maxValue;
        }
        byte[] codeData = out.toByteArray();
        out.close();
        return codeData;
    }


}