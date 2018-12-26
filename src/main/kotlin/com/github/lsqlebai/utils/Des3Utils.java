package com.github.lsqlebai.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;

public class Des3Utils {


    private final static String encoding = "utf-8";

    public static byte[] des3EncodeECB(String _key, String _data) {
        try {
            byte[] key = _key.getBytes(encoding);
            byte[] data = _data.getBytes(encoding);
            Key desKey;
            DESedeKeySpec spec = new DESedeKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("desede");
            desKey = keyFactory.generateSecret(spec);
            Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            return cipher.doFinal(data);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public static byte[] des3DecodeECB(String _key, byte[] data) {
        try {
            byte[] key = _key.getBytes(encoding);
            Key desKey;
            DESedeKeySpec spec = new DESedeKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("desede");
            desKey = keyFactory.generateSecret(spec);
            Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            return cipher.doFinal(data);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * service====login
     * salt====612037
     * token====7c0bd4b2568a65cbf2455d729951ef37
     * service====login
     * version====1.0
     * service====login
     * time====1435742989
     * json====={'userName':'admin','password':'25d55ad283aa400af464c76d713c07ad'}
     * data====eaDiolGfKD4YxE6tHHU+3maUGWawGfQTTr+t08i2JZoAI4xYh3IQGhviXH5XWskUWxLmMm4edlFGjLCGthjMGtHnsfcS2kn6
     * appid====81df60eb4b695158
     *
     * @param a
     */
//    public static void main(String[] a) {
////        try {
//////            String data = new String(Des3Utils.des3DecodeECB(DigestUtils.md5("999747"+"5GEYBZMPCRFLH1KU79WXNSOI6DTJQ834"), DigestUtils.decodeBase64("R1xsiLUE3YGTWcnjbmdONFMUme88Xf7otaUcKSdyY6DdTOU6dyRIlBN24us07NDf".getBytes("utf-8"))), "utf-8");
//////            String aaa=DigestUtils.md5("openGetColumn" + "1429694837" + "R1xsiLUE3YGTWcnjbmdONFMUme88Xf7otaUcKSdyY6DdTOU6d+yRIlBN24us07NDf" + 999747 + "2.0" + "5GEYBZMPCRFLH1KU79WXNSOI6DTJQ834");
//////            System.out.println(aaa);
////            byte[] data = "{'userName':'admin','password':'25d55ad283aa400af464c76d713c07ad'}".getBytes(encoding);
////            System.out.println("{'userName':'admin','password':'25d55ad283aa400af464c76d713c07ad'}");
////            String passwd = DigestUtils.md5("612037" + "c1c1bd2f81df60eb4b695158daca8971");
////            System.out.println(DigestUtils.md5("612037" + "c1c1bd2f81df60eb4b695158daca8971").getBytes(encoding).length);
////            String _body = DigestUtils.encodeBase64(Des3Utils.des3EncodeECB(passwd, "{'userName':'admin','password':'25d55ad283aa400af464c76d713c07ad'}"));
//////            Des3Utils.des3EncodeECB(DigestUtils.md5("612037"+"5GEYBZMPCRFLH1KU79WXNSOI6DTJQ834"),"212312312312312");
////            System.out.println(passwd);
////            System.out.println(_body);
//////            String data1 = new String(Des3Utils.des3DecodeECB(DigestUtils.md5("612037"+"c1c1bd2f81df60eb4b695158daca8971"), DigestUtils.decodeBase64("SFqsDqrH6MCOC6a/EB+R4zgnbODm/g48vg5b0oqimEUwnDFn0QAZAfWKtVPox3y+2GnOi9W8cUt8tyIZyssygzLaiItxuXwX".getBytes("utf-8"))), "utf-8");
//////            System.out.println(data1);
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//
//    }
}

