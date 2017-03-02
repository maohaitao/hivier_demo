package com.bike.bananacard.common.tools.code;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/22
 * time: 下午3:42
 * description: 文件加密
 */
public class FileEncrypt {
    private final static String DB_FILE_NAME = ".banana.db";

    public static void encrypt(File file) throws Exception {
        if (file == null || !file.exists()) {
            return;
        }
        File dbFile = new File(file.getParent() + File.separator + DB_FILE_NAME);

        if (dbFile.exists()) {
            return;
        }
        byte[] salt = PBEUtils.initSalt();
        String password = UUID.randomUUID().toString();
        write(dbFile, password.getBytes(), salt);
        PBEUtils.encrypt(file, password, salt);

    }

    private static void write(File file, byte[] password, byte[] salt) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(salt);
        fileOutputStream.write(Base64.encodeBase64(password));
    }

    public static void main(String[] args) throws Exception {
        FileEncrypt.encrypt(new File("/Users/700sfriend/Documents/key/test"));
    }
}
