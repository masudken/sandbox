package jp.co.gfam.gits.common.crypto;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * このクラスはAESによる暗号化、復号化を行うユーティリティクラスです。
 *
 * @author Kenichi Masuda
 */
public class CipherUtils {

    /**
     * 鍵
     */
    private static String _KEY;

    static {
        // 初回アクセス時、プロパティファイルから鍵を取得
        Properties prop = new Properties();
        try (InputStream input = CipherUtils.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            prop.load(input);
            _KEY = prop.getProperty("cipher.aes.key");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // MIMEデコード用の設定
        System.setProperty("mail.mime.decodetext.strict", "false");
    }

    /**
     * 指定された文字列を暗号化します。
     *
     * @param str 文字列
     * @return 暗号化した文字列
     */
    public static String encrypt(String str) {
        Key skey = new SecretKeySpec(_KEY.getBytes(), "AES");

        String result = null;
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            byte[] binaryData = cipher.doFinal(str.getBytes());
            result = new String(Base64.encodeBase64(binaryData));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 指定された文字列を復号化します。
     *
     * @param str 文字列
     * @return 復号化した文字列
     */
    public static String decrypt(String str) {
        Key skey = new SecretKeySpec(_KEY.getBytes(), "AES");

        String result = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skey);
            byte[] binaryData = cipher.doFinal(Base64.decodeBase64(str));
            return new String(binaryData);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
