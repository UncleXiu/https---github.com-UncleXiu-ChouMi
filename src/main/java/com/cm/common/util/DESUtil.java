package com.cm.common.util;

import com.cm.common.interceptor.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.text.AbstractDocument;

/**
 * @项目名： CM
 * @包名： com.cm.common.util
 * @类名： DESUtil
 * @类描述： DES加密类
 * @时间： 2016-9-14
 * @编写者： 修峻青
 */
public class DESUtil {

    /*加密方法*/
    private final static String ALGORITHM = "DES";
    //创建Log日志对象
    public static Logger logger = LoggerFactory.getLogger( DESUtil.class );

    /**
     * 三重加密
     * @return
     */
    public static String GetEncryptResult(String data) throws Exception {
        String Result = encryptTre( encryptTwo( encryptOne( data ) ) );
        return Result;
    }

    /**
     * 三重解密
     * @param data
     * @return
     * @throws Exception
     */
    public static String GetDecryptResult(String data) throws Exception{
        String Result = decryptOne(decryptTwo(decryptTre( data )));
        return Result;
    }

    /**
     * 使用密钥1进行DES解密
     * @param data
     * @return
     * @throws Exception
     */
    private final static String decryptOne(String data) throws Exception {
        return new String(decrypt(hex2byte(data.getBytes()),
                Constant.PASSWORD_CRYPT_KEY_ONE.getBytes()));
    }

    /**
     * 使用密钥2进行DES解密
     * @param data
     * @return
     * @throws Exception
     */
    private final static String decryptTwo(String data) throws Exception {
        return new String(decrypt(hex2byte(data.getBytes()),
                Constant.PASSWORD_CRYPT_KEY_TWO.getBytes()));
    }

    /**
     * 使用密钥3进行DES解密
     * @param data
     * @return
     * @throws Exception
     */
    private final static String decryptTre(String data) throws Exception {
        return new String(decrypt(hex2byte(data.getBytes()),
                Constant.PASSWORD_CRYPT_KEY_TRE.getBytes()));
    }

    /**
     * 使用密钥1进行DES加密
     * @param data
     * @return
     * @throws Exception
     */
    private final static String encryptOne(String data) throws Exception  {
        return byte2hex(encrypt(data.getBytes(), Constant.PASSWORD_CRYPT_KEY_ONE
                .getBytes()));
    }

    /**
     * 使用密钥2进行DES加密
     * @param data
     * @return
     * @throws Exception
     */
    private final static String encryptTwo(String data) throws Exception  {
        return byte2hex(encrypt(data.getBytes(), Constant.PASSWORD_CRYPT_KEY_TWO
                .getBytes()));
    }

    /**
     * 使用密钥3进行DES加密
     * @param data
     * @return
     * @throws Exception
     */
    private final static String encryptTre(String data) throws Exception  {
        return byte2hex(encrypt(data.getBytes(), Constant.PASSWORD_CRYPT_KEY_TRE
                .getBytes()));
    }

    /**
     * 使用指定的密钥进行比特加密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        // 现在，获取数据并加密
        // 正式执行加密操作
        return cipher.doFinal(data);
    }

    /**
     * 使用指定的密钥进行比特解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建一个DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        // 正式执行解密操作
        return cipher.doFinal(data);
    }

    /**
     * 格式化DES密文比特数组
     * @param b
     * @return
     */
    private static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("长度不是偶数");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    /**
     * 格式化DES原文比特数组
     * @param b
     * @return
     */
    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs += stmp;
        }
        return hs.toUpperCase();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(encryptOne( "12345689" ));
    }

}

