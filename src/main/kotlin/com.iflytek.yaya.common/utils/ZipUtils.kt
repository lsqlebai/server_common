package com.iflytek.yaya.common.utils

import java.io.BufferedInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.nio.charset.Charset
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

object ZipUtils {
    fun unzip(inputStream: InputStream, dstPath: String) {
        var zis: ZipInputStream? = null
        try {
            var zis = ZipInputStream(BufferedInputStream(inputStream), Charset.forName("GBK"))

            while (true) {
                var entry: ZipEntry? = zis.nextEntry
                if (entry != null) {
                    System.out.println("Extracting: " + entry)
                    var fos = FileOutputStream("${dstPath}/${entry.getName()}").buffered(2048)
                    while (true) {
                        var data = zis.readBytes(2048)
                        if (data.isEmpty()) {
                            break
                        }
                        fos.write(data)
                    }
                    fos.flush()
                    fos.close()
                } else {
                    break
                }
            }
        } finally {
            if (zis != null) {
                zis.close()
            }
        }
    }
}