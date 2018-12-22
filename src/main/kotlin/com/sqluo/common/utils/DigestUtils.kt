package com.sqluo.common.utils

import org.apache.commons.codec.digest.DigestUtils
import java.io.DataInputStream
import java.io.InputStream
import java.io.UnsupportedEncodingException
import java.net.URL
import java.nio.charset.Charset
import java.security.DigestException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*



object DigestUtils {
    val ENCODING = "UTF-8"

    val DIGEST_KEY = "AVuu7SWwv99YCbb11IHlk5ONlq77YXba3HLlp57RRvu99Bbe13HHkk55RQuu99i3"


    fun decodeBase64(data: String): String {
        val _data = data.toByteArray()
        try {
            return String(Base64.getDecoder().decode(_data), Charset.forName(ENCODING))
        } catch (e: UnsupportedEncodingException) {
            throw DigestException("encoding unknow", e)
        }

    }

    fun decodeBase64(data: String, encoding: String): String {
        val _date = data.toByteArray()
        try {
            return String(Base64.getDecoder().decode(_date), Charset.forName(encoding))
        } catch (e: UnsupportedEncodingException) {
            throw DigestException("encoding unknow", e)
        }

    }

    fun encodeBase64(data: String): String {
        val _date = data.toByteArray()
        try {
            return String(Base64.getEncoder().encode(_date), Charset.forName(ENCODING))
        } catch (e: UnsupportedEncodingException) {
            throw DigestException("encoding unknow", e)
        }

    }

    fun encodeBase64ToByte(data: ByteArray): ByteArray {
        try {
            return Base64.getEncoder().encode(data)
        } catch (e: Exception) {
            throw DigestException("encoding unknow", e)
        }

    }

    fun encodeBase64(date: ByteArray): String {
        try {
            return String(Base64.getEncoder().encode(date), Charset.forName(ENCODING))
        } catch (e: UnsupportedEncodingException) {
            throw DigestException("encoding unknow", e)
        }

    }

    fun decodeBase64(date: ByteArray): ByteArray {
        return Base64.getDecoder().decode(date)
    }


    fun encodeBase64(data: String, encoding: String): String {
        val _date = data.toByteArray()
        try {
            return String(Base64.getEncoder().encode(_date), Charset.forName(encoding))
        } catch (e: UnsupportedEncodingException) {
            throw DigestException("encoding unknow", e)
        }

    }

    fun encodeBase64(data: String, byteEncoding: String, encoding: String): String {
        try {
            val _date = data.toByteArray(charset(byteEncoding))
            return String(Base64.getEncoder().encode(_date), Charset.forName(encoding))
        } catch (e: UnsupportedEncodingException) {
            throw DigestException("encoding unknow", e)
        }

    }

    fun randomCode(digit:Int = 6):String {
        val random = Random()
        var sb = StringBuilder()
        for (i in 1..digit)
            sb.append(random.nextInt(10))
        return sb.toString()
    }
    //
    //    public static String md5(String data) {
    //        String _date = M.md5Hex(data);
    //        return _date;
    //    }
    //
    //    public static String md5(byte[] data) {
    //        String _date = org.apache.commons.codec.digest.DigestUtils.md5Hex(data);
    //        return _date;
    //    }
    //
    //    public static String md5(InputStream data) {
    //        String _date = null;
    //        try {
    //            _date = org.apache.commons.codec.digest.DigestUtils.md5Hex(data);
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }
    //        return _date;
    //    }
    //
    //
    //    public static String sha1(String data) {
    //        return org.apache.commons.codec.digest.DigestUtils.sha1Hex(data);
    //    }
    //
    //
    //    public static String urlEncode(String data, String encoding) {
    //        try {
    //            return URLEncoder.encode(data, encoding);
    //        } catch (UnsupportedEncodingException e) {
    //            throw new DigestException("encoding unknow", e);
    //        }
    //    }
    //
    //    public static String urlDecode(String data, String encoding) {
    //        try {
    //            return URLDecoder.decode(data, encoding);
    //        } catch (UnsupportedEncodingException e) {
    //            throw new DigestException("encoding unknow", e);
    //        }
    //    }

//    @Throws(Exception::class)
//    @JvmStatic
//    fun main(args: Array<String>) {
//
//        val s = "3296ea6b33ea7c126c0f6e3078dcf378kgcloud"
//        val s1 = getMD5(s)
//        println(s1)
//
//
//    }

    /**
     * 对字符串md5加密(小写+字母)
     *
     * @param str 传入要加密的字符串
     * @return  MD5加密后的字符串
     */

    fun getMD5(data: String): String {
        var cacheKey: String
        try {
            val mDigest = MessageDigest.getInstance("MD5")
            mDigest.update(data.toByteArray())
            cacheKey = bytesToHexString(mDigest.digest())
        } catch (e: NoSuchAlgorithmException) {
            cacheKey = data.hashCode().toString()
        }

        return cacheKey
    }

    fun bytesToHexString(bytes: ByteArray): String {
        val sb = StringBuilder()
        for (aByte in bytes) {
            val hex = Integer.toHexString(0xFF and aByte.toInt())
            if (hex.length == 1) {
                sb.append('0')
            }
            sb.append(hex)
        }
        return sb.toString()
    }
    /**
     * 对字符串md5加密(大写+数字)
     *
     * @param s 传入要加密的字符串
     * @return  MD5加密后的字符串
     */

    fun MD5(s: String): String? {
        val hexDigits = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

        try {
            val btInput = s.toByteArray()
            // 获得MD5摘要算法的 MessageDigest 对象
            val mdInst = MessageDigest.getInstance("MD5")
            // 使用指定的字节更新摘要
            mdInst.update(btInput)
            // 获得密文
            val md = mdInst.digest()
            // 把密文转换成十六进制的字符串形式
            val j = md.size
            val str = CharArray(j * 2)
            var k = 0
            for (i in 0 until j) {
                val byte0 = md[i].toInt()
                str[k++] = hexDigits[byte0.ushr(4) and 0xf]
                str[k++] = hexDigits[byte0 and 0xf]
            }
            return String(str)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }

    fun randomStr(length:Int = 10): String {
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        val str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890"
        //由Random生成随机数
        val random = Random()
        val sb = StringBuffer()
        //长度为几就循环几次
        for (i in 0 until length) {
            //产生0-61的数字
            val number = random.nextInt(62)
            //将产生的数字通过length次承载到sb中
            sb.append(str[number])
        }
        //将承载的字符转换成字符串
        return sb.toString()

    }

    /**
     * 获取远程url文件的MD5值
     */
    fun getMd5Hex(url: URL): String {
        var urlIS: InputStream? = null
        var dataInputStream: DataInputStream? = null
        try {
            val urlIS = url.openStream()
            val dataInputStream = DataInputStream(urlIS);
            return DigestUtils.md5Hex(dataInputStream);
        } catch (e: Exception) {
            throw e
        } finally {
            dataInputStream?.close();
            urlIS?.close()
        }
    }

}
