package com.sqluo.common.utils

import org.apache.tomcat.util.http.fileupload.FileUtils
import java.io.File

object FileUtil {
    fun checkPath(path: String) {
        val file = File(path)
        if (!file.exists()) {
            FileUtils.forceMkdir(file)
        }
    }

}
