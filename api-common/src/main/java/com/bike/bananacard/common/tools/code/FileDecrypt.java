package com.bike.bananacard.common.tools.code;

import org.apache.commons.codec.binary.Base64;

import java.io.*;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/22
 * time: 下午3:42
 * description: 文件解密
 */
public class FileDecrypt {
    private final static int SALT_MAX = 8;
    private final static String DB_FILE_NAME = ".banana.db";

    public static String decrypt(File file) throws Exception {
        if (file == null || !file.exists()) {
            return null;
        }
        File dbFile = new File(file.getParent() + File.separator + DB_FILE_NAME);
        if (!file.exists()) {
            return null;
        }
        byte[] db = readDB(dbFile);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(db);
        byte[] salt = new byte[SALT_MAX];
        byte[] password = new byte[db.length - salt.length];
        int result = byteArrayInputStream.read(salt, 0, salt.length);
        while (result != -1) {
            result = byteArrayInputStream.read(password, 0, password.length);
        }

        byte[] data = PBEUtils.decrypt(file, new String(Base64.decodeBase64(password)), salt);
        return new String(data);

    }

    private static byte[] readDB(File file) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        Long size = file.length();
        byte[] db = new byte[size.intValue()];
        int result = inputStream.read(db);
        while (result != -1) {
            result = inputStream.read(db);
        }
        inputStream.close();
        return db;

    }


    public static void main(String[] args) throws Exception {
        System.out.println(FileDecrypt.decrypt(new File("/Users/700sfriend/Documents/key/test")));

    }
}
